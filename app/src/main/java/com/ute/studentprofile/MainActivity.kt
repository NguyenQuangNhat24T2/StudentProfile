package com.example.studentprofile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.studentprofile.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Bước 1: Khai báo biến binding với lateinit var
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Bước 2: Nạp layout XML thông qua hàm inflate() của ActivityMainBinding
        binding = ActivityMainBinding.inflate(layoutInflater)

        // Bước 3: Truyền root view vào setContentView thay vì dùng R.layout.activity_main
        setContentView(binding.root)

        // Bước 4: Thao tác View trực tiếp thông qua biến binding (Không cần findViewById)
        binding.tvWelcome.text = "Chào mừng bạn đến với ViewBinding!"
    }
}