package xml.parsers;

import Model.Book;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DOMParser {
    private DocumentBuilder documentBuilder;

    public DOMParser() {
        try {
            documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public List<Book> parse(String xmlName) {
        List<Book> bookList = new ArrayList<>();
        try {
            Document document = documentBuilder.parse(xmlName);
            Node root = document.getDocumentElement();

            Book bookItem;

            NodeList books = root.getChildNodes();
            for (int i = 0; i < books.getLength(); i++) {
                Node book = books.item(i);
                // if it is not text then it's book
                if (book.getNodeType() != Node.TEXT_NODE) {
                    NodeList bookProps = book.getChildNodes();
                    bookItem = new Book();
                    for(int j = 0; j < bookProps.getLength(); j++) {
                        Node bookProp = bookProps.item(j);
                        // if it is not text then it one of book parameters
                        if (bookProp.getNodeType() != Node.TEXT_NODE) {
                            bookItem.paramSetter(bookProp.getNodeName(), bookProp.getChildNodes().item(0).getTextContent());
                        }
                    }
                    bookList.add(bookItem);
                }
            }

        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
        return bookList;
    }
}
