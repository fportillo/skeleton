package br.com.almana.webapi.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "filterExample", urlPatterns = "/api/*")
public class FilterExample implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(FilterExample.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        LOGGER.debug("Hei, interceptei request e escrevi no log!!!");
        System.out.println("hei, interceptei um request!!!");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
