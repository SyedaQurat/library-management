package dto;

import java.sql.Timestamp;


public class Book {

        private int id;
        private String title;
        private String author;
        private String subject;
        private Timestamp publishDate;

        public int getId() {
            return id;
        }

        public int setId(int id) {
            this.id = id;
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String setTitle(String title) {
            this.title = title;
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public String setAuthor(String author) {
            this.author = author;
            return author;
        }

        public String getSubject() {
            return subject;
        }

        public String setSubject(String subject) {
            this.subject = subject;
            return subject;
        }

        public java.sql.Timestamp getPublishDate() {
            return (java.sql.Timestamp) publishDate;
        }

        public java.sql.Timestamp setPublishDate(Timestamp publishDate) {
            this.publishDate = publishDate;
            return publishDate;
        }

        @Override
        public String toString() {
            return "Books{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", author='" + author + '\'' +
                    ", subject='" + subject + '\'' +
                    ", publish_date=" + publishDate +
                    '}';
        }

        /*  public void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            String title = sc.next();
            String author = sc.next();
            String subject = sc.next();

            System.out.println(insertQuery(title, author, subject));

        }
        public String insertQuery;

        public  String[] insertQuery(String book_Title, String book_author,
                                           String book_subject)

        {

            String ar[] = new String[3];
            ar[0]= book_Title;
            ar[1] = book_author;
            ar[2] = book_subject;
            return ar;

        }*/

    }
