package com.example.testaccessibilityhelper

import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    val ENABLE_HOTSPOT : String = "kdusouza.com.br.acessibilityhelper.SET_HOTSPOT_CONFIG.enable"
    val DISABLE_HOTSPOT : String = "kdusouza.com.br.acessibilityhelper.SET_HOTSPOT_CONFIG.disable"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btAtivar.setOnClickListener { ativar() }

        btDesativar.setOnClickListener { desativar() }
    }

    fun ativar() {
        val intent = Intent()
        intent.action = ENABLE_HOTSPOT
        intent.putExtra("placa", edPlaca.text.toString())
        intent.putExtra("senha", edSenha.text.toString())
        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES)
        intent.component = ComponentName("kdusouza.com.br.acessibilityhelper", "kdusouza.com.br.acessibilityhelper.broadcast.EDHotSpotReceiver")
        sendBroadcast(intent)
    }

    fun desativar() {
        val intent = Intent()
        intent.action = DISABLE_HOTSPOT
        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES)
        intent.component = ComponentName("kdusouza.com.br.acessibilityhelper", "kdusouza.com.br.acessibilityhelper.broadcast.EDHotSpotReceiver")
        sendBroadcast(intent)
    }
}
