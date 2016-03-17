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
 * VAccess entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "v_access", catalog = "wxs")
public class VAccess implements java.io.Serializable {

	// Fields

	private Long vaccessId;
	private VVote VVote;
	private UUser UUser;
	private String clientAgent;
	private String clientIp;
	private Short clientType;
	private Timestamp time;

	// Constructors

	/** default constructor */
	public VAccess() {
	}

	/** minimal constructor */
	public VAccess(VVote VVote, UUser UUser) {
		this.VVote = VVote;
		this.UUser = UUser;
	}

	/** full constructor */
	public VAccess(VVote VVote, UUser UUser, String clientAgent,
			String clientIp, Short clientType, Timestamp time) {
		this.VVote = VVote;
		this.UUser = UUser;
		this.clientAgent = clientAgent;
		this.clientIp = clientIp;
		this.clientType = clientType;
		this.time = time;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "vaccess_id", unique = true, nullable = false)
	public Long getVaccessId() {
		return this.vaccessId;
	}

	public void setVaccessId(Long vaccessId) {
		this.vaccessId = vaccessId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vote_id", nullable = false)
	public VVote getVVote() {
		return this.VVote;
	}

	public void setVVote(VVote VVote) {
		this.VVote = VVote;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	public UUser getUUser() {
		return this.UUser;
	}

	public void setUUser(UUser UUser) {
		this.UUser = UUser;
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

	@Column(name = "time", length = 19)
	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

}