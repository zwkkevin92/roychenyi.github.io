package com.cx.wxs.po;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ZyFymx entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ZY_FYMX", schema = "dbo", catalog = "jyy_his")
public class ZyFymx implements java.io.Serializable {

	// Fields

	private Long jlxh;
	private Long zyh;
	private Timestamp fyrq;
	private Integer fyxh;
	private String fymc;
	private Short ypcd;
	private Double fysl;
	private Double fydj;
	private Double zjje;
	private Double zfje;
	private String ysgh;
	private String srgh;
	private String qrgh;
	private Short fybq;
	private Short fyks;
	private Short zxks;
	private Timestamp jfrq;
	private Byte xmlx;
	private Boolean yplx;
	private Short fyxm;
	private Short jscs;
	private Double zfbl;
	private Long yzxh;
	private Timestamp hzrq;
	private String yjrq;
	private Double zlje;
	private Short zlxz;
	private Boolean yepb;
	private Boolean xzbz;
	private String mxjfbz;
	private Boolean lcjbz;
	private Double ylsj;
	private Double ylse;
	private Double yhje;
	private Long ybTfjlxh;
	private Long ybTfxh;
	private Long ybScbz;
	private String ybdzbm;
	private Double ybDj;
	private Double ybSl;
	private Double ybZjje;
	private Long ybZfsh;
	private Boolean syzyy;
	private Integer test;

	public ZyFymx(Long jlxh, Long zyh, Timestamp fyrq, Integer fyxh,
			String fymc, Short ypcd, Double fysl, Double fydj, Double zjje,
			Double zfje, String ysgh, String srgh, String qrgh, Short fybq,
			Short fyks, Short zxks, Timestamp jfrq, Byte xmlx, Boolean yplx,
			Short fyxm, Short jscs, Double zfbl, Long yzxh, Timestamp hzrq,
			String yjrq, Double zlje, Short zlxz, Boolean yepb, Boolean xzbz,
			String mxjfbz, Boolean lcjbz, Double ylsj, Double ylse,
			Double yhje, Long ybTfjlxh, Long ybTfxh, Long ybScbz,
			String ybdzbm, Double ybDj, Double ybSl, Double ybZjje,
			Long ybZfsh, Boolean syzyy, Integer test) {
		super();
		this.jlxh = jlxh;
		this.zyh = zyh;
		this.fyrq = fyrq;
		this.fyxh = fyxh;
		this.fymc = fymc;
		this.ypcd = ypcd;
		this.fysl = fysl;
		this.fydj = fydj;
		this.zjje = zjje;
		this.zfje = zfje;
		this.ysgh = ysgh;
		this.srgh = srgh;
		this.qrgh = qrgh;
		this.fybq = fybq;
		this.fyks = fyks;
		this.zxks = zxks;
		this.jfrq = jfrq;
		this.xmlx = xmlx;
		this.yplx = yplx;
		this.fyxm = fyxm;
		this.jscs = jscs;
		this.zfbl = zfbl;
		this.yzxh = yzxh;
		this.hzrq = hzrq;
		this.yjrq = yjrq;
		this.zlje = zlje;
		this.zlxz = zlxz;
		this.yepb = yepb;
		this.xzbz = xzbz;
		this.mxjfbz = mxjfbz;
		this.lcjbz = lcjbz;
		this.ylsj = ylsj;
		this.ylse = ylse;
		this.yhje = yhje;
		this.ybTfjlxh = ybTfjlxh;
		this.ybTfxh = ybTfxh;
		this.ybScbz = ybScbz;
		this.ybdzbm = ybdzbm;
		this.ybDj = ybDj;
		this.ybSl = ybSl;
		this.ybZjje = ybZjje;
		this.ybZfsh = ybZfsh;
		this.syzyy = syzyy;
		this.test = test;
	}

	// Constructors

	public Integer getTest() {
		return test;
	}

	public void setTest(Integer test) {
		this.test = test;
	}

	/** default constructor */
	public ZyFymx() {
	}

	/** minimal constructor */
	public ZyFymx(Long jlxh, Long zyh, Timestamp fyrq, Integer fyxh,
			Short ypcd, Double fysl, Double fydj, Double zjje, Double zfje,
			Short fybq, Short fyks, Short zxks, Timestamp jfrq, Byte xmlx,
			Boolean yplx, Short fyxm, Short jscs, Double zfbl, Double zlje) {
		this.jlxh = jlxh;
		this.zyh = zyh;
		this.fyrq = fyrq;
		this.fyxh = fyxh;
		this.ypcd = ypcd;
		this.fysl = fysl;
		this.fydj = fydj;
		this.zjje = zjje;
		this.zfje = zfje;
		this.fybq = fybq;
		this.fyks = fyks;
		this.zxks = zxks;
		this.jfrq = jfrq;
		this.xmlx = xmlx;
		this.yplx = yplx;
		this.fyxm = fyxm;
		this.jscs = jscs;
		this.zfbl = zfbl;
		this.zlje = zlje;
	}

	/** full constructor */
	public ZyFymx(Long jlxh, Long zyh, Timestamp fyrq, Integer fyxh,
			String fymc, Short ypcd, Double fysl, Double fydj, Double zjje,
			Double zfje, String ysgh, String srgh, String qrgh, Short fybq,
			Short fyks, Short zxks, Timestamp jfrq, Byte xmlx, Boolean yplx,
			Short fyxm, Short jscs, Double zfbl, Long yzxh, Timestamp hzrq,
			String yjrq, Double zlje, Short zlxz, Boolean yepb, Boolean xzbz,
			String mxjfbz, Boolean lcjbz, Double ylsj, Double ylse,
			Double yhje, Long ybTfjlxh, Long ybTfxh, Long ybScbz,
			String ybdzbm, Double ybDj, Double ybSl, Double ybZjje,
			Long ybZfsh, Boolean syzyy) {
		this.jlxh = jlxh;
		this.zyh = zyh;
		this.fyrq = fyrq;
		this.fyxh = fyxh;
		this.fymc = fymc;
		this.ypcd = ypcd;
		this.fysl = fysl;
		this.fydj = fydj;
		this.zjje = zjje;
		this.zfje = zfje;
		this.ysgh = ysgh;
		this.srgh = srgh;
		this.qrgh = qrgh;
		this.fybq = fybq;
		this.fyks = fyks;
		this.zxks = zxks;
		this.jfrq = jfrq;
		this.xmlx = xmlx;
		this.yplx = yplx;
		this.fyxm = fyxm;
		this.jscs = jscs;
		this.zfbl = zfbl;
		this.yzxh = yzxh;
		this.hzrq = hzrq;
		this.yjrq = yjrq;
		this.zlje = zlje;
		this.zlxz = zlxz;
		this.yepb = yepb;
		this.xzbz = xzbz;
		this.mxjfbz = mxjfbz;
		this.lcjbz = lcjbz;
		this.ylsj = ylsj;
		this.ylse = ylse;
		this.yhje = yhje;
		this.ybTfjlxh = ybTfjlxh;
		this.ybTfxh = ybTfxh;
		this.ybScbz = ybScbz;
		this.ybdzbm = ybdzbm;
		this.ybDj = ybDj;
		this.ybSl = ybSl;
		this.ybZjje = ybZjje;
		this.ybZfsh = ybZfsh;
		this.syzyy = syzyy;
	}

	// Property accessors
	@Id
	@Column(name = "JLXH", unique = true, nullable = false, precision = 18, scale = 0)
	public Long getJlxh() {
		return this.jlxh;
	}

	public void setJlxh(Long jlxh) {
		this.jlxh = jlxh;
	}

//	@Column(name = "ZYH", nullable = false, precision = 18, scale = 0)
	public Long getZyh() {
		return this.zyh;
	}

	public void setZyh(Long zyh) {
		this.zyh = zyh;
	}

	@Column(name = "FYRQ", nullable = false, length = 23)
	public Timestamp getFyrq() {
		return this.fyrq;
	}

	public void setFyrq(Timestamp fyrq) {
		this.fyrq = fyrq;
	}

	@Column(name = "FYXH", nullable = false, precision = 6, scale = 0)
	public Integer getFyxh() {
		return this.fyxh;
	}

	public void setFyxh(Integer fyxh) {
		this.fyxh = fyxh;
	}

	@Column(name = "FYMC", length = 80)
	public String getFymc() {
		return this.fymc;
	}

	public void setFymc(String fymc) {
		this.fymc = fymc;
	}

	@Column(name = "YPCD", nullable = false, precision = 4, scale = 0)
	public Short getYpcd() {
		return this.ypcd;
	}

	public void setYpcd(Short ypcd) {
		this.ypcd = ypcd;
	}

	@Column(name = "FYSL", nullable = false, precision = 10)
	public Double getFysl() {
		return this.fysl;
	}

	public void setFysl(Double fysl) {
		this.fysl = fysl;
	}

	@Column(name = "FYDJ", nullable = false, precision = 10, scale = 4)
	public Double getFydj() {
		return this.fydj;
	}

	public void setFydj(Double fydj) {
		this.fydj = fydj;
	}

	@Column(name = "ZJJE", nullable = false, precision = 12)
	public Double getZjje() {
		return this.zjje;
	}

	public void setZjje(Double zjje) {
		this.zjje = zjje;
	}

	@Column(name = "ZFJE", nullable = false, precision = 12)
	public Double getZfje() {
		return this.zfje;
	}

	public void setZfje(Double zfje) {
		this.zfje = zfje;
	}

	@Column(name = "YSGH", length = 20)
	public String getYsgh() {
		return this.ysgh;
	}

	public void setYsgh(String ysgh) {
		this.ysgh = ysgh;
	}

	@Column(name = "SRGH", length = 20)
	public String getSrgh() {
		return this.srgh;
	}

	public void setSrgh(String srgh) {
		this.srgh = srgh;
	}

	@Column(name = "QRGH", length = 20)
	public String getQrgh() {
		return this.qrgh;
	}

	public void setQrgh(String qrgh) {
		this.qrgh = qrgh;
	}

	@Column(name = "FYBQ", nullable = false, precision = 4, scale = 0)
	public Short getFybq() {
		return this.fybq;
	}

	public void setFybq(Short fybq) {
		this.fybq = fybq;
	}

	@Column(name = "FYKS", nullable = false, precision = 4, scale = 0)
	public Short getFyks() {
		return this.fyks;
	}

	public void setFyks(Short fyks) {
		this.fyks = fyks;
	}

	@Column(name = "ZXKS", nullable = false, precision = 4, scale = 0)
	public Short getZxks() {
		return this.zxks;
	}

	public void setZxks(Short zxks) {
		this.zxks = zxks;
	}

	@Column(name = "JFRQ", nullable = false, length = 23)
	public Timestamp getJfrq() {
		return this.jfrq;
	}

	public void setJfrq(Timestamp jfrq) {
		this.jfrq = jfrq;
	}

	@Column(name = "XMLX", nullable = false, precision = 2, scale = 0)
	public Byte getXmlx() {
		return this.xmlx;
	}

	public void setXmlx(Byte xmlx) {
		this.xmlx = xmlx;
	}

	@Column(name = "YPLX", nullable = false, precision = 1, scale = 0)
	public Boolean getYplx() {
		return this.yplx;
	}

	public void setYplx(Boolean yplx) {
		this.yplx = yplx;
	}

	@Column(name = "FYXM", nullable = false, precision = 4, scale = 0)
	public Short getFyxm() {
		return this.fyxm;
	}

	public void setFyxm(Short fyxm) {
		this.fyxm = fyxm;
	}

	@Column(name = "JSCS", nullable = false, precision = 3, scale = 0)
	public Short getJscs() {
		return this.jscs;
	}

	public void setJscs(Short jscs) {
		this.jscs = jscs;
	}

	@Column(name = "ZFBL", nullable = false, precision = 4, scale = 3)
	public Double getZfbl() {
		return this.zfbl;
	}

	public void setZfbl(Double zfbl) {
		this.zfbl = zfbl;
	}

	@Column(name = "YZXH", precision = 18, scale = 0)
	public Long getYzxh() {
		return this.yzxh;
	}

	public void setYzxh(Long yzxh) {
		this.yzxh = yzxh;
	}

	@Column(name = "HZRQ", length = 23)
	public Timestamp getHzrq() {
		return this.hzrq;
	}

	public void setHzrq(Timestamp hzrq) {
		this.hzrq = hzrq;
	}

	@Column(name = "YJRQ", length = 8)
	public String getYjrq() {
		return this.yjrq;
	}

	public void setYjrq(String yjrq) {
		this.yjrq = yjrq;
	}

	@Column(name = "ZLJE", nullable = false, precision = 12)
	public Double getZlje() {
		return this.zlje;
	}

	public void setZlje(Double zlje) {
		this.zlje = zlje;
	}

	@Column(name = "ZLXZ", precision = 4, scale = 0)
	public Short getZlxz() {
		return this.zlxz;
	}

	public void setZlxz(Short zlxz) {
		this.zlxz = zlxz;
	}

	@Column(name = "YEPB", precision = 1, scale = 0)
	public Boolean getYepb() {
		return this.yepb;
	}

	public void setYepb(Boolean yepb) {
		this.yepb = yepb;
	}

	@Column(name = "XZBZ", precision = 1, scale = 0)
	public Boolean getXzbz() {
		return this.xzbz;
	}

	public void setXzbz(Boolean xzbz) {
		this.xzbz = xzbz;
	}

	@Column(name = "MXJFBZ", length = 2)
	public String getMxjfbz() {
		return this.mxjfbz;
	}

	public void setMxjfbz(String mxjfbz) {
		this.mxjfbz = mxjfbz;
	}

	@Column(name = "LCJBZ", precision = 1, scale = 0)
	public Boolean getLcjbz() {
		return this.lcjbz;
	}

	public void setLcjbz(Boolean lcjbz) {
		this.lcjbz = lcjbz;
	}

	@Column(name = "YLSJ", precision = 12, scale = 4)
	public Double getYlsj() {
		return this.ylsj;
	}

	public void setYlsj(Double ylsj) {
		this.ylsj = ylsj;
	}

	@Column(name = "YLSE", precision = 12, scale = 4)
	public Double getYlse() {
		return this.ylse;
	}

	public void setYlse(Double ylse) {
		this.ylse = ylse;
	}

	@Column(name = "YHJE", precision = 12, scale = 4)
	public Double getYhje() {
		return this.yhje;
	}

	public void setYhje(Double yhje) {
		this.yhje = yhje;
	}

	@Column(name = "yb_tfjlxh", precision = 18, scale = 0)
	public Long getYbTfjlxh() {
		return this.ybTfjlxh;
	}

	public void setYbTfjlxh(Long ybTfjlxh) {
		this.ybTfjlxh = ybTfjlxh;
	}

	@Column(name = "yb_tfxh", precision = 18, scale = 0)
	public Long getYbTfxh() {
		return this.ybTfxh;
	}

	public void setYbTfxh(Long ybTfxh) {
		this.ybTfxh = ybTfxh;
	}

	@Column(name = "yb_scbz", precision = 18, scale = 0)
	public Long getYbScbz() {
		return this.ybScbz;
	}

	public void setYbScbz(Long ybScbz) {
		this.ybScbz = ybScbz;
	}

	@Column(name = "ybdzbm", length = 50)
	public String getYbdzbm() {
		return this.ybdzbm;
	}

	public void setYbdzbm(String ybdzbm) {
		this.ybdzbm = ybdzbm;
	}

	@Column(name = "yb_dj", precision = 10, scale = 4)
	public Double getYbDj() {
		return this.ybDj;
	}

	public void setYbDj(Double ybDj) {
		this.ybDj = ybDj;
	}

	@Column(name = "yb_sl", precision = 10)
	public Double getYbSl() {
		return this.ybSl;
	}

	public void setYbSl(Double ybSl) {
		this.ybSl = ybSl;
	}

	@Column(name = "yb_zjje", precision = 10)
	public Double getYbZjje() {
		return this.ybZjje;
	}

	public void setYbZjje(Double ybZjje) {
		this.ybZjje = ybZjje;
	}

	@Column(name = "yb_zfsh", precision = 10, scale = 0)
	public Long getYbZfsh() {
		return this.ybZfsh;
	}

	public void setYbZfsh(Long ybZfsh) {
		this.ybZfsh = ybZfsh;
	}

	@Column(name = "SYZYY", precision = 1, scale = 0)
	public Boolean getSyzyy() {
		return this.syzyy;
	}

	public void setSyzyy(Boolean syzyy) {
		this.syzyy = syzyy;
	}

}