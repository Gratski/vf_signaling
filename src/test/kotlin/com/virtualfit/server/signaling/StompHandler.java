package com.virtualfit.server.signaling;

import org.springframework.messaging.simp.stomp.*;

public class StompHandler extends StompSessionHandlerAdapter {

    @Override
    public void handleFrame(StompHeaders headers, Object payload) {
        System.out.println("SENDING FRAME");
        super.handleFrame(headers, payload);
    }

}
