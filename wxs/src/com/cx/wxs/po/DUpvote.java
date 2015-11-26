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
 * DUpvote entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "d_upvote", catalog = "wxs")
public class DUpvote implements java.io.Serializable {

	// Fields

	private Integer dupvoteId;
	private DDiary DDiary;
	private UUser UUser;
	private String clientAgent;
	private String clientIp;
	private Short clientType;
	private Timestamp time;
	private Short status;

	// Constructors

	/** default constructor */
	public DUpvote() {
	}

	/** minimal constructor */
	public DUpvote(DDiary DDiary, UUser UUser) {
		this.DDiary = DDiary;
		this.UUser = UUser;
	}

	/** full constructor */
	public DUpvote(DDiary DDiary, UUser UUser, String clientAgent,
			String clientIp, Short clientType, Timestamp time, Short status) {
		this.DDiary = DDiary;
		this.UUser = UUser;
		this.clientAgent = clientAgent;
		this.clientIp = clientIp;
		this.clientType = clientType;
		this.time = time;
		this.status = status;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "dupvote_id", unique = true, nullable = false)
	public Integer getDupvoteId() {
		return this.dupvoteId;
	}

	public void setDupvoteId(Integer dupvoteId) {
		this.dupvoteId = dupvoteId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "diary_id", nullable = false)
	public DDiary getDDiary() {
		return this.DDiary;
	}

	public void setDDiary(DDiary DDiary) {
		this.DDiary = DDiary;
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

	@Column(name = "status")
	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

}