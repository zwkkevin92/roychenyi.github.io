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
 * SAccess entity. @author MyEclipse Persistence Tools
 * 声音（sound）
 * 访问记录
 */
@Entity
@Table(name = "s_access", catalog = "wxs")
public class SAccess implements java.io.Serializable {

	// Fields

	private Long saccessId;
	private UUser UUser;
	private SSound SSound;
	private String clientAgent;
	private String clientIp;
	private Short clientType;
	private Timestamp time;

	// Constructors

	/** default constructor */
	public SAccess() {
	}

	/** minimal constructor */
	public SAccess(UUser UUser, SSound SSound) {
		this.UUser = UUser;
		this.SSound = SSound;
	}

	/** full constructor */
	public SAccess(UUser UUser, SSound SSound, String clientAgent,
			String clientIp, Short clientType, Timestamp time) {
		this.UUser = UUser;
		this.SSound = SSound;
		this.clientAgent = clientAgent;
		this.clientIp = clientIp;
		this.clientType = clientType;
		this.time = time;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "saccess_id", unique = true, nullable = false)
	public Long getSaccessId() {
		return this.saccessId;
	}

	public void setSaccessId(Long saccessId) {
		this.saccessId = saccessId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	public UUser getUUser() {
		return this.UUser;
	}

	public void setUUser(UUser UUser) {
		this.UUser = UUser;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sound_id", nullable = false)
	public SSound getSSound() {
		return this.SSound;
	}

	public void setSSound(SSound SSound) {
		this.SSound = SSound;
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