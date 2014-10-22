package br.com.almana.webapi.servlets;

import br.com.almana.webapi.listener.WebAppAsyncListener;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This Servlet does not release the request to the client!
 * It just do the heavy processing in another thread (async context) in order
 * to release the initial request thread to the thread pool, avoiding
 * thread starvation
 */
@WebServlet(name = "asyncServlet", urlPatterns = "/servlet/async", asyncSupported = true)
public class AsyncServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // This is the initial thread
        System.out.println(String.format("Initial thread. Name => %s, Id => %d", Thread.currentThread().getName(), Thread.currentThread().getId()));
        final AsyncContext asyncContext = req.startAsync();
        asyncContext.addListener(new WebAppAsyncListener());

        // Gets a new thread from the container. There's a chance to be the same thread.
        // It depends on the container.
        asyncContext.start(() -> {
            System.out.println("Started long process. Browser will wait.");
            // This is the async difference: this code can or cannot be the same thread of the initial thread
            // it depends on what thread the container will provide
            System.out.println(String.format("Long Process thread. Name => %s, Id => %d", Thread.currentThread().getName(), Thread.currentThread().getId()));
            try {
                Thread.sleep(10000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Long process finished. Browser should now get the response.");
            try {

                final HttpServletResponse response = (HttpServletResponse) asyncContext.getResponse();
                response.setStatus(HttpServletResponse.SC_OK);
                response.getWriter().write("OK");
                asyncContext.complete();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // Same thread as the initial.
        System.out.println(String.format("Closing thread of HttpServlet service method (doGet). Name => %s, Id => %d", Thread.currentThread().getName(), Thread.currentThread().getId()));
    }
}
