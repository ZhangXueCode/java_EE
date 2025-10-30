package com.example.book.adapter;

public class Main {
    public static void main(String[] args) {
        Slf4j slf4j = new Adapter(new Logf4j());
        slf4j.log("我是客户端");

    }
}
