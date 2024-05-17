package de.quinscape;

import jakarta.websocket.OnOpen;
import io.quarkus.websockets.next.OnTextMessage;
import io.quarkus.websockets.next.WebSocket;


@WebSocket(path = "/chat")
public class ChatSocket {

    private final Assistant assistant;

    public ChatSocket(Assistant assistant) {
        this.assistant = assistant;
    }

    @OnOpen
    public String onOpen() {
        System.out.println("onOpen: ");
        return "Hello, how can I help you?";
    }

    @OnTextMessage
    public String onMessage(String userMessage) {
        System.out.println("onMessage: "+userMessage);
        return assistant.chat(userMessage);
    }
}