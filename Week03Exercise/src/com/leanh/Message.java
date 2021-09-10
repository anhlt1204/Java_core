package com.leanh;

public class Message {
    private long id;
    private String content;

    public Message(String content) {
        this.id = System.currentTimeMillis();
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return id + " - " + content;
    }
}
