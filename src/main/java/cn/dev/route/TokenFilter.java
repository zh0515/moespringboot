package cn.dev.route;

import cn.dev.model.UserToken;
import cn.dev.service.TokenManager;
import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Order(1)
@Component
@ServletComponentScan
@WebFilter(urlPatterns = {"/ping/*"}, filterName = "tokenFilter")
public class TokenFilter implements Filter {
    static final Logger logger = LogManager.getLogger(TokenFilter.class);

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Autowired
    TokenManager tokenManager;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        if (req.getHeader("token") != "") {
            UserToken ut = JSONObject.parseObject(req.getHeader("token"), UserToken.class);
            if (tokenManager.checkToken(ut)) {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }

        JSONObject o = new JSONObject();
        o.put("error", "need token");
        resp.getWriter().write(o.toJSONString());

    }

    @Override
    public void destroy() {

    }
}