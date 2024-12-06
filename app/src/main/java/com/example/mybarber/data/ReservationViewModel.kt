package com.example.mybarber.data

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.mybarber.models.Client
import com.example.mybarber.navigation.ROUTE_HOME_PAGE
import com.example.mybarber.navigation.ROUTE_VIEW_RESERVATIONS
import com.example.mybarber.ui.theme.screens.clientreservation.ClientReservationScreen
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ReservationViewModel(): ViewModel() {
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    private val _successMessage = MutableLiveData<String>()
    val successMessage: LiveData<String> get() = _successMessage

    fun saveReservation(firstname: String, lastname: String,
                   time: String, date: String, id: String, navController: NavController, context: Context
    ){
        val id = System.currentTimeMillis().toString()
        val dbRef = FirebaseDatabase.getInstance().getReference("SESSIONS/$id")

        val clientData = Client(firstname, lastname, time, date, id)

        dbRef.setValue(clientData)
            .addOnCompleteListener{ task ->
                if(task.isSuccessful){
                    showToast("Session booked successfully",context)
                    navController.navigate(ROUTE_VIEW_RESERVATIONS)

                }else{
                    showToast("Session not booked successfully",context)
                }

            }

    }

    fun viewReservations(client: MutableState<Client>,
                    clients: SnapshotStateList<Client>, context: Context):
            SnapshotStateList<Client> {
        val ref = FirebaseDatabase.getInstance().getReference()
            .child("SESSIONS")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot){
                clients.clear()
                for(snap in snapshot.children){
                    val value = snap.getValue(Client::class.java)
                    client.value = value!!
                    clients.add(value)
                }
            }
            override fun onCancelled(error: DatabaseError){
                showToast("Failed to fetch clients,",context)
            }
        })
        return clients

    }




}

public fun showToast(message: String, context: Context){
    Toast.makeText(context,message, Toast.LENGTH_LONG).show()
}