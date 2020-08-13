package lib;

import dbConnection.SQLConnection;
import dto.User;

import java.sql.SQLException;
import java.util.Scanner;

import static dbConnection.SQLConnection.*;

public class UserMng {

    public static void main(String[] args) throws SQLException {

        User user = new User();
        int login=1, signup=2;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Input:");
        int input = scanner.nextInt();

        if(input == login)
        {
            selectUser(); }

        else if(input == signup)
        {
            System.out.println("Enter user_name:");
            String username = user.setUser_name(scanner.next());
            System.out.println("Enter password:");
            String password = user.setPassword(scanner.next());
            SQLConnection.insertUser(user); }

        else {
            System.out.println("INVALID INPUT!");

        }
    }

}
