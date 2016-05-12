package com.cx.wxs.enums;

/**
 * @author 陈义
 * @date   2016-5-12 下午4:20:02
 */
public enum DiaryRole {
	DELETE(-2),TRANSH(-1),PRIVATE(0), COMMEN(1), DRAFT(2);
	// 定义私有变量
    private int nCode;

    // 构造函数，枚举类型只能为私有
    private DiaryRole(int _nCode) {

        this.nCode = _nCode;

    }

    @Override
    public String toString() {

        return String.valueOf(this.nCode);

    }

}
