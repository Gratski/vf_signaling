package com.virtualfit.server.signaling;

import com.virtualfit.server.signaling.domain.classes.ClassEventType;
import com.virtualfit.server.signaling.domain.signaling.SignalingMessageIn;
import com.virtualfit.server.signaling.stomp.StompFrame;
import com.virtualfit.server.signaling.stomp.client.StompClient;
import com.virtualfit.server.signaling.stomp.client.listener.StompMessageListener;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.converter.StringMessageConverter;
import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import java.lang.reflect.Type;
import java.net.URI;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SignalingServerApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class JavaScoketConnectionTest {

    @Test
    public void testGetLog() throws InterruptedException {

        final StompClient stompSocket = new StompClient(URI.create("ws://127.0.0.1:8080/offer"));

        // Wait for a connection to establish
        boolean connected;
        try {
            connected = stompSocket.connectBlocking();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return;
        }
        if (!connected) {
            System.out.println("Failed to connect to the socket");
            return;
        }

        // Subscribing to a topic once STOMP connection is established
        stompSocket.subscribe("/topic/messages", new StompMessageListener() {

            @Override
            public void onMessage(StompFrame stompFrame) {
                System.out.println("Server message: " + stompFrame.getBody());

                // Disconnect
                stompSocket.close();
            }
        });

        // Sending JSON message to a server
        String message = "{\"name\": \"Jack\"}";
        stompSocket.send("/app/class", message);


        Thread.sleep(5000);
    }

}
