package com.freecharge.dc.util;

import com.freecharge.dc.model.ApiRequestHeader;

public class RequestUtil {
	
	
	private static final ThreadLocal<ApiRequestHeader> userContext = new ThreadLocal<>();
	
	public static void initializeUserContext(String requestId, String channel, String webJourney) {
		ApiRequestHeader headerData = new ApiRequestHeader(requestId,channel,webJourney);
		userContext.set(headerData);
	}
	public static String getCurrentRequestId() {
		return userContext.get()!=null?userContext.get().getRequestId() :null;
	}
	public static ApiRequestHeader getHeaderInfo() {
		return userContext.get();
	}
	public static void clearUserContext() {
		userContext.remove();
	}
	
}
