package br.com.almana.webapi.listener;

import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;

@WebListener
public class WebAppAsyncListener implements AsyncListener{

    @Override
    public void onComplete(AsyncEvent asyncEvent) throws IOException {
        System.out.println("Async context complete");
    }

    @Override
    public void onTimeout(AsyncEvent asyncEvent) throws IOException {
        System.out.println("Async context time out");
    }

    @Override
    public void onError(AsyncEvent asyncEvent) throws IOException {
        System.out.println("Async context error");
    }

    @Override
    public void onStartAsync(AsyncEvent asyncEvent) throws IOException {
        System.out.println("Async started");
    }
}
