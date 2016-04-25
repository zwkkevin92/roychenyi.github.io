package com.cx.wxs.create;

/**
 * @author 陈义
 * @date   2015-12-9 下午4:34:49
 */
public class BeanType {

	private String type;
	private String name;
	
	public BeanType(){}
	
	

	public BeanType(String type, String name) {
		super();
		this.type = type;
		this.name = name;
	}



	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
