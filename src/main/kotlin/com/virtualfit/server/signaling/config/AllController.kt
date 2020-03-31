package com.virtualfit.server.signaling.config

import com.virtualfit.server.signaling.domain.DemoDomain
import com.virtualfit.server.signaling.domain.classes.ClassSignalingIn
import com.virtualfit.server.signaling.domain.classes.ClassSignalingOut
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller
import java.text.SimpleDateFormat
import java.util.*

@Controller
class AllController {

    @MessageMapping("/class")
    @SendTo("/topic/messages")
    @Throws(Exception::class)
    fun send(input: DemoDomain): DemoDomain {
        println("GOT A MESSAGE INCOME!")
        //val time: String = SimpleDateFormat("HH:mm").format(Date())
        //return ClassSignalingOut(sender = input.sender, type = input.type, payload = input.payload)
        return DemoDomain();
    }

}