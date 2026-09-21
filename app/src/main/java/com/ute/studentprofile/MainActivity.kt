package com.ute.studentprofile

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ute.studentprofile.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        displayStudentInfo("Nguyễn Quang Nhật", 3.75, "2415053122226@sv.ute.udn.vn" +
                "")
        calculateAndAudit(3.75)
    }

    private fun displayStudentInfo(name: String, gpa: Double, email: String) {
        with(binding) {
            tvWelcome.text = "Chào mừng, $name! - MSSV: 2415053122226"
        }
    }

    private fun openDetailActivity(studentId: String) {
        val detailIntent = Intent(this, MainActivity::class.java).apply {
            putExtra("KEY_STUDENT_ID", studentId)
            putExtra("KEY_TIMESTAMP", System.currentTimeMillis())
            flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
        }
        startActivity(detailIntent)
    }

    private fun processAvatarUri(avatarUri: Uri?) {
        avatarUri?.let { validUri ->
            Toast.makeText(this, "Đã nhận URI ảnh hợp lệ", Toast.LENGTH_SHORT).show()
        } ?: run {
            Toast.makeText(this, "Chưa có ảnh đại diện", Toast.LENGTH_SHORT).show()
        }
    }

    private fun calculateAndAudit(rawScore: Double): Double {
        return (rawScore * 10.0 / 4.0)
            .also { finalScore ->
                Log.d("STUDENT_AUDIT", "Điểm hệ 10 quy đổi: $finalScore")
            }
    }
}