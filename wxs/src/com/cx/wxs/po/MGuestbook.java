package com.cx.wxs.po;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * MGuestbook entity. @author MyEclipse Persistence Tools
 * 留言板
 */
@Entity
@Table(name = "m_guestbook", catalog = "wxs")
public class MGuestbook implements java.io.Serializable {

	// Fields

	private Integer guestbookId;
	private UUser UUser;
	private BSite BSite;
	private Integer visitorId;
	private String content;
	private Short clientType;
	private String clientIp;
	private String clientAgent;
	private Timestamp time;
	private List<MReply> MReplies = new ArrayList<MReply>(0);

	// Constructors

	/** default constructor */
	public MGuestbook() {
	}

	/** minimal constructor */
	public MGuestbook(UUser UUser, Integer visitorId, String content) {
		this.UUser = UUser;
		this.visitorId = visitorId;
		this.content = content;
	}

	/** full constructor */
	public MGuestbook(UUser UUser, BSite BSite, Integer visitorId,
			String content, Short clientType, String clientIp,
			String clientAgent, Timestamp time, List<MReply> MReplies) {
		this.UUser = UUser;
		this.BSite = BSite;
		this.visitorId = visitorId;
		this.content = content;
		this.clientType = clientType;
		this.clientIp = clientIp;
		this.clientAgent = clientAgent;
		this.time = time;
		this.MReplies = MReplies;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "guestbook_id", unique = true, nullable = false)
	public Integer getGuestbookId() {
		return this.guestbookId;
	}

	public void setGuestbookId(Integer guestbookId) {
		this.guestbookId = guestbookId;
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
	@JoinColumn(name = "site_id")
	public BSite getBSite() {
		return this.BSite;
	}

	public void setBSite(BSite BSite) {
		this.BSite = BSite;
	}

	@Column(name = "visitor_id", nullable = false)
	public Integer getVisitorId() {
		return this.visitorId;
	}

	public void setVisitorId(Integer visitorId) {
		this.visitorId = visitorId;
	}

	@Column(name = "content", nullable = false, length = 1024)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
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

	@Column(name = "time", length = 19)
	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "MGuestbook")
	public List<MReply> getMReplies() {
		return this.MReplies;
	}

	public void setMReplies(List<MReply> MReplies) {
		this.MReplies = MReplies;
	}

}