package com.example.test;

import io.bloco.faker.components.Date;

public class Mail {
    private String sender;
    private String title;
    private String content;
    private boolean isStar;
    private String arrivedAt;


    public Mail(String sender, String title, String content, boolean isStar, String arrivedAt) {
        this.sender = sender;
        this.title = title;
        this.content = content;
        this.isStar = isStar;
        this.arrivedAt = arrivedAt;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isStar() {
        return isStar;
    }

    public void setStar(boolean star) {
        isStar = star;
    }

    public String getArrivedAt() {
        return arrivedAt;
    }

    public void setArrivedAt(String arrivedAt) {
        this.arrivedAt = arrivedAt;
    }
}
