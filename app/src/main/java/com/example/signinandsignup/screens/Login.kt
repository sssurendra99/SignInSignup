package com.example.signinandsignup.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.signinandsignup.R


@ExperimentalMaterial3Api
@Composable
fun Login(navController: NavController){
    Scaffold {ContentPadding ->

        Column(

            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xff2c2b3f))
                .padding(ContentPadding),
        ) {

            Spacer(modifier = Modifier.size(30.dp))

            Box (
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxWidth()
            ){
                Image(
                    painter = painterResource(id = R.drawable.signin),
                    contentDescription = null,
                    modifier = Modifier
                        .width(200.dp)
                )
            }

            Spacer(modifier = Modifier.size(20.dp))

            val email = remember { mutableStateOf(TextFieldValue("")) }
            val passwd = remember {
                mutableStateOf(TextFieldValue(""))
            }



            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, bottom = 20.dp)
            ) {
                Column {

                    Text(
                        text = "Login",
                        color = Color.White,
                        style = TextStyle(
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )

                    Spacer(modifier = Modifier.size(10.dp))

                    Text(
                        text = "Please sign in to continue.",
                        color = Color(0xff908d98)
                    )

                    Spacer(modifier = Modifier.size(20.dp))

                    TextField(
                        value = email.value,
                        leadingIcon = {Icon(Icons.Outlined.Email, contentDescription = null, tint = Color.White)},
                        onValueChange = {
                            email.value = it
                        },
                        label = { Text(text = "EMAIL", color = Color.White, fontSize = 10.sp) },
                        placeholder = { Text(text = "user123@email.com", color = Color.White) },
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color(0xff38304c),
                            textColor = Color(0xffffffff),
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        shape = RoundedCornerShape(10.dp)
                    )

                    Spacer(modifier = Modifier.size(10.dp))

                    val passwdVisible = remember { mutableStateOf(false) }

                    TextField(
                        value = passwd.value,
                        leadingIcon = {Icon(Icons.Outlined.Lock, contentDescription = null, tint = Color.White)},
                        onValueChange = {
                            passwd.value = it
                        },
                        label = { Text(text = "PASSWORD", color = Color.White, fontSize = 10.sp) },
                        placeholder = { Text(text = "********", color = Color.White) },
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color(0xff38304c),
                            textColor = Color(0xffffffff),
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        shape = RoundedCornerShape(10.dp),
                        visualTransformation = if (passwdVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
                        trailingIcon = {
                            val image = if (passwdVisible.value){
                                 R.drawable.visibility_48px
                            }
                            else {
                                 R.drawable.visibility_off_48px
                            }

                            IconButton(onClick = {passwdVisible.value = !passwdVisible.value}){
                                Icon(painter = painterResource(id = image), contentDescription = null, tint = Color.White)
                            }
                        }
                    )




                }
            }

            Spacer(modifier = Modifier.size(20.dp))

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    ElevatedButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .padding(10.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xff6C63FF)
                        )
                    ) {
                        Text(
                            text = "LOGIN",
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center
                            ),
                            modifier = Modifier
                                .width(150.dp)
                                .padding(10.dp)
                        )
                    }

                    Text(
                        text = "Forgot Password?",
                        color = Color(0xff6C63FF),
                        style = TextStyle(
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center
                        )
                    )
                }
            }

            Spacer(modifier = Modifier.size(80.dp))

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Row {
                    Text(
                        text = "Don't have an account?",
                        color = Color(0xff908d98)
                    )

                    
                    ClickableText(
                        text = AnnotatedString("Sign up"),
                        style = TextStyle(
                            color = Color(0xff6C63FF),
                            fontWeight = FontWeight.Bold,
                        ),
                        onClick = {
                            navController.navigate(Screen.Signup.route)
                        }
                    )
                }
            }

        }
        
    }
}



