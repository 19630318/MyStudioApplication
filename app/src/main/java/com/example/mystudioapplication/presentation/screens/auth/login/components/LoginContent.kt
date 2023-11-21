package com.example.mystudioapplication.presentation.screens.auth.login.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.mystudioapplication.presentation.components.DefaultButton
import com.example.mystudioapplication.presentation.components.DefaultTextField
import com.example.mystudioapplication.presentation.navigation.Graph
import com.example.mystudioapplication.presentation.navigation.screen.auth.AuthScreen
import com.example.mystudioapplication.presentation.navigation.screen.client.ClientScreen
import com.example.mystudioapplication.presentation.screens.auth.login.LoginViewModel

@Composable
fun LoginContent(
    paddingValues: PaddingValues,
    navHostController: NavHostController,
    vm: LoginViewModel = hiltViewModel()
) {

    val state = vm.state
    val context = LocalContext.current

    /*LaunchedEffect(key1 = vm.errorMessage){
        if(vm.errorMessage != ""){
            Toast.makeText(context, vm.errorMessage, Toast.LENGTH_LONG).show()
            vm.errorMessage = ""
        }
    }*/

    Box(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.onBackground)
    ) {
        /*Image(
            painter = painterResource(id = R.drawable.banner),
            contentDescription = "Imagen de Fondo",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply {
                setToScale(.5f, .5f, .5f, 1f)
            })
        )*/
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                modifier = Modifier.padding(top = 7.dp),
                text = stringResource(com.example.mystudioapplication.R.string.app_name),
                color = MaterialTheme.colorScheme.background,
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(10.dp))
            Image(
                painter = painterResource(id = com.example.mystudioapplication.R.drawable.kfc),
                contentDescription = "Imagen de Fondo",
                modifier = Modifier.size(170.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.weight(1f))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(380.dp),
                shape = RoundedCornerShape(topEnd = 30.dp, topStart = 30.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.background.copy(alpha = 0.8f))
            ) {
                Column(
                    modifier = Modifier
                        .padding(top = 30.dp, end = 30.dp, start = 30.dp)
                        .verticalScroll(
                            rememberScrollState()
                        )
                ) {
                    Text(
                        modifier = Modifier.padding(bottom = 20.dp),
                        text = stringResource(com.example.mystudioapplication.R.string.title_login),
                        style = MaterialTheme.typography.titleMedium
                    )
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.email,
                        onValueChange = {
                            vm.onEmailInput(it)
                        },
                        label = stringResource(com.example.mystudioapplication.R.string.user_email),
                        icon = Icons.Default.Email,
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Email,
                            imeAction = ImeAction.Next
                        )
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.password,
                        onValueChange = {
                            vm.onPasswordInput(it)
                        },
                        label = stringResource(com.example.mystudioapplication.R.string.password),
                        icon = Icons.Default.Lock,
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Password,
                            imeAction = ImeAction.Next
                        )
                    )
                    Spacer(modifier = Modifier.height(25.dp))
                    DefaultButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        text = stringResource(com.example.mystudioapplication.R.string.sing_in),
                        onClick = {
                            vm.saveLogin()
                        },
                        enable = true
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 17.dp), horizontalArrangement = Arrangement.Center
                    ) {
                        Text(text = stringResource(com.example.mystudioapplication.R.string.not_accont))
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            modifier = Modifier.clickable { navHostController.navigate(route = AuthScreen.Register.router) },
                            text = stringResource(com.example.mystudioapplication.R.string.sing_up),
                            color = MaterialTheme.colorScheme.primary,
                            textDecoration = TextDecoration.Underline,
                        )
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                }
            }
        }
    }
}