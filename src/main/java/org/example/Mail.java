package org.example;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.List;

public class Mail {
    private boolean isSSL;
    private String host;
    private int port;
    private boolean isAuth;
    private InternetAddress FROM;
    private InternetAddress[] TO;
    private InternetAddress[] CC;

    public InternetAddress[] getTO() {
        return TO;
    }

    public void setTO(List<String> address) throws AddressException {
        TO = new InternetAddress[address.size()];
        for (int i = 0; i < address.size(); i++) {
            TO[i] = new InternetAddress(address.get(i));
        }
    }

    public InternetAddress[] getCC() {
        return CC;
    }

    public void setCC(InternetAddress[] CC) {
        this.CC = CC;
    }

    public boolean isSSL() {
        return isSSL;
    }

    public void setSSL(boolean SSL) {
        isSSL = SSL;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public boolean isAuth() {
        return isAuth;
    }

    public void setAuth(boolean auth) {
        isAuth = auth;
    }

    public InternetAddress getFROM() {
        return FROM;
    }

    public void setFROM(InternetAddress FROM) {
        this.FROM = FROM;
    }


    @Override
    public String toString() {
        return "Mail{" +
                "isSSL=" + isSSL +
                ", host='" + host + '\'' +
                ", port=" + port +
                ", isAuth=" + isAuth +
                ", from=" + FROM +
                '}';
    }

    public Mail(boolean isSSL, String host, int port, boolean isAuth, InternetAddress FROM) {
        this.isSSL = isSSL;
        this.host = host;
        this.port = port;
        this.isAuth = isAuth;
        this.FROM = FROM;
    }

    public Mail() throws AddressException {
        isSSL=false;
        isAuth=true;
        host = "mail.fotile.com.cn";
        FROM = new InternetAddress("donglxa@fotile.com");
        port=25;
    }
}
