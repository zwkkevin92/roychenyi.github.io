package com.cx.wxs.enums;

/**
 * @author 陈义
 * @date   2016-5-15 下午2:44:28
 * 用户权限
 */
public enum  UserRole {

	ADMIN(0),     //管理员
	WXSADMIN(1),  //文学社管理员
	COMMEN(2);    //普通用户
	// 定义私有变量
    private int nCode;

    // 构造函数，枚举类型只能为私有
    private UserRole(int _nCode) {

        this.nCode = _nCode;

    }

    @Override
    public String toString() {

        return String.valueOf(this.nCode);

    }
}
