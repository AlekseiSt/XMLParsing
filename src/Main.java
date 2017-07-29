import Model.Book;
import Model.HBook;
import ORM.HibernateSaver;
import ORM.JDBCSaver;
import xml.parsers.DOMParser;
import xml.parsers.SAXXMLParser;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Parsing for JDBC
        System.out.println("Parsing xml with DOM parser:");
        DOMParser domParser = new DOMParser();
        List<Book> books = domParser.parse("ListOfBooks.xml");
        books.forEach(System.out::println);

        // Parsing for Hibernate
        System.out.println("Parsing xml with SAX parser:");
        SAXXMLParser saxxmlParser = new SAXXMLParser();
        List<HBook> books1 = saxxmlParser.parse("ListOfBooks.xml");
        books1.forEach(System.out::println);

        System.out.println("Now I want to save books in database.");
        System.out.println("Save books, using JDBC:");
        JDBCSaver jdbcSaver = new JDBCSaver();
        jdbcSaver.save(books);
        System.out.println("Books successfully saved by JDBC!");

        System.out.println("Save books, using Hibernate:");
        HibernateSaver hibernateSaver = new HibernateSaver();
        hibernateSaver.save(books1);
        System.out.println("Books successfully saved by Hibernate!");
    }
}
