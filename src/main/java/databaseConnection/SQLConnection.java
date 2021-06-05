package databaseConnection;

import dto.Book;
import dto.User;

import java.sql.*;
import java.util.Scanner;


public class SQLConnection {

    static String url = "jdbc:mysql://localhost:3306/";
    static String dbName = "Library_System";
    static String driver = "com.mysql.jdbc.Driver";
    static String userName = "root";
    static String password = "";


    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        return DriverManager.getConnection(url + dbName, userName, password);
    }

    //Select from table: Books
    public static void selectBook() {
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();

            System.out.println("BOOK_ID" + "\t" + "TITLE" + "\t"
                    + "AUTHOR"+ "\t"+ "SUBJECT" + "\t" + "PUBLISH_DATE");

            String query = "select * from Books";

            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getInt("book_id") + "  "
                        + rs.getString("title")
                        + "  " + rs.getString("author")
                        + "  " + rs.getString("subject")
                        + "  " + rs.getTimestamp("publication_date"));
            }
            con.close();
        } catch (ClassNotFoundException | SQLException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }
    }

    //delete from table: Books
    public static void deleteBook() throws SQLException {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter book_id: ");
            int book_id = sc.nextInt();

            Connection con = getConnection();
            Statement stmt = con.createStatement();

            String query = "delete from Books where book_id=" + book_id;
            stmt.executeUpdate(query);
            con.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    //insert into table: Books
    public static void insertBook(Book book) throws SQLException {
        try {
            Connection con = getConnection();
            String query = "INSERT INTO Books (title, author, subject, publication_date) " +
                    "VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(query);

            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getAuthor());
            stmt.setString(3, book.getSubject());
            stmt.setTimestamp(4, book.getPublishDate());
            stmt.executeUpdate();
            con.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    //update from table: Books
    public static void updateBook(Book book) throws SQLException {
        try {
            Connection con = getConnection();
            String query= "update Books set title = ? , author = ?, publication_date = ?" +
                    "where book_id = ?";

            PreparedStatement stmt = con.prepareStatement(query);

            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getAuthor());
            stmt.setTimestamp(3, book.getPublishDate());
            stmt.setInt(4, book.getId());
            stmt.executeUpdate();
            con.close();

        } catch (ClassNotFoundException e) {
            System.err.println("Got an exception! ");
            e.printStackTrace();
        }

    }



    //insert into table: users
    public static void insertUser(User user) throws SQLException {
        try {
            Connection con = getConnection();
            String query = "INSERT INTO users (user_name, password) " +
                    "VALUES (?, ?)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, user.getUser_name());
            stmt.setString(2, user.getPassword());
            System.out.println(stmt);
            stmt.executeUpdate();
            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }



    //Select from table: users
    public static void selectUser() {
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter user_name:");

            String user_name = sc.next();
            String query = "select * from users where user_name='"+ user_name + "'";
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                System.out.println("Successfully login!");
            } else System.out.println("Please Signup");
            con.close();
        }
        catch (ClassNotFoundException | SQLException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }
    }


}
