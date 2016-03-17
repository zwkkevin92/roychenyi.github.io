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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * SysRank entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_rank", catalog = "wxs")
public class SysRank implements java.io.Serializable {

	// Fields

	private Integer rankId;
	private String name;
	private Integer rankHigh;
	private Integer rankLow;
	private String rankLogo;
	private Timestamp time;
	private Integer ext1;
	private Integer ext2;
	private String ext3;
	private String ext4;
	private Set<UUser> UUsers = new HashSet<UUser>(0);

	// Constructors

	/** default constructor */
	public SysRank() {
	}

	/** minimal constructor */
	public SysRank(Integer rankHigh, Integer rankLow) {
		this.rankHigh = rankHigh;
		this.rankLow = rankLow;
	}

	/** full constructor */
	public SysRank(String name, Integer rankHigh, Integer rankLow,
			String rankLogo, Timestamp time, Integer ext1, Integer ext2,
			String ext3, String ext4, Set<UUser> UUsers) {
		this.name = name;
		this.rankHigh = rankHigh;
		this.rankLow = rankLow;
		this.rankLogo = rankLogo;
		this.time = time;
		this.ext1 = ext1;
		this.ext2 = ext2;
		this.ext3 = ext3;
		this.ext4 = ext4;
		this.UUsers = UUsers;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "rank_id", unique = true, nullable = false)
	public Integer getRankId() {
		return this.rankId;
	}

	public void setRankId(Integer rankId) {
		this.rankId = rankId;
	}

	@Column(name = "name", length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "rank_high", nullable = false)
	public Integer getRankHigh() {
		return this.rankHigh;
	}

	public void setRankHigh(Integer rankHigh) {
		this.rankHigh = rankHigh;
	}

	@Column(name = "rank_low", nullable = false)
	public Integer getRankLow() {
		return this.rankLow;
	}

	public void setRankLow(Integer rankLow) {
		this.rankLow = rankLow;
	}

	@Column(name = "rank_logo", length = 200)
	public String getRankLogo() {
		return this.rankLogo;
	}

	public void setRankLogo(String rankLogo) {
		this.rankLogo = rankLogo;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sysRank")
	public Set<UUser> getUUsers() {
		return this.UUsers;
	}

	public void setUUsers(Set<UUser> UUsers) {
		this.UUsers = UUsers;
	}

}