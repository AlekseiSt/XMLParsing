package Model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Class for Hibernate
 */
@Entity
@Table(name = "Books")
public class HBook {
    @Id
    @Column(name = "book_id")
    //@GeneratedValue(strategy= GenerationType.AUTO)
    @GenericGenerator(name="kaugen" , strategy="increment")
    @GeneratedValue(generator="kaugen")
    private int id;
    @Column(name = "x_title")
    private String title;
    @Column(name = "x_author")
    private String author;
    @Column(name = "x_date")
    private String date;
    @Column(name = "x_isbn")
    private String isbn;
    @Column(name = "x_publisher")
    private String publisher;
    @Column(name = "x_cost")
    private String cost;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HBook(String title, String author, String date, String isbn, String publisher, String cost) {
        this.title = title;
        this.author = author;
        this.date = date;
        this.isbn = isbn;
        this.publisher = publisher;
        this.cost = cost;
    }

    public HBook(String title, String author, String date) {
        this.title = title;
        this.author = author;
        this.date = date;
    }

    public HBook(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public HBook() {}

    @Override
    public String toString() {
        return "HBook{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", date='" + date + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publisher='" + publisher + '\'' +
                ", cost='" + cost + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HBook book = (HBook) o;

        if (title != null ? !title.equals(book.title) : book.title != null) return false;
        if (author != null ? !author.equals(book.author) : book.author != null) return false;
        if (date != null ? !date.equals(book.date) : book.date != null) return false;
        if (isbn != null ? !isbn.equals(book.isbn) : book.isbn != null) return false;
        if (publisher != null ? !publisher.equals(book.publisher) : book.publisher != null) return false;
        return cost != null ? cost.equals(book.cost) : book.cost == null;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
        result = 31 * result + (publisher != null ? publisher.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        return result;
    }
}