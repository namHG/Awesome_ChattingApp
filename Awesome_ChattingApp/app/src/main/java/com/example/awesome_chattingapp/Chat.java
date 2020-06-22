package com.example.awesome_chattingapp;

public class Chat {
    String nickname;
    String message;
    String uid;

    public String getNickname() {
        return nickname;
    }

    public String getMessage() {
        return message;
    }
    public String getUid() {
        return uid;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
