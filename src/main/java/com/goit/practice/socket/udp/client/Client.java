package com.goit.practice.socket.udp.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        DatagramPacket packet = new DatagramPacket(new byte[1024], 124, InetAddress.getLocalHost(), 8082);
        packet.setData("Hello from a client".getBytes());
        socket.send(packet);

    }
}
