package xml.parsers;

import Model.HBook;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static Model.ModelConstants.*;

public class SAXXMLParser {
    private SAXParser saxParser;

    public SAXXMLParser() {
        try {
            this.saxParser = SAXParserFactory.newInstance().newSAXParser();
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }

    public List<HBook> parse(String xmlName) {
        try {
            BookHandler bookHandler = new BookHandler();
            saxParser.parse(xmlName, bookHandler);
            return bookHandler.books;
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    class BookHandler extends DefaultHandler {
        List<HBook> books = new ArrayList<>();
        HBook bookItem;
        boolean book;
        boolean title;
        boolean author;
        boolean date;
        boolean isbn;
        boolean publisher;
        boolean cost;

        @Override
        public void endElement (String uri, String localName, String qName) throws SAXException
        {
            if (qName.equalsIgnoreCase(BOOK)) {
                books.add(bookItem);
            }
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase(BOOK)) {
                book = true;
            } else if (qName.equalsIgnoreCase(TITLE)) {
                title = true;
            } else if (qName.equalsIgnoreCase(AUTHOR)) {
                author = true;
            } else if (qName.equalsIgnoreCase(DATE)) {
                date = true;
            } else if (qName.equalsIgnoreCase(ISBN)) {
                isbn = true;
            } else if (qName.equalsIgnoreCase(PUBLISHER)) {
                publisher = true;
            } else if (qName.equalsIgnoreCase(COST)) {
                cost = true;
            }
        }

        @Override
        public void characters(char ch[], int start, int length) throws SAXException {
            if (book) {
                bookItem = new HBook();
                book = false;
            } else if (title) {
                bookItem.setTitle(new String(ch, start, length));
                title = false;
            } else if (author) {
                bookItem.setAuthor(new String(ch, start, length));
                author = false;
            } else if (date) {
                bookItem.setDate(new String(ch, start, length));
                date = false;
            } else if (isbn) {
                bookItem.setIsbn(new String(ch, start, length));
                isbn = false;
            } else if (publisher) {
                bookItem.setPublisher(new String(ch, start, length));
                publisher = false;
            } else if (cost) {
                bookItem.setCost(new String(ch, start, length));
                cost = false;
            }
        }
    }
}
