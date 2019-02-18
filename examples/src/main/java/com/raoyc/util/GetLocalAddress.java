package com.raoyc.util;


import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Test {

    public static void main(String[] args) throws IOException {
        InetAddress address = AddressUtil.getLocalHostLANAddress();
        // System.out.println(InetAddress.getLocalHost().getHostAddress());
        // System.out.print(address);

        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("192.168.0.1", 80));
        System.out.println(socket.getLocalAddress());
        socket.close();
    }
}
