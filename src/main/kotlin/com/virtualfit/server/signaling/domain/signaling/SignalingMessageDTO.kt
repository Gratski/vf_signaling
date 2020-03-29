package com.virtualfit.server.signaling.domain.signaling

import com.fasterxml.jackson.annotation.JsonProperty
import com.virtualfit.server.signaling.domain.classes.ClassEventType

class SignalingMessageIn(
        @JsonProperty("sender")
        val sender: Int?,
        @JsonProperty("type")
        val type: ClassEventType?,
        @JsonProperty("payload")
        val payload: Any?
)
class SignalingMessageOut(
        @JsonProperty("sender")
        val sender: Int?,
        @JsonProperty("type")
        val type: ClassEventType?,
        @JsonProperty("payload")
        val payload: Any?
)