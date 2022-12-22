package com.example.lesson61

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.URLUtil
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.lesson61.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var list = mutableListOf<String>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadData()
        initClicker()
    }

    private fun initClicker() {
        with(binding) {
            btnSubmit.setOnClickListener {
                if (etUrl.text.isNotEmpty() && URLUtil.isValidUrl(etUrl.text.toString())) {
                    list.add(etUrl.text.toString())
                    etUrl.text.clear()
                } else {
                    Toast.makeText(this@MainActivity, "Enter Url", Toast.LENGTH_SHORT).show()
                }
            }

            btnRandom.setOnClickListener {
                Glide.with(this@MainActivity).load(list.random()).into(ivUrl)
            }
        }
    }

    private fun loadData() {
        list.add("https://i.pinimg.com/564x/89/c1/61/89c161f486f0328c37e3ceb42f082453.jpg")
        list.add("https://i.pinimg.com/750x/a7/45/0c/a7450c7e9300244beaafba408f276159.jpg")
        list.add("https://i.pinimg.com/750x/97/af/8d/97af8d4e2723ac1d10cba3ee8b6773c2.jpg")
        list.add("https://i.pinimg.com/564x/85/88/3f/85883ff7eec461580e8b4461b4c16d8c.jpg")
        list.add("https://i.pinimg.com/564x/e2/a2/77/e2a27764ae24cd21f5eb6642b117aeb1.jpg")
    }
}