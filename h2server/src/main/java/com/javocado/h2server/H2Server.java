// File: src/main/java/com/javocado/h2server/H2Server.java
package com.javocado.h2server;

import org.h2.tools.Server;

public class H2Server {
    public static void main(String[] args) throws Exception {
        Server server = Server.createTcpServer(
                "-tcpPort", "9092",
                "-tcpAllowOthers",
                "-ifNotExists",
                "-baseDir", "/Users/xinliu/workspace/javocado/h2"
        ).start();

        System.out.println("H2 TCP Server started at: " + server.getURL());
    }
}