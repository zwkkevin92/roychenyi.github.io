
package com.cx.wxs.utils.weather;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.10
 * 2016-04-06T10:34:40.746+08:00
 * Generated source version: 2.7.10
 * 
 */
public final class WeatherWSSoap_WeatherWSSoap12_Client {

    private static final QName SERVICE_NAME = new QName("http://WebXml.com.cn/", "WeatherWS");

    private WeatherWSSoap_WeatherWSSoap12_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = WeatherWS.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        WeatherWS ss = new WeatherWS(wsdlURL, SERVICE_NAME);
        WeatherWSSoap port = ss.getWeatherWSSoap12();  
        
        {
        System.out.println("Invoking getWeather...");
        java.lang.String _getWeather_theCityCode = "";
        java.lang.String _getWeather_theUserID = "";
        com.cx.wxs.utils.weather.ArrayOfString _getWeather__return = port.getWeather(_getWeather_theCityCode, _getWeather_theUserID);
        System.out.println("getWeather.result=" + _getWeather__return);


        }
        {
        System.out.println("Invoking getSupportCityDataset...");
        java.lang.String _getSupportCityDataset_theRegionCode = "";
        com.cx.wxs.utils.weather.GetSupportCityDatasetResponse.GetSupportCityDatasetResult _getSupportCityDataset__return = port.getSupportCityDataset(_getSupportCityDataset_theRegionCode);
        System.out.println("getSupportCityDataset.result=" + _getSupportCityDataset__return);


        }
        {
        System.out.println("Invoking getRegionCountry...");
        com.cx.wxs.utils.weather.ArrayOfString _getRegionCountry__return = port.getRegionCountry();
        System.out.println("getRegionCountry.result=" + _getRegionCountry__return);


        }
        {
        System.out.println("Invoking getSupportCityString...");
        java.lang.String _getSupportCityString_theRegionCode = "";
        com.cx.wxs.utils.weather.ArrayOfString _getSupportCityString__return = port.getSupportCityString(_getSupportCityString_theRegionCode);
        System.out.println("getSupportCityString.result=" + _getSupportCityString__return);


        }
        {
        System.out.println("Invoking getRegionProvince...");
        com.cx.wxs.utils.weather.ArrayOfString _getRegionProvince__return = port.getRegionProvince();
        System.out.println("getRegionProvince.result=" + _getRegionProvince__return);


        }
        {
        System.out.println("Invoking getRegionDataset...");
        com.cx.wxs.utils.weather.GetRegionDatasetResponse.GetRegionDatasetResult _getRegionDataset__return = port.getRegionDataset();
        System.out.println("getRegionDataset.result=" + _getRegionDataset__return);


        }

        System.exit(0);
    }

}
