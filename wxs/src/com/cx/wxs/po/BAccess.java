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
 * BAccess entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "b_access", catalog = "wxs")
public class BAccess implements java.io.Serializable {

	// Fields

	private Long baccessId;
	private UUser UUser;
	private BSite BSite;
	private Timestamp time;
	private String clientAgent;
	private String clientIp;
	private Short clientType;

	// Constructors

	/** default constructor */
	public BAccess() {
	}

	/** minimal constructor */
	public BAccess(BSite BSite) {
		this.BSite = BSite;
	}

	/** full constructor */
	public BAccess(UUser UUser, BSite BSite, Timestamp time,
			String clientAgent, String clientIp, Short clientType) {
		this.UUser = UUser;
		this.BSite = BSite;
		this.time = time;
		this.clientAgent = clientAgent;
		this.clientIp = clientIp;
		this.clientType = clientType;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "baccess_id", unique = true, nullable = false)
	public Long getBaccessId() {
		return this.baccessId;
	}

	public void setBaccessId(Long baccessId) {
		this.baccessId = baccessId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	public UUser getUUser() {
		return this.UUser;
	}

	public void setUUser(UUser UUser) {
		this.UUser = UUser;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "site_id", nullable = false)
	public BSite getBSite() {
		return this.BSite;
	}

	public void setBSite(BSite BSite) {
		this.BSite = BSite;
	}

	@Column(name = "time", length = 19)
	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
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