package com.cx.wxs.po;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SysBlockedIp entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_blocked_ip", catalog = "wxs")
public class SysBlockedIp implements java.io.Serializable {

	// Fields

	private Integer blockedipId;
	private String ip;
	private String ipmask;
	private Integer blockedType;
	private Timestamp time;
	private Short status;
	private Timestamp updateTime;

	// Constructors

	/** default constructor */
	public SysBlockedIp() {
	}

	/** full constructor */
	public SysBlockedIp(String ip, String ipmask, Integer blockedType,
			Timestamp time, Short status, Timestamp updateTime) {
		this.ip = ip;
		this.ipmask = ipmask;
		this.blockedType = blockedType;
		this.time = time;
		this.status = status;
		this.updateTime = updateTime;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "blockedip_id", unique = true, nullable = false)
	public Integer getBlockedipId() {
		return this.blockedipId;
	}

	public void setBlockedipId(Integer blockedipId) {
		this.blockedipId = blockedipId;
	}

	@Column(name = "ip", length = 50)
	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Column(name = "ipmask", length = 50)
	public String getIpmask() {
		return this.ipmask;
	}

	public void setIpmask(String ipmask) {
		this.ipmask = ipmask;
	}

	@Column(name = "blocked_type")
	public Integer getBlockedType() {
		return this.blockedType;
	}

	public void setBlockedType(Integer blockedType) {
		this.blockedType = blockedType;
	}

	@Column(name = "time", length = 0)
	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	@Column(name = "status")
	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	@Column(name = "update_time", length = 0)
	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

}