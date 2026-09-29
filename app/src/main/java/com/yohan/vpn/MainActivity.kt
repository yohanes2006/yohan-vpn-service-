package com.yohan.vpn

import android.app.Activity
import android.content.Intent
import android.net.VpnService
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : Activity() {
    private lateinit var status: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val layout = android.widget.LinearLayout(this).apply { orientation = android.widget.LinearLayout.VERTICAL; setPadding(48,80,48,48) }
        val title = TextView(this).apply { text = "Yohan VPN Service"; textSize = 28f }
        status = TextView(this).apply { text = "Status: Disconnected"; textSize = 18f; setPadding(0,40,0,40) }
        val button = Button(this).apply { text = "CONNECT VPN" }
        layout.addView(title); layout.addView(status); layout.addView(button); setContentView(layout)
        button.setOnClickListener {
            val prepare = VpnService.prepare(this)
            if (prepare != null) startActivityForResult(prepare, 10)
            else startService(Intent(this, YohanVpnService::class.java).setAction("CONNECT"))
            status.text = "Status: Connecting..."
        }
    }
}
