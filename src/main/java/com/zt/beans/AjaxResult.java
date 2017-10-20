package com.zt.beans;

public class AjaxResult extends BaseAjaxResult {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4929216183337446589L;
	private Object data;
	
	private AjaxResult(){
		super();
	}

	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	public static AjaxResult success(Object data){
		AjaxResult result = new AjaxResult();
		result.setStatus(0);
		result.setData(data);
		return result;
	}
	
	public static AjaxResult fail(String message){
		AjaxResult result = new AjaxResult();
		result.setStatus(500);
		result.setMessage(message);
		return result;
	}
	
	public static AjaxResult fail(int status, String message){
		AjaxResult result = new AjaxResult();
		result.setStatus(status);
		result.setMessage(message);
		return result;
	}
	
}
