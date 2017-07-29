package xml.parsers;

import Model.HBook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SAXXMLParserTest {

    private SAXXMLParser saxxmlParser = new SAXXMLParser();
    private List<HBook> books = new ArrayList<>();

    @BeforeEach
    void init() {
        HBook book1 = new HBook("Title1", "Author1", "2001", "81-40-34319-1", "Publisher1", "Cost1");
        HBook book2 = new HBook("Title2", "Author2", "2002");
        HBook book3 = new HBook("Title3", "Author3");
        HBook book4 = new HBook();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
    }

    @Test
    void testParse() {
        List<HBook> parsedBooks = saxxmlParser.parse("xmlForTest.xml");
        assertEquals(parsedBooks.size(), books.size());
        for (int i = 0; i < parsedBooks.size(); i++) {
            assertEquals(parsedBooks.get(i), books.get(i));
        }
    }
}