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
 * MMessage entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "m_message", catalog = "wxs")
public class MMessage implements java.io.Serializable {

	// Fields

	private Integer messageId;
	private UUser UUserByUserId;
	private UUser UUserByReceiveId;
	private String content;
	private Timestamp sendTime;
	private Timestamp expireTime;
	private Timestamp readTime;
	private Short status;
	private Short clientType;
	private String clientIp;
	private String clientAgent;

	// Constructors

	/** default constructor */
	public MMessage() {
	}

	/** minimal constructor */
	public MMessage(UUser UUserByUserId, UUser UUserByReceiveId) {
		this.UUserByUserId = UUserByUserId;
		this.UUserByReceiveId = UUserByReceiveId;
	}

	/** full constructor */
	public MMessage(UUser UUserByUserId, UUser UUserByReceiveId,
			String content, Timestamp sendTime, Timestamp expireTime,
			Timestamp readTime, Short status, Short clientType,
			String clientIp, String clientAgent) {
		this.UUserByUserId = UUserByUserId;
		this.UUserByReceiveId = UUserByReceiveId;
		this.content = content;
		this.sendTime = sendTime;
		this.expireTime = expireTime;
		this.readTime = readTime;
		this.status = status;
		this.clientType = clientType;
		this.clientIp = clientIp;
		this.clientAgent = clientAgent;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "message_id", unique = true, nullable = false)
	public Integer getMessageId() {
		return this.messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	public UUser getUUserByUserId() {
		return this.UUserByUserId;
	}

	public void setUUserByUserId(UUser UUserByUserId) {
		this.UUserByUserId = UUserByUserId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "receive_id", nullable = false)
	public UUser getUUserByReceiveId() {
		return this.UUserByReceiveId;
	}

	public void setUUserByReceiveId(UUser UUserByReceiveId) {
		this.UUserByReceiveId = UUserByReceiveId;
	}

	@Column(name = "content", length = 1024)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "send_time", length = 0)
	public Timestamp getSendTime() {
		return this.sendTime;
	}

	public void setSendTime(Timestamp sendTime) {
		this.sendTime = sendTime;
	}

	@Column(name = "expire_time", length = 0)
	public Timestamp getExpireTime() {
		return this.expireTime;
	}

	public void setExpireTime(Timestamp expireTime) {
		this.expireTime = expireTime;
	}

	@Column(name = "read_time", length = 0)
	public Timestamp getReadTime() {
		return this.readTime;
	}

	public void setReadTime(Timestamp readTime) {
		this.readTime = readTime;
	}

	@Column(name = "status")
	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
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