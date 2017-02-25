package com.example.administrator.myweather;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lidianfen on 2016/12/12.
 */
public class SaxHandler extends DefaultHandler {
    private Map<String,List<String>> cityMap=new HashMap<String,List<String>>();
    String cityName="";
    String provinceName="";
    public Map<String,List<String>> getCityMap(){
        return cityMap;
    }
    public void starElenment(String uri, String localName, String qName, Attributes attributes) throws SAXException{
        if("Province".equals(qName)){
            provinceName=attributes.getValue("name");
            cityMap.put(provinceName,new ArrayList<String>());
        }else if("City".equals(qName)){
            cityName=attributes.getValue("name");
        }
    }
    public  void endElement(String uri,String localName,String qName) throws SAXException{
        if("City".equals(qName)){
            cityMap.get(provinceName).add(cityName);
        }
    }
    public void starDocument() throws SAXException{
        super.startDocument();
    }
    public void endDocument() throws SAXException{
        super.endDocument();
    }

}
