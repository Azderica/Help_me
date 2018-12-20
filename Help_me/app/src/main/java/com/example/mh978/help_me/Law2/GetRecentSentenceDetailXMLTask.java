package com.example.mh978.help_me.Law2;

import android.os.AsyncTask;
import android.util.Log;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class GetRecentSentenceDetailXMLTask extends AsyncTask<String, Void, Document>
{
    URL url;
    Document doc = null;

    static String nick_str;
    static String eventNo_str;
    static String eventNm_str;
    static String adjuDate_str;
    static String exeBook_str;
    static String atchNm_str;
    static String atchFilePath_str;
    static String content_str;

    @Override
    protected Document doInBackground(String... urls) {
        try
        {
            url = new URL(urls[0]);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.parse(new InputSource(url.openStream()));
            doc.getDocumentElement().normalize();
        }
        catch (Exception e)
        {
            Log.i("doInBackground", "error");
            e.printStackTrace();
        }

        return doc;
    }

    @Override
    protected void onPostExecute(Document document) {
        NodeList nodeList = doc.getElementsByTagName("item");

        for(int i = 0; i< nodeList.getLength(); i++)
        {
            Node node = nodeList.item(i);
            Element fstElmnt = (Element) node;

            NodeList nick_Node = fstElmnt.getElementsByTagName("nick");
            nick_str = "";
            if (nick_Node.item(0).getChildNodes().item(0).getNodeValue() != null)
                nick_str += nick_Node.item(0).getChildNodes().item(0).getNodeValue() +"\n";

            NodeList eventNo_Node = fstElmnt.getElementsByTagName("eventNo");
            eventNo_str = "";
            if (eventNo_Node.item(0).getChildNodes().item(0).getNodeValue() != null)
                eventNo_str += eventNo_Node.item(0).getChildNodes().item(0).getNodeValue() +"\n";

            NodeList eventNm_Node = fstElmnt.getElementsByTagName("eventNm");
            eventNm_str = "";
            if (eventNm_Node.item(0).getChildNodes().item(0).getNodeValue() != null)
                eventNm_str += eventNm_Node.item(0).getChildNodes().item(0).getNodeValue() +"\n";

            NodeList adjuDate_Node  = fstElmnt.getElementsByTagName("adjudgeDt");
            adjuDate_str = "";
            if (adjuDate_Node.item(0).getChildNodes().item(0).getNodeValue() != null)
                adjuDate_str += adjuDate_Node.item(0).getChildNodes().item(0).getNodeValue() +"\n";

            /*NodeList exeBook_Node  = fstElmnt.getElementsByTagName("exeBook");
            exeBook_str = "";
            if (exeBook_Node.item(0).getChildNodes().item(0) != null)
                exeBook_str += exeBook_Node.item(0).getChildNodes().item(0).getNodeValue() +"\n";

            NodeList atchNm_Node  = fstElmnt.getElementsByTagName("atchNm");
            atchNm_str = "";
            if (atchNm_Node.item(0).getChildNodes().item(0).getNodeValue() != null)
                atchNm_str += atchNm_Node.item(0).getChildNodes().item(0).getNodeValue() +"\n";

            NodeList atchFilePath_Node  = fstElmnt.getElementsByTagName("atchFilePath");
            atchFilePath_str = "";
            atchFilePath_str += atchFilePath_Node.item(0).getChildNodes().item(0).getNodeValue() +"\n";*/

            NodeList content_Node  = fstElmnt.getElementsByTagName("content");
            content_str = "";
            if (content_Node.item(0).getChildNodes().item(0).getNodeValue() != null)
                content_str += content_Node.item(0).getChildNodes().item(0).getNodeValue() +"\n";
        }

        RecentSentenceSearchFragment.mListView.setAdapter(RecentSentenceSearchFragment.rslistAdapter);

        super.onPostExecute(doc);
    }
}
