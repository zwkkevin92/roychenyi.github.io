package com.cx.wxs.utils;

import java.awt.image.BufferedImage;

import jp.sourceforge.qrcode.data.QRCodeImage;

/**
 * @author 陈义
 * @date   2015-12-1 下午4:29:02
 */
public class TwoDimensionCodeImage implements QRCodeImage {

	 BufferedImage bufImg;  
	    
	    public TwoDimensionCodeImage(BufferedImage bufImg) {  
	        this.bufImg = bufImg;  
	    }  
	      
	    public int getHeight() {  
	        return bufImg.getHeight();  
	    }  
	  
	    public int getPixel(int x, int y) {  
	        return bufImg.getRGB(x, y);  
	    }  
	  
	    public int getWidth() {  
	        return bufImg.getWidth();  
	    }  

}

