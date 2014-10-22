package br.com.almana.webapi.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.Executors;

@WebServlet(name = "releaseRequestServlet", urlPatterns = "/servlet/release")
public class ReleaseRequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Executors.newFixedThreadPool(1).execute(() -> {
            System.out.println("Started Long process");
            try {
                Thread.sleep(10000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Finished Long process");
        });
        resp.setStatus(200);
        resp.getWriter().write("Request released but processing continues on background!");
    }
}
