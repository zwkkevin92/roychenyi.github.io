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
 * MAffiche entity. @author MyEclipse Persistence Tools
 * 系统消息 
 */
@Entity
@Table(name = "m_affiche", catalog = "wxs")
public class MAffiche implements java.io.Serializable {

	// Fields

	private Integer afficheId;
	private UUser UUser;
	private String title;
	private String content;
	private Timestamp sendTime;
	private Timestamp expireTime;
	private Short status;

	// Constructors

	/** default constructor */
	public MAffiche() {
	}

	/** minimal constructor */
	public MAffiche(UUser UUser) {
		this.UUser = UUser;
	}

	/** full constructor */
	public MAffiche(UUser UUser, String title, String content,
			Timestamp sendTime, Timestamp expireTime, Short status) {
		this.UUser = UUser;
		this.title = title;
		this.content = content;
		this.sendTime = sendTime;
		this.expireTime = expireTime;
		this.status = status;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "affiche_id", unique = true, nullable = false)
	public Integer getAfficheId() {
		return this.afficheId;
	}

	public void setAfficheId(Integer afficheId) {
		this.afficheId = afficheId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	public UUser getUUser() {
		return this.UUser;
	}

	public void setUUser(UUser UUser) {
		this.UUser = UUser;
	}

	@Column(name = "title", length = 20)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "content", length = 1024)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "send_time", length = 19)
	public Timestamp getSendTime() {
		return this.sendTime;
	}

	public void setSendTime(Timestamp sendTime) {
		this.sendTime = sendTime;
	}

	@Column(name = "expire_time", length = 19)
	public Timestamp getExpireTime() {
		return this.expireTime;
	}

	public void setExpireTime(Timestamp expireTime) {
		this.expireTime = expireTime;
	}

	@Column(name = "status")
	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

}