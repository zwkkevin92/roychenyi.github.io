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
 * IAccess entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "i_access", catalog = "wxs")
public class IAccess implements java.io.Serializable {

	// Fields

	private Long iaccessId;
	private IImage IImage;
	private UUser UUser;
	private String clientAgent;
	private String clientIp;
	private Short clientType;
	private Timestamp time;

	// Constructors

	/** default constructor */
	public IAccess() {
	}

	/** minimal constructor */
	public IAccess(IImage IImage, UUser UUser) {
		this.IImage = IImage;
		this.UUser = UUser;
	}

	/** full constructor */
	public IAccess(IImage IImage, UUser UUser, String clientAgent,
			String clientIp, Short clientType, Timestamp time) {
		this.IImage = IImage;
		this.UUser = UUser;
		this.clientAgent = clientAgent;
		this.clientIp = clientIp;
		this.clientType = clientType;
		this.time = time;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "iaccess_id", unique = true, nullable = false)
	public Long getIaccessId() {
		return this.iaccessId;
	}

	public void setIaccessId(Long iaccessId) {
		this.iaccessId = iaccessId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "image_id", nullable = false)
	public IImage getIImage() {
		return this.IImage;
	}

	public void setIImage(IImage IImage) {
		this.IImage = IImage;
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

	@Column(name = "time", length = 0)
	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

}