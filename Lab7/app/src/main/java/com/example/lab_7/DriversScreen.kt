package com.example.lab_7

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun DriversScreen(navController: NavController){
    var driverName by remember {
        mutableStateOf("")
    }

    var names = remember {
        mutableStateListOf<String>()
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // back button
            Button(
                onClick = {
                    navController.popBackStack()
                },
                modifier = Modifier.testTag("backButton") // for testing
            ) {
                Text("Back")
            }
            // clear button
            Button(
                onClick = {
                    names.clear()
                },
                modifier = Modifier.testTag("clearButton") // for testing
            ) {
                Text("Clear")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // title text
        Text(
            text = "FormulaZero Drivers",
            fontSize = 30.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        // text field and button to add Driver name
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TextField(
                value = driverName,
                onValueChange = {
                    driverName = it // update driverName to new value
                },
                label = {
                    Text("Driver Name")
                },
                modifier = Modifier.testTag("driverNameInput") // for testing
            )

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {
                    if (driverName.isNotBlank()) {
                        names.add(driverName)
                        driverName = ""
                    }
                },
                modifier = Modifier.testTag("addNameButton") // for testing
            ) {
                Text("Add")
            }
        }

        // list to display Driver names
        LazyColumn {
            items(names) { name ->
                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = name,
                    fontSize = 24.sp
                )
            }
        }
    }

}