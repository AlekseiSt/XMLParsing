package xml.parsers;

import Model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DOMParserTest {

    private DOMParser domParser = new DOMParser();
    private List<Book> books = new ArrayList<>();

    @BeforeEach
    void init() {
        Book book1 = new Book("Title1", "Author1", "2001", "81-40-34319-1", "Publisher1", "Cost1");
        Book book2 = new Book("Title2", "Author2", "2002");
        Book book3 = new Book("Title3", "Author3");
        Book book4 = new Book();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
    }

    @Test
    void testParse() {
        List<Book> parsedBooks = domParser.parse("xmlForTest.xml");
        assertEquals(parsedBooks.size(), books.size());
        for (int i = 0; i < parsedBooks.size(); i++) {
            assertEquals(parsedBooks.get(i), books.get(i));
        }
    }
}
