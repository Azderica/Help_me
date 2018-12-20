package com.example.mh978.help_me.Law2;

import android.os.AsyncTask;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class GetRecentSentenceListXMLTask extends AsyncTask<String, Void, Document>
{
    URL url;
    Document doc = null;

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

            NodeList seq_Node = fstElmnt.getElementsByTagName("seq");
            String seq_str = "&seq=";
            seq_str += seq_Node.item(0).getChildNodes().item(0).getNodeValue() +"\n";

            NodeList title_Node = fstElmnt.getElementsByTagName("title");
            String s1 = "";
            s1 += title_Node.item(0).getChildNodes().item(0).getNodeValue() +"\n";

            NodeList eventNo_Node = fstElmnt.getElementsByTagName("eventNo");
            String s2 = "";
            s2 += eventNo_Node.item(0).getChildNodes().item(0).getNodeValue() +"\n";

            NodeList classNm_Node  = fstElmnt.getElementsByTagName("classNm");
            String s3 = "";
            s3 += classNm_Node.item(0).getChildNodes().item(0).getNodeValue() +"\n";

            RecentSentenceSearchFragment.rslistAdapter.addItem(s1, s2, s3);
            RecentSentenceSearchFragment.seqList.add(seq_str);
        }

        RecentSentenceSearchFragment.mListView.setAdapter(RecentSentenceSearchFragment.rslistAdapter);

        super.onPostExecute(doc);
    }
}
