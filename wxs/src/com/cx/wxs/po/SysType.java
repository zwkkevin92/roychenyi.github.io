package com.cx.wxs.po;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SysType entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_type", catalog = "wxs")
public class SysType implements java.io.Serializable {

	// Fields

	private Integer typeId;
	private String name;
	private String value;
	private Timestamp createTime;
	private Timestamp lastTime;

	// Constructors

	/** default constructor */
	public SysType() {
	}

	/** full constructor */
	public SysType(String name, String value, Timestamp createTime,
			Timestamp lastTime) {
		this.name = name;
		this.value = value;
		this.createTime = createTime;
		this.lastTime = lastTime;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "type_id", unique = true, nullable = false)
	public Integer getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	@Column(name = "name", length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "value", length = 36)
	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Column(name = "create_time", length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "last_time", length = 19)
	public Timestamp getLastTime() {
		return this.lastTime;
	}

	public void setLastTime(Timestamp lastTime) {
		this.lastTime = lastTime;
	}

}