package com.solutions.servermanager.models;

public class ResponseModel {

    String message;
    int servers;

    public ResponseModel(String message, int servers) {
        this.message = message;
        this.servers = servers;
    }

    public ResponseModel(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getServers() {
        return servers;
    }

    public void setServers(int servers) {
        this.servers = servers;
    }
}
