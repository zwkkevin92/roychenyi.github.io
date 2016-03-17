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
 * VUpvote entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "v_upvote", catalog = "wxs")
public class VUpvote implements java.io.Serializable {

	// Fields

	private Integer vupvoteId;
	private VVote VVote;
	private UUser UUser;
	private Integer userId;
	private String clientAgent;
	private String clientIp;
	private Short clientType;
	private Timestamp time;
	private Short status;

	// Constructors

	/** default constructor */
	public VUpvote() {
	}

	/** minimal constructor */
	public VUpvote(VVote VVote, UUser UUser, Integer userId) {
		this.VVote = VVote;
		this.UUser = UUser;
		this.userId = userId;
	}

	/** full constructor */
	public VUpvote(VVote VVote, UUser UUser, Integer userId,
			String clientAgent, String clientIp, Short clientType,
			Timestamp time, Short status) {
		this.VVote = VVote;
		this.UUser = UUser;
		this.userId = userId;
		this.clientAgent = clientAgent;
		this.clientIp = clientIp;
		this.clientType = clientType;
		this.time = time;
		this.status = status;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "vupvote_id", unique = true, nullable = false)
	public Integer getVupvoteId() {
		return this.vupvoteId;
	}

	public void setVupvoteId(Integer vupvoteId) {
		this.vupvoteId = vupvoteId;
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
	@JoinColumn(name = "vote_id", nullable = false, insertable = false, updatable = false)
	public UUser getUUser() {
		return this.UUser;
	}

	public void setUUser(UUser UUser) {
		this.UUser = UUser;
	}

	@Column(name = "user_id", nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	@Column(name = "status")
	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

}