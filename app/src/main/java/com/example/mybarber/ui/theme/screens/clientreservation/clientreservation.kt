package com.example.mybarber.ui.theme.screens.clientreservation

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.FlowColumnScopeInstance.align
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mybarber.data.AuthViewModel
import com.example.mybarber.data.ReservationViewModel
import androidx.compose.runtime.collectAsState
//import androidx.compose.runtime.livedata.observeAsState

@Composable
fun ClientReservationScreen(navController: NavController) {

    val authViewModel: AuthViewModel = viewModel()
    val isLoading by authViewModel.isLoading.collectAsState()
    val context = LocalContext.current
    var firstname by remember {
        mutableStateOf(value = "")
    }
    var lastname by remember {
        mutableStateOf(value = "")
    }
    var time by remember {
        mutableStateOf(value = "")
    }
    var date by remember {
        mutableStateOf(value = "")
    }
    var id by remember {
        mutableStateOf(value = "")
    }
    Scaffold (
        bottomBar = {
            BottomAppBar(
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.Home, contentDescription = "Home")

                    }


                }

            )


        }
    ){ innerPadding ->
        Column(modifier = Modifier.padding(innerPadding).fillMaxWidth()
            .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "BOOK YOUR SESSION HERE",
                fontSize = 25.sp,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .background(Color.White)
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                value = firstname,
                onValueChange = { newFirstname -> firstname = newFirstname },
                placeholder = { Text(text = "Enter First Name") },
                label = { Text(text = "Enter First Name") },
                modifier = Modifier
                    .wrapContentWidth()
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                value = lastname,
                onValueChange = { newLastname -> lastname = newLastname },
                placeholder = { Text(text = "Enter Last Name") },
                label = { Text(text = "Enter Last Name") },
                modifier = Modifier
                    .wrapContentWidth()
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                value = time,
                onValueChange = { newTime -> time = newTime },
                placeholder = { Text(text = "Enter your session's time") },
                label = { Text(text = "Enter your session's time") },
                modifier = Modifier
                    .wrapContentWidth()
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                value = date,
                onValueChange = { newDate -> date = newDate },
                placeholder = { Text(text = "Enter session date") },
                label = { Text(text = "Enter session date") },
                modifier = Modifier
                    .wrapContentWidth()
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = {
                    val clientRepository = ReservationViewModel()
                    clientRepository.saveReservation(
                        firstname = firstname,
                        lastname = lastname,
                        time = time,
                        date = date,
                        id = id,
                        navController = navController,
                        context   = context
                    )


                },
                enabled = !isLoading,
                colors = ButtonDefaults.buttonColors(Color.Black)
            ) {
                if (isLoading){
                    CircularProgressIndicator(color = Color.Black, strokeWidth = 4.dp)

                }else{
                    Text(
                        modifier = Modifier.padding(10.dp),
                        color = Color.White,
                        text = "BOOK SESSION"
                    )

                }






            }

        }
    }







}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ClientReservationScreenPreview(){
    ClientReservationScreen(rememberNavController())
}




