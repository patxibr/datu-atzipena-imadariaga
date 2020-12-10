/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class BilatuEgileaIzenaJakinda {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("Liburuak.xml"));

        String izenburua = "Harry Potter";
        String egilea = "";
        boolean aurkituta = false;

        NodeList liburuNodoak = document.getElementsByTagName("liburu");

        for (int i = 0; i < liburuNodoak.getLength() && !aurkituta; i++) {
            Node nodoa = liburuNodoak.item(i);
            Element elemLiburua = (Element) nodoa;
            //System.out.print(elemLiburua.getAttribute("isbn") + " - ");
            NodeList liburuNodoarenSemeak = nodoa.getChildNodes();
            String unekoIzenburua = elemLiburua.getElementsByTagName("izenburua").item(0).getNodeValue();
            for (int j = 0; j < liburuNodoarenSemeak.getLength(); j++) {
                Node semea = liburuNodoarenSemeak.item(j);

                if (semea.getNodeName().equals("izenburua")) {

                    if (((Element) semea.getChildNodes()).getTextContent().equals(izenburua)) {
                        //System.out.println(semea.getNodeName() == "egilea");
                        //System.out.println(egilea);
                        aurkituta = true;
                    }
                }
                if (semea.getNodeName().equals("egilea") && aurkituta) {
                    String aurkit = semea.getTextContent();
                    egilea = aurkit;
                }
            }
            System.out.println(egilea);
        }
    }
}