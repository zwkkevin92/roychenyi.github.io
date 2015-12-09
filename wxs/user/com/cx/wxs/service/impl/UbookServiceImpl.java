package com.cx.wxs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.UbookDao;
import com.cx.wxs.dto.UbookDto;
import com.cx.wxs.service.UbookService;

/**
 * @author 陈义
 * @date   2015-12-7 下午4:40:52
 */
@Service("UbookService")
public class UbookServiceImpl implements UbookService {

	@Autowired
	private UbookDao ubookDao; 
	
	

	public UbookDao getUbookDao() {
		return ubookDao;
	}

	public void setUbookdao(UbookDao ubookDao) {
		this.ubookDao = ubookDao;
	}

	@Override
	public UbookDto getUbookByID(UbookDto ubookDto) {
		return ubookDao.getUBookByID(ubookDto);
	}

	/* (non-Javadoc)
	 * @see com.cx.wxs.service.UbookService#getUbookList(com.cx.wxs.dto.UbookDto)
	 */
	@Override
	public List<UbookDto> getUbookList(UbookDto ubookDto) {
		// TODO Auto-generated method stub
		return ubookDao.getUBookList(ubookDto);
	}

	public Integer addUbook(UbookDto ubookDto){
		return ubookDao.addUBook(ubookDto);
	}
	/* (non-Javadoc)
	 * @see com.cx.wxs.service.UbookService#UpdateUbook(com.cx.wxs.dto.UbookDto)
	 */
	@Override
	public Integer updateUbook(UbookDto ubookDto) {
		// TODO Auto-generated method stub
		return ubookDao.updateUBook(ubookDto);
	}

	/* (non-Javadoc)
	 * @see com.cx.wxs.service.UbookService#deleteUbook(com.cx.wxs.dto.UbookDto)
	 */
	@Override
	public Integer deleteUbook(UbookDto ubookDto) {
		// TODO Auto-generated method stub
		return ubookDao.deleteUBook(ubookDto);
	}

}
