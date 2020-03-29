package com.virtualfit.server.signaling.socket

import java.io.IOException
import javax.websocket.*

@ClientEndpoint
class TestEndPoint : Endpoint() {

    override fun onOpen(session: Session, config: EndpointConfig?) {
        val remote: RemoteEndpoint.Basic = session.basicRemote
        remote.sendText("abcdbcbdcbdb")
        session.addMessageHandler(MessageHandler.Whole<String?>() {
            fun onMessage(text: String) {
                try {
                    remote.sendText("Got your message ($text). Thanks !")
                } catch (ioe: IOException) {
                    // handle send failure here
                }
            }
        })
    }
}