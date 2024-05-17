package de.quinscape;

import jakarta.websocket.OnOpen;
import io.quarkus.websockets.next.OnTextMessage;
import io.quarkus.websockets.next.WebSocket;


@WebSocket(path = "/chat")
public class ChatSocket {

    private final Assistant assistant;

    public ChatSocket(Assistant assistant) {
        System.out.println("ChatSocket: "+assistant);
        this.assistant = assistant;
    }

    @OnOpen
    public String onOpen() {
        return "Hello from Miles of Smiles, how can we help you?";
    }

    @OnTextMessage
    public String onMessage(String userMessage) {
        System.out.println("onMessage: "+userMessage);
        return assistant.chat(userMessage);
    }
}