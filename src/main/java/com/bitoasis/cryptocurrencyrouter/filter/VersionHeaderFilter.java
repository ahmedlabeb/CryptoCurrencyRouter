package com.bitoasis.cryptocurrencyrouter.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * PreFilter that change the ServiceId that will rout based on version passed in header
 *
 * @author Ahmed labib
 */
@Component
public class VersionHeaderFilter extends ZuulFilter {

    private final String VERSION = "Version";

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER - 1;
    }

    /**
     * Filter requests to micro-services Swagger docs.
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        final RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        context.put(FilterConstants.RETRYABLE_KEY, false);
        if (request.getHeader(VERSION) != null) {
            String serviceId = request.getHeader(VERSION);
            context.put(FilterConstants.SERVICE_ID_KEY, serviceId);
        } else {
            context.put(FilterConstants.SERVICE_ID_KEY, "version2");
        }
        return null;
    }

}