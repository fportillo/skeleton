package br.com.almana.webapi.servlets;

import br.com.almana.webapi.listener.WebAppAsyncListener;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "servletExample", urlPatterns = "/servlet/asynchello", asyncSupported = true)
public class AsyncServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AsyncContext asyncContext = req.startAsync();
        asyncContext.addListener(new WebAppAsyncListener());
        asyncContext.setTimeout(15000l);
        asyncContext.start(new AsyncProcess(asyncContext, 10));
        resp.setStatus(200);
        resp.getWriter().write("Async request received!");
    }
}
