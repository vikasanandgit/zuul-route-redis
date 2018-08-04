package com.cfeindia.examples.zuul.filter;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class PostFilter extends ZuulFilter {
	private static Logger log = LoggerFactory.getLogger(PostFilter.class);

	@Override
	public String filterType() {
		return "post";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public boolean shouldFilter() {
		RequestContext ctx = RequestContext.getCurrentContext();
		String requestURL = ctx.getRequest().getRequestURL().toString();
		return !(requestURL.contains("proxyurl") || requestURL.contains("/admin/"));
	}

	@Override
	public Object run() {
		HttpServletResponse response = RequestContext.getCurrentContext().getResponse();
		log.info("PostFilter: " + String.format("response is %s", response));
		return null;
	}
}
