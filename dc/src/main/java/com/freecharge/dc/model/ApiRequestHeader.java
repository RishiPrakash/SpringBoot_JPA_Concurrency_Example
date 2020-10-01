package com.freecharge.dc.model;

import java.io.Serializable;

public class ApiRequestHeader implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7431533739925982086L;
	private final String requestId;
	private final String channel;
	private final String webJourney;
	

	
	public ApiRequestHeader(String requestId, String channel, String webJourney) {
		super();
		this.requestId = requestId;
		this.channel = channel;
		this.webJourney = webJourney;
	}




	public String getRequestId() {
		return requestId;
	}




	@Override
	public String toString() {
		return "ApiRequestHeader [requestId=" + requestId + ", channel=" + channel + ", webJourney=" + webJourney + "]";
	}

}
