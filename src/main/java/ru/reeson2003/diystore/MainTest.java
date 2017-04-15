package ru.reeson2003.diystore;

import org.h2.jdbcx.JdbcDataSource;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Date 15.04.17.
 * @author Pavel Gavrilov
 */
public class MainTest {
    public static void main(String[] args) {
        JdbcDataSource dataSource = new JdbcDataSource();
        String url = "jdbc:h2:./h2db";
        String user = "admin";
        String password = "12345678";
        dataSource.setUrl(url);
        dataSource.setUser(user);
        dataSource.setPassword(password);
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            BufferedReader reader = new BufferedReader(new FileReader("query.sql"));
            StringBuilder sb = new StringBuilder();
            while (true){
                String s = reader.readLine();
                if (s != null)
                    sb.append(s);
                else
                    break;
            }
            statement.execute(sb.toString());
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
