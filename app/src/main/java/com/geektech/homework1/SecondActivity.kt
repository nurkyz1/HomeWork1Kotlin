package com.geektech.homework1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.geektech.homework1.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val text = intent.getStringExtra(MainActivity.KEY)
        binding.editText.setText(text)
        transition()
    }

    private fun transition() {
        if (binding.editText.text.toString().isEmpty()) {
            Toast.makeText(this, "Введите значение", Toast.LENGTH_SHORT).show()
        } else {
            val data = Intent()
            data.putExtra(MainActivity.KEY, binding.editText.text.toString())
            setResult(Activity.RESULT_OK, data)
            finish()
        }
    }
}