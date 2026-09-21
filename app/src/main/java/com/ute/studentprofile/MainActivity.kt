package com.ute.studentprofile

import com.ute.studentprofile.viewmodel.StudentViewModel
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.ute.studentprofile.databinding.ActivityMainBinding
import com.ute.studentprofile.utils.show

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // Khởi tạo ViewModel theo chuẩn kiến trúc MVVM
    private val viewModel: StudentViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Quan sát dữ liệu từ ViewModel để đưa lên giao diện
        viewModel.studentInfo.observe(this) { info ->
            binding.tvWelcome.apply {
                show() // Dùng extension từ thư mục utils
                text = info
            }
        }
    }
}