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
 * MReply entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "m_reply", catalog = "wxs")
public class MReply implements java.io.Serializable {

	// Fields

	private Integer mreplyId;
	private MGuestbook MGuestbook;
	private UUser UUser;
	private String content;
	private Timestamp time;
	private Integer replyId;
	private Short clientType;
	private String clientIp;
	private String clientAgent;

	// Constructors

	/** default constructor */
	public MReply() {
	}

	/** minimal constructor */
	public MReply(MGuestbook MGuestbook, UUser UUser) {
		this.MGuestbook = MGuestbook;
		this.UUser = UUser;
	}

	/** full constructor */
	public MReply(MGuestbook MGuestbook, UUser UUser, String content,
			Timestamp time, Integer replyId, Short clientType, String clientIp,
			String clientAgent) {
		this.MGuestbook = MGuestbook;
		this.UUser = UUser;
		this.content = content;
		this.time = time;
		this.replyId = replyId;
		this.clientType = clientType;
		this.clientIp = clientIp;
		this.clientAgent = clientAgent;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "mreply_id", unique = true, nullable = false)
	public Integer getMreplyId() {
		return this.mreplyId;
	}

	public void setMreplyId(Integer mreplyId) {
		this.mreplyId = mreplyId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "guestbook_id", nullable = false)
	public MGuestbook getMGuestbook() {
		return this.MGuestbook;
	}

	public void setMGuestbook(MGuestbook MGuestbook) {
		this.MGuestbook = MGuestbook;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	public UUser getUUser() {
		return this.UUser;
	}

	public void setUUser(UUser UUser) {
		this.UUser = UUser;
	}

	@Column(name = "content", length = 1024)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "time", length = 19)
	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	@Column(name = "reply_id")
	public Integer getReplyId() {
		return this.replyId;
	}

	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
	}

	@Column(name = "client_type")
	public Short getClientType() {
		return this.clientType;
	}

	public void setClientType(Short clientType) {
		this.clientType = clientType;
	}

	@Column(name = "client_ip", length = 50)
	public String getClientIp() {
		return this.clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}

	@Column(name = "client_agent", length = 250)
	public String getClientAgent() {
		return this.clientAgent;
	}

	public void setClientAgent(String clientAgent) {
		this.clientAgent = clientAgent;
	}

}