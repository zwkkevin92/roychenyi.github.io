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
 * VItem entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "v_item", catalog = "wxs")
public class VItem implements java.io.Serializable {

	// Fields

	private Integer itemId;
	private VVote VVote;
	private String content;
	private Timestamp createTime;
	private Timestamp updateTime;
	private Integer count;
	private Short sortOrder;
	private Set<VCount> VCounts = new HashSet<VCount>(0);

	// Constructors

	/** default constructor */
	public VItem() {
	}

	/** minimal constructor */
	public VItem(VVote VVote, String content) {
		this.VVote = VVote;
		this.content = content;
	}

	/** full constructor */
	public VItem(VVote VVote, String content, Timestamp createTime,
			Timestamp updateTime, Integer count, Short sortOrder,
			Set<VCount> VCounts) {
		this.VVote = VVote;
		this.content = content;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.count = count;
		this.sortOrder = sortOrder;
		this.VCounts = VCounts;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "item_id", unique = true, nullable = false)
	public Integer getItemId() {
		return this.itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vote_id", nullable = false)
	public VVote getVVote() {
		return this.VVote;
	}

	public void setVVote(VVote VVote) {
		this.VVote = VVote;
	}

	@Column(name = "content", nullable = false, length = 1024)
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

	@Column(name = "count")
	public Integer getCount() {
		return this.count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Column(name = "sort_order")
	public Short getSortOrder() {
		return this.sortOrder;
	}

	public void setSortOrder(Short sortOrder) {
		this.sortOrder = sortOrder;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "VItem")
	public Set<VCount> getVCounts() {
		return this.VCounts;
	}

	public void setVCounts(Set<VCount> VCounts) {
		this.VCounts = VCounts;
	}

}