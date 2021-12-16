package com.geektech.homework1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.geektech.homework1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result: ActivityResult ->
        if (result.resultCode == RESULT_OK && result.data != null) {
            val intent = result.data?.getStringExtra(KEY)
            binding.editText.setText(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btn.setOnClickListener {
            transition()
        }
    }

    private fun transition() {
        if (binding.editText.text.toString().isEmpty()) {
            Toast.makeText(this, "Введите значение", Toast.LENGTH_SHORT).show()
        } else {
            val init = Intent(this, SecondActivity::class.java)
            init.putExtra(KEY, binding.editText.text.toString())
            resultLauncher.launch(init)
        }
    }
    companion object{
        const val KEY ="key"
    }
}