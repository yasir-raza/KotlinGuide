package com.kotlin.databinding

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.kotlin.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private val myName : MyName = MyName("Yasir Raza")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName
        binding.btnName.setOnClickListener {
            nameClick(it)
        }
    }
    private fun nameClick(view: View) {
        binding.apply {
//            myName?.nickname = binding.nameText.toString()
            myName?.name = binding.nameText.text.toString()
//            binding.nametv.text = binding.nameText.text
            invalidateAll()
        }
        //Hide the keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
