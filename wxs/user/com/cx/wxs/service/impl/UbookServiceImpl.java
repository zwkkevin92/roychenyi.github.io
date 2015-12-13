package com.cx.wxs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.wxs.dao.UBookDao;
import com.cx.wxs.dto.UBookDto;
import com.cx.wxs.dto.UBookDto;
import com.cx.wxs.service.UBookService;

/**
 * @author 陈义
 * @date   2015-12-7 下午4:40:52
 */
@Service("UbookService")
public class UBookServiceImpl implements UBookService {

	@Autowired
	private UBookDao ubookDao; 
	
	

	public UBookDao getUbookDao() {
		return ubookDao;
	}

	public void setUbookdao(UBookDao ubookDao) {
		this.ubookDao = ubookDao;
	}

	@Override
	public UBookDto getUbookByID(UBookDto ubookDto) {
		return ubookDao.getUBookByID(ubookDto);
	}

	/* (non-Javadoc)
	 * @see com.cx.wxs.service.UbookService#getUbookList(com.cx.wxs.dto.UBookDto)
	 */
	@Override
	public List<UBookDto> getUbookList(UBookDto ubookDto) {
		// TODO Auto-generated method stub
		return ubookDao.getUBookList(ubookDto);
	}

	public Integer addUbook(UBookDto ubookDto){
		return ubookDao.addUBook(ubookDto);
	}
	/* (non-Javadoc)
	 * @see com.cx.wxs.service.UbookService#UpdateUbook(com.cx.wxs.dto.UBookDto)
	 */
	@Override
	public Integer updateUbook(UBookDto ubookDto) {
		// TODO Auto-generated method stub
		return ubookDao.updateUBook(ubookDto);
	}

	/* (non-Javadoc)
	 * @see com.cx.wxs.service.UbookService#deleteUbook(com.cx.wxs.dto.UBookDto)
	 */
	@Override
	public Integer deleteUbook(UBookDto ubookDto) {
		// TODO Auto-generated method stub
		return ubookDao.deleteUBook(ubookDto);
	}

}
