package com.cx.wxs.po;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
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
	private List<VUpvote> VUpvotes = new ArrayList<VUpvote>(0);
	private List<VCount> VCounts = new ArrayList<VCount>(0);
	private List<VItem> VItems = new ArrayList<VItem>(0);
	private List<VReply1> VReply1s = new ArrayList<VReply1>(0);
	private List<VAccess> VAccesses = new ArrayList<VAccess>(0);

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
			Timestamp createTime, Timestamp updateTime, List<VUpvote> VUpvotes,
			List<VCount> VCounts, List<VItem> VItems, List<VReply1> VReply1s,
			List<VAccess> VAccesses) {
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

	@Column(name = "create_time", length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "update_time", length = 19)
	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "VVote")
	public List<VUpvote> getVUpvotes() {
		return this.VUpvotes;
	}

	public void setVUpvotes(List<VUpvote> VUpvotes) {
		this.VUpvotes = VUpvotes;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "VVote")
	public List<VCount> getVCounts() {
		return this.VCounts;
	}

	public void setVCounts(List<VCount> VCounts) {
		this.VCounts = VCounts;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "VVote")
	public List<VItem> getVItems() {
		return this.VItems;
	}

	public void setVItems(List<VItem> VItems) {
		this.VItems = VItems;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "VVote")
	public List<VReply1> getVReply1s() {
		return this.VReply1s;
	}

	public void setVReply1s(List<VReply1> VReply1s) {
		this.VReply1s = VReply1s;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "VVote")
	public List<VAccess> getVAccesses() {
		return this.VAccesses;
	}

	public void setVAccesses(List<VAccess> VAccesses) {
		this.VAccesses = VAccesses;
	}

}