package com.cx.wxs.enums;

/**
 * 状态值
 * @author 陈义
 * @date   2016-5-15 下午2:47:31
 */
public enum Status {

	ERROR(-1),
	WARNing(0),
	SUCCESS(1);
	// 定义私有变量
    private int nCode;

    // 构造函数，枚举类型只能为私有
    private Status(int _nCode) {

        this.nCode = _nCode;

    }

    @Override
    public String toString() {

        return String.valueOf(this.nCode);

    }
}
