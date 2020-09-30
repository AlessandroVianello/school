package com.vianelloalessandro.iblogger_app;

public class ResponseApp {

    private String message;
    private String token;
    private Post[] post;

    public String getMessage() {
        return message;
    }

    public String getToken() {
        return token;
    }

    public Post[] getPost(){ return post; }
}
