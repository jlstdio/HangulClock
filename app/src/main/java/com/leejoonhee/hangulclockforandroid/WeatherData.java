package com.leejoonhee.hangulclockforandroid;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class WeatherData {

    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
        WeatherData weather = new WeatherData();
        weather.setXML();
    }

    public void setXML() throws SAXException, IOException, ParserConfigurationException{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse("http://www.kma.go.kr/wid/queryDFS.jsp?gridx=89&gridy=115");
        if(document != null){
            NodeList list = document.getElementsByTagName("data");
            System.out.println("차일드 노드의 엘리먼트 수"+list.item(0).getChildNodes().getLength());
            for(int i = 0; i < list.getLength(); i++){
                System.out.println("==="+list.item(i).getAttributes().getNamedItem("seq").getTextContent()+"===");
                //childNode 출력
                for(int k = 0; k < list.item(i).getChildNodes().getLength(); k++){
                    if(list.item(i).getChildNodes().item(k).getNodeType() == Node.ELEMENT_NODE){
                        System.out.print(k+":"+list.item(i).getChildNodes().item(k).getNodeName()+"====>");
                        System.out.println(list.item(i).getChildNodes().item(k).getTextContent());
                    }
                }
            }
        }
    }//end setXML
}