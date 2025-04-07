package com.example.veri_saklama_1

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
lateinit var sharedPreferences: SharedPreferences
var kaydedilecekVeri=""
var alinanVeri=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        sharedPreferences = this.getSharedPreferences("com.example.veri_saklama_1", MODE_PRIVATE)
        alinanVeri = sharedPreferences.getString("kullanici","").toString()
        findViewById<TextView>(R.id.textView3).text = alinanVeri

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun kaydet(view: View)
    {
        kaydedilecekVeri = findViewById<EditText>(R.id.editTextText).text.toString()
        sharedPreferences.edit().putString("kullanici",kaydedilecekVeri).apply()
        findViewById<TextView>(R.id.textView3).text = kaydedilecekVeri
    }
    fun sil(view: View)
    {
        sharedPreferences.edit().remove("kullanici").apply()
        alinanVeri = sharedPreferences.getString("kullanici","").toString()
        findViewById<TextView>(R.id.textView3).text = alinanVeri
    }

}