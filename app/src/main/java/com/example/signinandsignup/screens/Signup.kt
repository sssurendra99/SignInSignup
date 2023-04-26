package com.example.signinandsignup.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Phone
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
fun Signup(navController: NavController){

    Scaffold {ContentPadding ->

        Column(

            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xff2c2b3f))
                .padding(ContentPadding),

        ) {

            Spacer(modifier = Modifier.size(20.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 20.dp)
            ) {

                Icon(
                    Icons.Outlined.ArrowBack,
                    contentDescription = null,
                    tint = Color(0xffa3a3a4),
                    modifier = Modifier
                        .size(width = 50.dp, height = 30.dp)
                        .clickable {
                            navController.navigate(Screen.Login.route)
                        }
                )
            }


            val fullName = remember { mutableStateOf(TextFieldValue("")) }
            val phone = remember { mutableStateOf(TextFieldValue("")) }
            val email = remember { mutableStateOf(TextFieldValue("")) }
            val password = remember { mutableStateOf(TextFieldValue("")) }
            val confPass = remember { mutableStateOf(TextFieldValue("")) }

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, bottom = 20.dp)
            ) {
                Column {


                    Text(
                        text = "Create Account",
                        color = Color.White,
                        style = TextStyle(
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )

                    Spacer(modifier = Modifier.size(10.dp))

                    Text(
                        text = "Please fill the input below here",
                        color = Color(0xff908d98)
                    )

                    Spacer(modifier = Modifier.size(50.dp))

                    // Person

                    TextField(
                        value = fullName.value,
                        leadingIcon = { Icon(Icons.Outlined.Person, contentDescription = null, tint = Color.White) },
                        onValueChange = {
                            fullName.value = it
                        },
                        label = { Text(text = "FULL NAME", color = Color.White, fontSize = 10.sp) },
                        placeholder = { Text(text = "John Williams", color = Color.White) },
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color(0xff38304c),
                            textColor = Color(0xffffffff),
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        shape = RoundedCornerShape(10.dp)
                    )

                    Spacer(modifier = Modifier.size(10.dp))

                    // Phone

                    TextField(
                        value = phone.value,
                        leadingIcon = { Icon(Icons.Outlined.Phone, contentDescription = null, tint = Color.White) },
                        onValueChange = {
                            phone.value = it
                        },
                        label = { Text(text = "PHONE", color = Color.White, fontSize = 10.sp) },
                        placeholder = { Text(text = "+94*********", color = Color.White) },
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color(0xff38304c),
                            textColor = Color(0xffffffff),
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        shape = RoundedCornerShape(10.dp)
                    )

                    Spacer(modifier = Modifier.size(10.dp))

                    // Email

                    TextField(
                        value = email.value,
                        leadingIcon = { Icon(Icons.Outlined.Email, contentDescription = null, tint = Color.White) },
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
                        value = password.value,
                        leadingIcon = { Icon(Icons.Outlined.Lock, contentDescription = null, tint = Color.White) },
                        onValueChange = {
                            password.value = it
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

                    Spacer(modifier = Modifier.size(10.dp))

                    // Confirm Password
                    TextField(
                        value = confPass.value,
                        leadingIcon = { Icon(Icons.Outlined.Lock, contentDescription = null, tint = Color.White) },
                        onValueChange = {
                            confPass.value = it
                        },
                        label = { Text(text = "CONFIRM PASSWORD", color = Color.White, fontSize = 10.sp) },
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

            Spacer(modifier = Modifier.size(10.dp))

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
                            text = "SIGN UP",
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

                }
            }

            Spacer(modifier = Modifier.size(40.dp))

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Row {
                    Text(
                        text = "Already have an account?",
                        color = Color(0xff908d98)
                    )
                    Text(
                        text = "Sign in",
                        color = Color(0xff6C63FF),
                        style = TextStyle(
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier
                            .clickable {
                                navController.navigate(Screen.Login.route)
                            }
                    )
                }
            }

        }

    }


}


