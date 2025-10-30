package com.example.book.adapter;

public class Adapter implements Slf4j{
    private Logf4j logf4j;
    public Adapter(Logf4j logf4j) {
        this.logf4j = logf4j;
    }
    @Override
    public void log(String meg) {
        logf4j.log4j("我是适配器");
    }
}
