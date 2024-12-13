package com.example.shopapp.websocket

import org.java_websocket.client.WebSocketClient
import org.java_websocket.handshake.ServerHandshake
import java.net.URI

class WebSocketService(private val listener: WebSocketListener) {

    private var webSocketClient: WebSocketClient? = null

    fun connect() {
        val serverUri = URI("")
        webSocketClient = object : WebSocketClient(serverUri) {
            override fun onOpen(handshakedata: ServerHandshake?) {
                listener.onConnected()
            }

            override fun onMessage(message: String?) {
                listener.onMessageReceived(message ?: "")
            }

            override fun onClose(code: Int, reason: String?, remote: Boolean) {
                listener.onDisconnected()
            }

            override fun onError(ex: Exception?) {
                listener.onError(ex)
            }
        }

        webSocketClient?.connect()
    }

    fun sendMessage(message: String) {
        webSocketClient?.send(message)
    }

    fun disconnect() {
        webSocketClient?.close()
    }

    interface WebSocketListener {
        fun onConnected()
        fun onMessageReceived(message: String)
        fun onDisconnected()
        fun onError(ex: Exception?)
    }
}
