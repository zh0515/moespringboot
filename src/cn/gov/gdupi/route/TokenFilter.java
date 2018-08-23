package cn.gov.gdupi.route;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;

@Order(1)
@Component
@ServletComponentScan
@WebFilter(urlPatterns = "/login/*", filterName = "loginFilter")
public class TokenFilter implements Filter {
    static final Logger logger = LogManager.getLogger(TokenFilter.class);

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {
        logger.info("filtered");
    }

    @Override
    public void destroy() {

    }
}