package com.example.wappbiu_android;

public class TransferDetails {
    private String to;
    private String from;
    private String server;

    public void setTo(String to) {
        this.to = to;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public TransferDetails(String to, String from, String server) {
        this.to = to;
        this.from = from;
        this.server = server;
    }

    public String getTo() {
        return to;
    }

    public String getFrom() {
        return from;
    }

    public String getServer() {
        return server;
    }

}
