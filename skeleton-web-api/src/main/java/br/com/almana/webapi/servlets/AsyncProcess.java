package br.com.almana.webapi.servlets;

import javax.servlet.AsyncContext;

public class AsyncProcess implements Runnable {

    private AsyncContext asyncContext;
    private long durationInSecs;

    public AsyncProcess(AsyncContext asyncContext, int durationInSecs) {
        this.asyncContext = asyncContext;
        this.durationInSecs = durationInSecs;
    }

    @Override
    public void run() {
        System.out.println("Started long process");
        try {
            Thread.sleep(durationInSecs * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Long process finished");
        this.asyncContext.complete();
    }
}
