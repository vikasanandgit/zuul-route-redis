package com.cfeindia.examples.zuul.model;

/**
 * Response of dynamic route creation and saving
 * @author vikasanand
 *
 */
public class DynamicRouteResponse {
	
	/**
	 * statusCode is 0 for success.
	 * if statusCode is not 0 then check for errorMessage for details.
	 */
	private int statusCode;
	private String errorMessage;

	public DynamicRouteResponse() {
		super();
	}

	public DynamicRouteResponse(int statusCode, String errorMessage) {
		super();
		this.statusCode = statusCode;
		this.errorMessage = errorMessage;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DynamicRouteResponse [statusCode=");
		builder.append(statusCode);
		builder.append(", errorMessage=");
		builder.append(errorMessage);
		builder.append("]");
		return builder.toString();
	}

}
