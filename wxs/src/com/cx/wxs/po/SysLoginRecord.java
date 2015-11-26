package com.cx.wxs.po;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * SysLoginRecord entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_login_record", catalog = "wxs")
public class SysLoginRecord implements java.io.Serializable {

	// Fields

	private Integer recordId;
	private UUser UUser;
	private Timestamp createTime;
	private String clientAgent;
	private String clientIp;
	private Short clientType;

	// Constructors

	/** default constructor */
	public SysLoginRecord() {
	}

	/** full constructor */
	public SysLoginRecord(UUser UUser, Timestamp createTime,
			String clientAgent, String clientIp, Short clientType) {
		this.UUser = UUser;
		this.createTime = createTime;
		this.clientAgent = clientAgent;
		this.clientIp = clientIp;
		this.clientType = clientType;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "record_id", unique = true, nullable = false)
	public Integer getRecordId() {
		return this.recordId;
	}

	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	public UUser getUUser() {
		return this.UUser;
	}

	public void setUUser(UUser UUser) {
		this.UUser = UUser;
	}

	@Column(name = "create_time", length = 0)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "client_agent", length = 250)
	public String getClientAgent() {
		return this.clientAgent;
	}

	public void setClientAgent(String clientAgent) {
		this.clientAgent = clientAgent;
	}

	@Column(name = "client_ip", length = 50)
	public String getClientIp() {
		return this.clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}

	@Column(name = "client_type")
	public Short getClientType() {
		return this.clientType;
	}

	public void setClientType(Short clientType) {
		this.clientType = clientType;
	}

}