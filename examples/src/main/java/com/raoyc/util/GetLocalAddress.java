package com.raoyc.util;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class GetLocalAddress {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("192.168.0.1", 80));
        System.out.println(socket.getLocalAddress());
        socket.close();
    }
}
