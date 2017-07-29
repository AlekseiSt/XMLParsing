package ORM;

import Model.Book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class JDBCSaver {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    //  Database credentials
    static final String USER = "system";
    static final String PASS = "qwerty";
    // Database constants
    static final String BOOKS = "BOOKS";
    static final String X_TITLE = "X_TITLE";
    static final String X_DATE = "X_DATE";
    static final String X_ISBN = "X_ISBN";
    static final String X_PUBLISHER = "X_PUBLISHER";
    static final String X_COST = "X_COST";

    private Connection connection;
    private Statement statement;

    public JDBCSaver() {

    }

    public void save(List<Book> books) {
        try {
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);
            // Open a connection
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            statement = connection.createStatement();

            books.forEach((Book book) -> {
                try {
                    statement.executeUpdate(getInsertQuery(book.getTitle(),
                            book.getDate(),
                            book.getIsbn(),
                            book.getPublisher(),
                            book.getCost()));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private String getInsertQuery(String title, String date, String isbn, String publisher, String cost) {
        return "INSERT INTO " + BOOKS +
                " (" + X_TITLE + ", " + X_DATE + ", " + X_ISBN + ", " + X_PUBLISHER + ", " + X_COST  + ") " +
                "VALUES ('" + title + "', '" + date + "', '" + isbn + "', '" + publisher + "', '" + cost + "')";
    }
}
