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
 * WMenber entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "w_menber", catalog = "wxs")
public class WMenber implements java.io.Serializable {

	// Fields

	private Integer menberId;
	private UUser UUser;
	private WWxs WWxs;
	private Timestamp createTime;
	private Timestamp lastTime;
	private Short clientType;
	private String clientIp;
	private String clientAgent;
	private Short status;
	private Integer ext1;
	private Integer ext2;
	private String ext3;
	private String ext4;

	// Constructors

	/** default constructor */
	public WMenber() {
	}

	/** minimal constructor */
	public WMenber(WWxs WWxs) {
		this.WWxs = WWxs;
	}

	/** full constructor */
	public WMenber(UUser UUser, WWxs WWxs, Timestamp createTime,
			Timestamp lastTime, Short clientType, String clientIp,
			String clientAgent, Short status, Integer ext1, Integer ext2,
			String ext3, String ext4) {
		this.UUser = UUser;
		this.WWxs = WWxs;
		this.createTime = createTime;
		this.lastTime = lastTime;
		this.clientType = clientType;
		this.clientIp = clientIp;
		this.clientAgent = clientAgent;
		this.status = status;
		this.ext1 = ext1;
		this.ext2 = ext2;
		this.ext3 = ext3;
		this.ext4 = ext4;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "menber_id", unique = true, nullable = false)
	public Integer getMenberId() {
		return this.menberId;
	}

	public void setMenberId(Integer menberId) {
		this.menberId = menberId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	public UUser getUUser() {
		return this.UUser;
	}

	public void setUUser(UUser UUser) {
		this.UUser = UUser;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "wxs_id", nullable = false)
	public WWxs getWWxs() {
		return this.WWxs;
	}

	public void setWWxs(WWxs WWxs) {
		this.WWxs = WWxs;
	}

	@Column(name = "create_time", length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "last_time", length = 19)
	public Timestamp getLastTime() {
		return this.lastTime;
	}

	public void setLastTime(Timestamp lastTime) {
		this.lastTime = lastTime;
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

	@Column(name = "status")
	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
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