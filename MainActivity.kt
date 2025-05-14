package com.example.lazycolumn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lazycolumn.ui.theme.LazyColumnTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumnTheme {
                // Menggunakan Scaffold untuk membungkus konten UI
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    UserList(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun UserList(modifier: Modifier = Modifier, viewModel: UserViewModel = viewModel()) {
    val users = viewModel.users

    // Menampilkan NIM dan Nama
    Text(text = "NIM: 225150401111036 - Nama: Natanael Isaac", modifier = Modifier.padding(16.dp))

    if (users.isEmpty()) {
        Text(text = "Tidak ada data pengguna yang ditemukan", modifier = Modifier.padding(16.dp))
    } else {
        LazyColumn(modifier = modifier) {
            items(users) { user ->
                UserItem(user)
            }
        }
    }
}


@Composable
fun UserItem(user: User) {
    Text(text = "ID: ${user.id} - Name: ${user.name} - Email: ${user.email}", modifier = Modifier.padding(16.dp))
}

