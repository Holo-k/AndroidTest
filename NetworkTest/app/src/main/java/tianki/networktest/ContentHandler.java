package tianki.networktest;

import android.util.Log;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by Tiank on 9/15/2017.
 */

public class ContentHandler extends DefaultHandler {

    private String nodeName;
    private StringBuilder id;
    private StringBuilder name;
    private StringBuilder version;

    private static final String TAG = "ContentHandler";
    @Override
    public void startDocument() throws SAXException {
        id=new StringBuilder();
        name=new StringBuilder();
        version=new StringBuilder();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
       nodeName=localName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if ("id".equals(nodeName)){
            id.append(ch,start,length);
        }else  if ("name".equals(nodeName)){
            name.append(ch,start,length);

        }else  if ("version".equals(nodeName)){
            version.append(ch,start,length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("app".equals(localName)){
            Log.d(TAG, "id:  "+id);
            Log.d(TAG, "name:  "+name);
            Log.d(TAG, "version:  "+version);
            id.setLength(0);
            name.setLength(0);
            version.setLength(0);
        }
    }


    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }
}
