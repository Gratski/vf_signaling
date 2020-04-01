package com.virtualfit.server.signaling.config

import com.google.gson.Gson
import org.springframework.stereotype.Component
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.handler.TextWebSocketHandler
import java.io.IOException
import java.util.concurrent.CopyOnWriteArrayList


@Component
class SocketHandler : TextWebSocketHandler() {
    var sessions = CopyOnWriteArrayList<Any>()

    @Throws(InterruptedException::class, IOException::class)
    public override fun handleTextMessage(session: WebSocketSession, message: TextMessage) {
        for (webSocketSession in sessions) {
            val value = Gson().fromJson<Map<*, *>>(message.payload, MutableMap::class.java)
            (webSocketSession as WebSocketSession).sendMessage(TextMessage("Hello " + value["name"] + " !"))
        }
    }

    @Throws(Exception::class)
    override fun afterConnectionEstablished(session: WebSocketSession) {
        //the messages will be broadcasted to all users.
        sessions.add(session)
    }
}