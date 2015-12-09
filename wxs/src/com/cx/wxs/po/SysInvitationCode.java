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
 * SysInvitationCode entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_invitation_code", catalog = "wxs")
public class SysInvitationCode implements java.io.Serializable {

	// Fields

	private Integer codeId;
	private Integer userId;
	private Integer wxsId;
	private String code;
	private Timestamp regTime;
	private String clientAgent;
	private String clientIp;
	private Short clientType;
	private Short status;
	private Short flag;
	private Set<UUser> UUsers = new HashSet<UUser>(0);

	// Constructors

	/** default constructor */
	public SysInvitationCode() {
	}

	/** minimal constructor */
	public SysInvitationCode(Integer userId, Integer wxsId) {
		this.userId = userId;
		this.wxsId = wxsId;
	}

	/** full constructor */
	public SysInvitationCode(Integer userId, Integer wxsId, String code,
			Timestamp regTime, String clientAgent, String clientIp,
			Short clientType, Short status, Short flag, Set<UUser> UUsers) {
		this.userId = userId;
		this.wxsId = wxsId;
		this.code = code;
		this.regTime = regTime;
		this.clientAgent = clientAgent;
		this.clientIp = clientIp;
		this.clientType = clientType;
		this.status = status;
		this.flag = flag;
		this.UUsers = UUsers;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "code_id", unique = true, nullable = false)
	public Integer getCodeId() {
		return this.codeId;
	}

	public void setCodeId(Integer codeId) {
		this.codeId = codeId;
	}

	@Column(name = "user_id")
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "wxs_id", nullable = false)
	public Integer getWxsId() {
		return this.wxsId;
	}

	public void setWxsId(Integer wxsId) {
		this.wxsId = wxsId;
	}

	@Column(name = "code", length = 16)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "reg_time", length = 0)
	public Timestamp getRegTime() {
		return this.regTime;
	}

	public void setRegTime(Timestamp regTime) {
		this.regTime = regTime;
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

	@Column(name = "status")
	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	@Column(name = "flag")
	public Short getFlag() {
		return this.flag;
	}

	public void setFlag(Short flag) {
		this.flag = flag;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sysInvitationCode")
	public Set<UUser> getUUsers() {
		return this.UUsers;
	}

	public void setUUsers(Set<UUser> UUsers) {
		this.UUsers = UUsers;
	}

}