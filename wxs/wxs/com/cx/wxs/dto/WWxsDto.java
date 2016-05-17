package com.cx.wxs.dto;

import com.cx.wxs.base.BeanBase;
import com.cx.wxs.dto.SysSchoolDto;

import java.sql.Timestamp;

/**
 * @author 陈义
 * @date 2016-05-16 10:44:22
 */
public class WWxsDto extends BeanBase{
    private Integer wxsId;
    private SysSchoolDto sysSchoolDto;
    private String account;
    private String password;
    private String name;
    private String title;
    private String wxsUrl;
    private String wxsDetail;
    private String logo;
    private String mail;
    private Integer styleId;
    private Short flag;
    private Timestamp createTime;
    private Timestamp lastTime;
    private Short clientType;
    private String clientIp;
    private String clientAgent;
    private Short mode;
    private String accessCode;
    private String indexName;
    private String diaryName;
    private String soundName;
    private String imageName;
    private Integer siteType;
    private Short status;
    private Integer ext1;
    private Integer ext2;
    private String ext3;
    private String ext4;

    /** default constructor */
    public WWxsDto(){

    }

    /** full constructor */
    public WWxsDto(SysSchoolDto sysSchoolDto,Integer wxsId,String account,String password,String name,String title,String wxsUrl,String wxsDetail,String logo,String mail,Integer styleId,Short flag,Timestamp createTime,Timestamp lastTime,Short clientType,String clientIp,String clientAgent,Short mode,String accessCode,String indexName,String diaryName,String soundName,String imageName,Integer siteType,Short status,Integer ext1,Integer ext2,String ext3,String ext4){super();
        this.sysSchoolDto=sysSchoolDto;
        this.wxsId=wxsId;
        this.account=account;
        this.password=password;
        this.name=name;
        this.title=title;
        this.wxsUrl=wxsUrl;
        this.wxsDetail=wxsDetail;
        this.logo=logo;
        this.mail=mail;
        this.styleId=styleId;
        this.flag=flag;
        this.createTime=createTime;
        this.lastTime=lastTime;
        this.clientType=clientType;
        this.clientIp=clientIp;
        this.clientAgent=clientAgent;
        this.mode=mode;
        this.accessCode=accessCode;
        this.indexName=indexName;
        this.diaryName=diaryName;
        this.soundName=soundName;
        this.imageName=imageName;
        this.siteType=siteType;
        this.status=status;
        this.ext1=ext1;
        this.ext2=ext2;
        this.ext3=ext3;
        this.ext4=ext4;
    }

    public Integer getWxsId(){
        return wxsId;
    }
    public void setWxsId(Integer wxsId){
        this.wxsId=wxsId;
    }
    
	public SysSchoolDto getSysSchoolDto() {
		return sysSchoolDto;
	}

	/**
	 * @param sysSchool the sysSchool to set
	 */
	public void setSysSchoolDto(SysSchoolDto sysSchoolDto) {
		this.sysSchoolDto = sysSchoolDto;
	}

	public String getAccount(){
        return account;
    }
    public void setAccount(String account){
        this.account=account;
    }

    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password=password;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title=title;
    }

    public String getWxsUrl(){
        return wxsUrl;
    }
    public void setWxsUrl(String wxsUrl){
        this.wxsUrl=wxsUrl;
    }

    public String getWxsDetail(){
        return wxsDetail;
    }
    public void setWxsDetail(String wxsDetail){
        this.wxsDetail=wxsDetail;
    }

    public String getLogo(){
        return logo;
    }
    public void setLogo(String logo){
        this.logo=logo;
    }
    
    public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

    public Integer getStyleId(){
        return styleId;
    }
    public void setStyleId(Integer styleId){
        this.styleId=styleId;
    }

    public Short getFlag(){
        return flag;
    }
    public void setFlag(Short flag){
        this.flag=flag;
    }

    public Timestamp getCreateTime(){
        return createTime;
    }
    public void setCreateTime(Timestamp createTime){
        this.createTime=createTime;
    }

    public Timestamp getLastTime(){
        return lastTime;
    }
    public void setLastTime(Timestamp lastTime){
        this.lastTime=lastTime;
    }

    public Short getClientType(){
        return clientType;
    }
    public void setClientType(Short clientType){
        this.clientType=clientType;
    }

    public String getClientIp(){
        return clientIp;
    }
    public void setClientIp(String clientIp){
        this.clientIp=clientIp;
    }

    public String getClientAgent(){
        return clientAgent;
    }
    public void setClientAgent(String clientAgent){
        this.clientAgent=clientAgent;
    }

    public Short getMode(){
        return mode;
    }
    public void setMode(Short mode){
        this.mode=mode;
    }

    public String getAccessCode(){
        return accessCode;
    }
    public void setAccessCode(String accessCode){
        this.accessCode=accessCode;
    }

    public String getIndexName(){
        return indexName;
    }
    public void setIndexName(String indexName){
        this.indexName=indexName;
    }

    public String getDiaryName(){
        return diaryName;
    }
    public void setDiaryName(String diaryName){
        this.diaryName=diaryName;
    }

    public String getSoundName(){
        return soundName;
    }
    public void setSoundName(String soundName){
        this.soundName=soundName;
    }

    public String getImageName(){
        return imageName;
    }
    public void setImageName(String imageName){
        this.imageName=imageName;
    }

    public Integer getSiteType(){
        return siteType;
    }
    public void setSiteType(Integer siteType){
        this.siteType=siteType;
    }

    public Short getStatus(){
        return status;
    }
    public void setStatus(Short status){
        this.status=status;
    }

    public Integer getExt1(){
        return ext1;
    }
    public void setExt1(Integer ext1){
        this.ext1=ext1;
    }

    public Integer getExt2(){
        return ext2;
    }
    public void setExt2(Integer ext2){
        this.ext2=ext2;
    }

    public String getExt3(){
        return ext3;
    }
    public void setExt3(String ext3){
        this.ext3=ext3;
    }

    public String getExt4(){
        return ext4;
    }
    public void setExt4(String ext4){
        this.ext4=ext4;
    }


}