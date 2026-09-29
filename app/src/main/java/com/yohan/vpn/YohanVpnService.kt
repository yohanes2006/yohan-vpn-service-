package com.yohan.vpn

import android.content.Intent
import android.net.VpnService

class YohanVpnService : VpnService() {
    private var iface: android.os.ParcelFileDescriptor? = null
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (intent?.action == "CONNECT") {
            iface?.close()
            iface = Builder().setSession("Yohan VPN Service").addAddress("10.8.0.2", 32).addRoute("0.0.0.0", 0).establish()
        } else if (intent?.action == "DISCONNECT") stopSelf()
        return START_STICKY
    }
    override fun onDestroy() { iface?.close(); iface = null; super.onDestroy() }
}
