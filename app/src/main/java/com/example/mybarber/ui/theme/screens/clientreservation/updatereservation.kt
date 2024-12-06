package com.example.mybarber.ui.theme.screens.clientreservation

//import android.net.Uri
//import android.widget.Toast
//import androidx.activity.compose.rememberLauncherForActivityResult
//import androidx.activity.result.contract.ActivityResultContracts
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxHeight
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.wrapContentWidth
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Home
//import androidx.compose.material3.BottomAppBar
//import androidx.compose.material3.Button
//import androidx.compose.material3.ButtonDefaults
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.OutlinedTextField
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.DisposableEffect
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.saveable.rememberSaveable
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.text.font.FontStyle
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavController
//import androidx.navigation.compose.rememberNavController
//import com.example.mybarber.R
//import com.example.mybarber.data.ReservationViewModel
//import com.example.mybarber.models.Client
//import com.google.firebase.database.DataSnapshot
//import com.google.firebase.database.DatabaseError
//import com.google.firebase.database.FirebaseDatabase
//import com.google.firebase.database.ValueEventListener
//
//
//@Composable
//fun UpdateReservationScreen(navController: NavController,){
//
//
//
//
//    var firstname by remember {
//        mutableStateOf(value = "")
//    }
//    var lastname by remember {
//        mutableStateOf(value = "")
//    }
//    var time by remember {
//        mutableStateOf(value = "")
//    }
//    var date by remember {
//        mutableStateOf(value = "")
//    }
//
//    val context = LocalContext.current
//
//
//
//    Scaffold (
//        bottomBar = {
//            BottomAppBar(
//                actions = {
//                    IconButton(onClick = { /*TODO*/ }) {
//                        Icon(Icons.Filled.Home, contentDescription = "Home")
//
//                    }
//
//
//                }
//
//            )
//
//
//        }
//    ){ innerPadding ->
//        Column(modifier = Modifier.padding(innerPadding).fillMaxWidth()
//            .fillMaxHeight(),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally) {
//            Text(
//                text = "UPDATE YOUR SESSION DETAILS HERE",
//                fontSize = 25.sp,
//                fontStyle = FontStyle.Normal,
//                fontWeight = FontWeight.Bold,
//                textAlign = TextAlign.Center,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(10.dp)
//                    .background(Color.White)
//            )
//            Spacer(modifier = Modifier.height(10.dp))
//            OutlinedTextField(
//                value = firstname,
//                onValueChange = { newFirstname -> firstname = newFirstname },
//                placeholder = { Text(text = "Enter First Name") },
//                label = { Text(text = "Enter First Name") },
//                modifier = Modifier
//                    .wrapContentWidth()
//                    .align(Alignment.CenterHorizontally)
//            )
//            Spacer(modifier = Modifier.height(10.dp))
//            OutlinedTextField(
//                value = lastname,
//                onValueChange = { newLastname -> lastname = newLastname },
//                placeholder = { Text(text = "Enter Last Name") },
//                label = { Text(text = "Enter Last Name") },
//                modifier = Modifier
//                    .wrapContentWidth()
//                    .align(Alignment.CenterHorizontally)
//            )
//            Spacer(modifier = Modifier.height(10.dp))
//            OutlinedTextField(
//                value = time,
//                onValueChange = { newTime -> time = newTime },
//                placeholder = { Text(text = "Enter your session's time") },
//                label = { Text(text = "Enter your session's time") },
//                modifier = Modifier
//                    .wrapContentWidth()
//                    .align(Alignment.CenterHorizontally)
//            )
//            Spacer(modifier = Modifier.height(10.dp))
//            OutlinedTextField(
//                value = date,
//                onValueChange = { newDate -> date = newDate },
//                placeholder = { Text(text = "Enter session date") },
//                label = { Text(text = "Enter session date") },
//                modifier = Modifier
//                    .wrapContentWidth()
//                    .align(Alignment.CenterHorizontally)
//            )
//            Spacer(modifier = Modifier.height(10.dp))
//            Button(
//                onClick = {
//
//
//
//                },
//
//                colors = ButtonDefaults.buttonColors(Color.Black)
//            ) {
//
//                Text(
//                    modifier = Modifier.padding(10.dp),
//                    color = Color.White,
//                    text = "UPDATE SESSION DETAILS"
//                )
//
//
//
//
//            }
//
//        }
//    }
//}
//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun UpdateReservationScreenPreview(){
//    UpdateReservationScreen(rememberNavController())
//}