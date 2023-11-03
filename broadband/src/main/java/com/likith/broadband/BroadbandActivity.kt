package com.likith.broadband

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.likith.common.BaseActivity
import com.likith.common.ui.theme.MultiModuleArchitectureAppTheme
import com.likith.common.ui.theme.Typography
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.MutableStateFlow

@AndroidEntryPoint
class BroadbandActivity : BaseActivity() {

    private val uiState = MutableStateFlow<String?>(null)

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MultiModuleArchitectureAppTheme {
                Scaffold(
                    topBar = { TopAppBar(title = { Text("Broadband") }) },
                    content = {
                        Content(uiState.collectAsState().value)
                    }
                )
            }
        }
    }

    @Composable
    fun Content(result: String?) {
        var argument by remember { mutableStateOf("") }
        Column {
            TextField(
                value = argument,
                onValueChange = { argument = it },
                label = { Text("Argument") },
                modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp)
            )
            Button(
                onClick = {
                    contracts.profileModuleContract.launch(null)
                },
                content = { Text("Navigate to Profile Module") },
                modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp)
            )
            if (result != null) {
                Divider(modifier = Modifier.padding(top = 16.dp))
                Text(
                    "Result from Feature 2:",
                    modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp)
                )
                Text(
                    result,
                    style = Typography.body2,
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                )
            }
            Divider(modifier = Modifier.padding(top = 16.dp))
            Button(
                onClick = {
                    contracts.historyModuleContract.launch(null)
                },
                content = { Text("Navigate to History module") },
                modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp)
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun ContentNoResult() {
        Content(null)
    }

    @Preview(showBackground = true)
    @Composable
    fun ContentWithResult() {
        Content("Value")
    }

}