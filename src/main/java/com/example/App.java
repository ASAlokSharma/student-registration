package com.example;
import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;
import java.nio.file.*;

public class App {
    public static void main(String[] a) throws Exception {
        HttpServer s = HttpServer.create(new InetSocketAddress(8080), 0);
        s.createContext("/", e -> {
            byte[] b = Files.readAllBytes(Path.of("index.html"));
            e.getResponseHeaders().add("Content-Type", "text/html; charset=UTF-8");
            e.sendResponseHeaders(200, b.length);
            e.getResponseBody().write(b);
            e.close();
        });
        s.createContext("/submit", e -> {
            byte[] b = ("<html><body style='font-family:Segoe UI,Arial;text-align:center;padding-top:80px;background:#eef2f9'>"
              + "<h2 style='color:#1e3c72'>Registration Submitted Successfully</h2>"
              + "<p>Noida Institute of Engineering and Technology</p>"
              + "<a href='/'>Back to form</a></body></html>").getBytes();
            e.getResponseHeaders().add("Content-Type", "text/html; charset=UTF-8");
            e.sendResponseHeaders(200, b.length);
            e.getResponseBody().write(b);
            e.close();
        });
        s.start();
    }
}