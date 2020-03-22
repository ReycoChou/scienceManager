package com.dayunwu.manage.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.ZuulFilterResult;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author： reyco
 * @date 2020/3/22
 */
@Component
public class LoginFilter extends ZuulFilter {

    private final Logger LOGGER = LoggerFactory.getLogger(LoginFilter.class);

    @Override
    public ZuulFilterResult runFilter() {
        return super.runFilter();
    }

    @Override
    public String filterType() {
        return "pre"; // 请求路由前调用
    }

    @Override
    public int filterOrder() {
        return 1; // 数值越小优先级越高
    }

    @Override
    public boolean shouldFilter() {
        return true; // 该过滤器是否执行， true执行，false不执行
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        try {
            context.getResponse().getWriter().write("token is empty");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
