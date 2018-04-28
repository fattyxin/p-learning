package xml;

import com.alibaba.fastjson.JSON;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;

/**
 * Created by qinwanxin on 2018/2/27.
 */
public class ParseXml {

    public static PeopleBean parse(InputStream is) throws Exception {
        final PeopleBean peopleBean = new PeopleBean();
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        XMLReader xmlReader = saxParser.getXMLReader();
        xmlReader.setContentHandler(new DefaultHandler() {
            private boolean printElementValue = false;
            private StringBuffer stringBuffer;

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                System.out.println("startElement " + qName);
                if (PeopleBeanElementEnum.NAME.getName().equals(qName)) {
                    printElementValue = true;
                    stringBuffer = new StringBuffer();
                } else if (PeopleBeanElementEnum.AGE.getName().equals(qName)) {
                    printElementValue = true;
                    stringBuffer = new StringBuffer();
                } else if (printElementValue) {
                    stringBuffer = new StringBuffer();
                }
//                } else {
//                    printElementValue = false;
//                }
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                System.out.println("endElement " + qName);
                boolean sbIsNull = stringBuffer == null;
                System.out.println(sbIsNull ? "sb is null" : stringBuffer.toString());
                if (PeopleBeanElementEnum.getNames().contains(qName) && !sbIsNull) {
                    try {

                        Field declaredField = peopleBean.getClass().getDeclaredField(qName);
                        declaredField.setAccessible(true);
                        declaredField.set(peopleBean, stringBuffer.toString());
                    } catch (NoSuchFieldException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
                printElementValue = false;
                stringBuffer = null;
                System.out.println("-----------------------------");
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                String value = new String(ch, start, length).trim();
                System.out.println("characters " + value + "  printElementValue=" + printElementValue);

                if (printElementValue) {
                    stringBuffer.append(value);
                }
            }
        });

        xmlReader.parse(new InputSource(is));

        return peopleBean;
    }

    /**
     * characters 在 开始 和结束 元素后均会被调用
     */


    public static void main(String[] args) {
        try {
            PeopleBean peopleBean = ParseXml.parse(new FileInputStream(new File("D:\\code\\learn\\p-learning\\p-learn\\src\\main\\resources\\parse-people.xml")));
            System.out.println(JSON.toJSONString(peopleBean));
            System.out.println(PeopleBeanElementEnum.getNames());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
