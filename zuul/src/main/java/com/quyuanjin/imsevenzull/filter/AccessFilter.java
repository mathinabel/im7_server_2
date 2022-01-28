package com.quyuanjin.imsevenzull.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class AccessFilter extends ZuulFilter {
    private static Logger log = LoggerFactory.getLogger(AccessFilter.class);
    /**
     * 过滤器的执行时序
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }
    /**
     * 过滤器的执行顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }
    /**
     * 判断过滤器是否应该执行
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }
    /**
     * 过滤器的具体执行逻辑
     * @return
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext rc = RequestContext.getCurrentContext();
        HttpServletRequest request = rc.getRequest();
        log.info("send {} request to {}", request.getMethod(),request.getRequestURL().toString());

        String accessToken = request.getParameter("accessToken");
    /*    if(null == accessToken){
            log.warn("access token is null");
            rc.setResponseStatusCode(401);
            rc.setSendZuulResponse(false);
        }*/
        log.info("access token ok");
        return null;
    }
}
