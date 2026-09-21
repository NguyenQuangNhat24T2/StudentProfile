package com.ute.studentprofile.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.util.Log

class StudentViewModel : ViewModel() {

    private val _studentInfo = MutableLiveData<String>()
    val studentInfo: LiveData<String> get() = _studentInfo

    private val _convertedScore = MutableLiveData<Double>()
    val convertedScore: LiveData<Double> get() = _convertedScore

    init {
        loadStudentData()
    }

    private fun loadStudentData() {
        // Thông tin sinh viên hiển thị lên giao diện
        _studentInfo.value = "Chào mừng, Nguyễn Quang Nhật! - MSSV: 2415053122226"

        // Thực hiện logic quy đổi điểm ngay trong ViewModel
        calculateAndAudit(3.75)
    }

    // Đưa logic quy đổi điểm hệ 4 sang hệ 10 vào ViewModel theo chuẩn MVVM
    fun calculateAndAudit(rawScore: Double) {
        val finalScore = rawScore * 10.0 / 4.0
        _convertedScore.value = finalScore
        Log.d("STUDENT_AUDIT", "Điểm hệ 10 quy đổi: $finalScore")
    }
}