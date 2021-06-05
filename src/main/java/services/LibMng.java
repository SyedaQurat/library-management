package services;

import dto.Book;
import databaseConnection.SQLConnection;

import java.sql.Timestamp;
import java.util.Scanner;
import java.sql.SQLException;

public class LibMng {

    public static void main(String args[]) throws SQLException {

        Book book = new Book();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Title");
        String title = book.setTitle(scanner.next());
        System.out.println("Author");
        String author = book.setAuthor(scanner.next());
        System.out.println("Subject");
        String subject = book.setSubject(scanner.next());

        java.util.Date date = new java.util.Date();
        Timestamp publish_date=new Timestamp(date.getTime());
        System.out.println("Publish Date" + "\t" + publish_date);
        book.setPublishDate(publish_date);

        SQLConnection.insertBook(book);

        SQLConnection.selectBook();

        SQLConnection.deleteBook();

        SQLConnection.selectBook();
        System.out.println("Publish Date" + "\t" + publish_date);
        book.setPublishDate(publish_date);

        System.out.println("Title");
        String title1 = book.setTitle(scanner.next());
        System.out.println("Author");
        String author1 = book.setAuthor(scanner.next());
        System.out.println("Book id");
        int bookId = book.setId(scanner.nextInt());
        System.out.println("Publish Date" + "\t" + publish_date);
        book.setPublishDate(publish_date);

        SQLConnection.updateBook(book);

        SQLConnection.selectBook();

    }
}
