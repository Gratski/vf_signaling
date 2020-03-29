package com.virtualfit.server.signaling.controller

import com.virtualfit.server.signaling.domain.signaling.SignalingMessageIn
import com.virtualfit.server.signaling.domain.signaling.SignalingMessageOut
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.handler.annotation.DestinationVariable
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Controller

@Controller
class SignalingMessageHandler {

    @Autowired
    lateinit var template: SimpMessagingTemplate;

    /**
     * Used to multicast the teacher SDP (Connection Description) to all the subscribers of a given class
     *
     * SUBSCRIBERS: Students ONLY
     */
    @MessageMapping("/offer/class/{id}")
    @Throws(Exception::class)
    fun onOffer(@DestinationVariable("id") id: String?, @Payload msg: SignalingMessageIn) =
        template.convertAndSend("/topic/class/$id",
                SignalingMessageOut(type = msg.type, sender = msg.sender, payload = msg.payload))


    /**
     * Used to single cast the student SDP (Connection Description) to the class teacher
     *
     * SUBSCRIBERS: Professors ONLY
     */
    @MessageMapping("/answer/class/{id}")
    @Throws(Exception::class)
    fun onAnswer(@DestinationVariable("id") id: String?, @Payload msg: SignalingMessageIn) =
        template.convertAndSend("/topic/class/$id/professor",
                SignalingMessageOut(type = msg.type, sender = msg.sender, payload = msg.payload))

}