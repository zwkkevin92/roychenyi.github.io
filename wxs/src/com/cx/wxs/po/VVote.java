package com.cx.wxs.po;

import java.sql.Timestamp;
import java.util.HashSet;
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
 * VVote entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "v_vote", catalog = "wxs")
public class VVote implements java.io.Serializable {

	// Fields

	private Integer voteId;
	private UUser UUser;
	private Integer vconfigId;
	private String content;
	private Timestamp createTime;
	private Timestamp updateTime;
	private Set<VUpvote> VUpvotes = new HashSet<VUpvote>(0);
	private Set<VCount> VCounts = new HashSet<VCount>(0);
	private Set<VItem> VItems = new HashSet<VItem>(0);
	private Set<VReply1> VReply1s = new HashSet<VReply1>(0);
	private Set<VAccess> VAccesses = new HashSet<VAccess>(0);

	// Constructors

	/** default constructor */
	public VVote() {
	}

	/** minimal constructor */
	public VVote(UUser UUser) {
		this.UUser = UUser;
	}

	/** full constructor */
	public VVote(UUser UUser, Integer vconfigId, String content,
			Timestamp createTime, Timestamp updateTime, Set<VUpvote> VUpvotes,
			Set<VCount> VCounts, Set<VItem> VItems, Set<VReply1> VReply1s,
			Set<VAccess> VAccesses) {
		this.UUser = UUser;
		this.vconfigId = vconfigId;
		this.content = content;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.VUpvotes = VUpvotes;
		this.VCounts = VCounts;
		this.VItems = VItems;
		this.VReply1s = VReply1s;
		this.VAccesses = VAccesses;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "vote_id", unique = true, nullable = false)
	public Integer getVoteId() {
		return this.voteId;
	}

	public void setVoteId(Integer voteId) {
		this.voteId = voteId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	public UUser getUUser() {
		return this.UUser;
	}

	public void setUUser(UUser UUser) {
		this.UUser = UUser;
	}

	@Column(name = "vconfig_id")
	public Integer getVconfigId() {
		return this.vconfigId;
	}

	public void setVconfigId(Integer vconfigId) {
		this.vconfigId = vconfigId;
	}

	@Column(name = "content", length = 1024)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "create_time", length = 0)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "update_time", length = 0)
	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "VVote")
	public Set<VUpvote> getVUpvotes() {
		return this.VUpvotes;
	}

	public void setVUpvotes(Set<VUpvote> VUpvotes) {
		this.VUpvotes = VUpvotes;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "VVote")
	public Set<VCount> getVCounts() {
		return this.VCounts;
	}

	public void setVCounts(Set<VCount> VCounts) {
		this.VCounts = VCounts;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "VVote")
	public Set<VItem> getVItems() {
		return this.VItems;
	}

	public void setVItems(Set<VItem> VItems) {
		this.VItems = VItems;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "VVote")
	public Set<VReply1> getVReply1s() {
		return this.VReply1s;
	}

	public void setVReply1s(Set<VReply1> VReply1s) {
		this.VReply1s = VReply1s;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "VVote")
	public Set<VAccess> getVAccesses() {
		return this.VAccesses;
	}

	public void setVAccesses(Set<VAccess> VAccesses) {
		this.VAccesses = VAccesses;
	}

}