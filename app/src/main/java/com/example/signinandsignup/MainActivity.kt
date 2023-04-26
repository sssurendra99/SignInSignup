package com.example.signinandsignup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.signinandsignup.screens.Login
import com.example.signinandsignup.screens.Screen
import com.example.signinandsignup.screens.Signup

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    @ExperimentalMaterial3Api
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Navigation()
        }
    }
}


@ExperimentalMaterial3Api
@Composable
fun Navigation(){

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Login.route ){
        composable(route = Screen.Login.route){
            Login(navController = navController)
        }
        composable(route = Screen.Signup.route){
            Signup(navController = navController)
        }
    }
}