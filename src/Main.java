import Model.Book;
import xml.parsers.DOMParser;
import xml.parsers.SAXXMLParser;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Parsing xml with DOM parser:");
        DOMParser domParser = new DOMParser();
        List<Book> books = domParser.parse("ListOfBooks.xml");
        books.forEach(System.out::println);

        System.out.println("Parsing xml with SAX parser:");
        SAXXMLParser saxxmlParser = new SAXXMLParser();
        List<Book> books1 = saxxmlParser.parse("ListOfBooks.xml");
        books1.forEach(System.out::println);
    }
}
