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
 * VCount entity. @author MyEclipse Persistence Tools
 * 投票计数
 */
@Entity
@Table(name = "v_count", catalog = "wxs")
public class VCount implements java.io.Serializable {

	// Fields

	private Integer vcountId;
	private VVote VVote;
	private UUser UUser;
	private VItem VItem;
	private String clientAgent;
	private String clientIp;
	private Short clientType;
	private Timestamp time;
	private Integer ext1;
	private Integer ext2;
	private String ext3;
	private String ext4;

	// Constructors

	/** default constructor */
	public VCount() {
	}

	/** minimal constructor */
	public VCount(VVote VVote, UUser UUser, VItem VItem) {
		this.VVote = VVote;
		this.UUser = UUser;
		this.VItem = VItem;
	}

	/** full constructor */
	public VCount(VVote VVote, UUser UUser, VItem VItem, String clientAgent,
			String clientIp, Short clientType, Timestamp time, Integer ext1,
			Integer ext2, String ext3, String ext4) {
		this.VVote = VVote;
		this.UUser = UUser;
		this.VItem = VItem;
		this.clientAgent = clientAgent;
		this.clientIp = clientIp;
		this.clientType = clientType;
		this.time = time;
		this.ext1 = ext1;
		this.ext2 = ext2;
		this.ext3 = ext3;
		this.ext4 = ext4;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "vcount_id", unique = true, nullable = false)
	public Integer getVcountId() {
		return this.vcountId;
	}

	public void setVcountId(Integer vcountId) {
		this.vcountId = vcountId;
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
	@JoinColumn(name = "user_id", nullable = false)
	public UUser getUUser() {
		return this.UUser;
	}

	public void setUUser(UUser UUser) {
		this.UUser = UUser;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "item_id", nullable = false)
	public VItem getVItem() {
		return this.VItem;
	}

	public void setVItem(VItem VItem) {
		this.VItem = VItem;
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

	@Column(name = "ext1")
	public Integer getExt1() {
		return this.ext1;
	}

	public void setExt1(Integer ext1) {
		this.ext1 = ext1;
	}

	@Column(name = "ext2")
	public Integer getExt2() {
		return this.ext2;
	}

	public void setExt2(Integer ext2) {
		this.ext2 = ext2;
	}

	@Column(name = "ext3", length = 1024)
	public String getExt3() {
		return this.ext3;
	}

	public void setExt3(String ext3) {
		this.ext3 = ext3;
	}

	@Column(name = "ext4", length = 1024)
	public String getExt4() {
		return this.ext4;
	}

	public void setExt4(String ext4) {
		this.ext4 = ext4;
	}

}