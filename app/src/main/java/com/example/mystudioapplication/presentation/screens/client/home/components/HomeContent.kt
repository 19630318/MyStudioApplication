package com.example.mystudioapplication.presentation.screens.client.home.components

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.mystudioapplication.R
import com.example.mystudioapplication.domain.model.MenuNetwork
import com.example.mystudioapplication.presentation.MainActivity
import com.example.mystudioapplication.presentation.components.DefaultButton
import com.example.mystudioapplication.presentation.screens.client.home.HomeViewModel

@Composable
fun HomeContent(data: MenuNetwork,paddingValues: PaddingValues, navHostController: NavHostController, vm: HomeViewModel = hiltViewModel()) {

    val activity = LocalContext.current as? Activity
    val scroll = rememberScrollState()

    Column(
        modifier = Modifier.fillMaxSize().padding(paddingValues).background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row (
            modifier = Modifier.fillMaxWidth().padding().padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(text = stringResource(R.string.title_products), style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = {
                vm.borrardatos()
                activity?.finish()
                activity?.startActivity(Intent(activity, MainActivity::class.java))
            }){
                Icon(imageVector = Icons.Default.ExitToApp, contentDescription = "")
            }
        }
        LazyColumn() {
            items(data.items) {
                ProductsItem(it)
            }
        }
    }
}