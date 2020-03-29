package com.virtualfit.server.signaling.domain.classes

import com.fasterxml.jackson.annotation.JsonProperty

data class ClassSignalingIn(
        @JsonProperty("sender")
        val sender: Int?,
        @JsonProperty("type")
        val type: ClassEventType?,
        @JsonProperty("payload")
        val payload: Any?
)

data class ClassSignalingOut(
        @JsonProperty("sender")
        val sender: Int?,
        @JsonProperty("type")
        val type: ClassEventType?,
        @JsonProperty("payload")
        val payload: Any?
)