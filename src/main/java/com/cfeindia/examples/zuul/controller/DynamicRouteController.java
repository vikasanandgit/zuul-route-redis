package com.cfeindia.examples.zuul.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cfeindia.examples.zuul.model.DeleteRouteRequest;
import com.cfeindia.examples.zuul.model.DynamicRoute;
import com.cfeindia.examples.zuul.model.DynamicRouteResponse;
import com.cfeindia.examples.zuul.service.ZuulDynamicRoutingService;

@RestController
public class DynamicRouteController {
	
	
	private static final Logger logger = LoggerFactory.getLogger(DynamicRouteController.class);
	
	@Autowired
	ZuulDynamicRoutingService zuulDynamicRoutingService;

	@RequestMapping(value = "/proxyurl", method = RequestMethod.POST)
	public @ResponseBody DynamicRouteResponse getProxyURL(@RequestBody DynamicRoute dynamicRoute) {
		logger.debug("request received to add {}", dynamicRoute);
		DynamicRouteResponse dynamicRouteResponse = zuulDynamicRoutingService.addDynamicRoute(dynamicRoute);
		logger.debug("response sent {}", dynamicRouteResponse);
		return dynamicRouteResponse;
	}
	
	@RequestMapping(value = "/proxyurl", method = RequestMethod.DELETE)
	public @ResponseBody Boolean deleteProxyURL(@RequestBody DeleteRouteRequest deleteRouteRequest) {
		logger.debug("request received to delete {}", deleteRouteRequest);
		Boolean response = zuulDynamicRoutingService.removeDynamicRoute(deleteRouteRequest.getRequestURIUniqueKey());
		logger.debug("response sent for delete {}", response);
		return response;
	}
}
