package ru.reeson2003.diystore.model.samples;

import org.h2.jdbcx.JdbcDataSource;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Date 15.04.17.
 *
 * @author Pavel Gavrilov
 */
public class MainTest {
    public static void main(String[] args) {
        JdbcDataSource dataSource = new JdbcDataSource();
        try {
            Properties dbProps = new Properties();
            FileReader fileReader = new FileReader("h2database.properties");
            //noinspection Since15
            dbProps.load(fileReader);
            fileReader.close();
            String url = dbProps.getProperty("url");
            String user = dbProps.getProperty("user");
            String password = dbProps.getProperty("password");
            dataSource.setUrl(url);
            dataSource.setUser(user);
            dataSource.setPassword(password);

            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            BufferedReader reader = new BufferedReader(new FileReader("query.sql"));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String s = reader.readLine();
                if (s != null)
                    sb.append(s);
                else
                    break;
            }
            statement.execute(sb.toString());
            statement.close();
            connection.close();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
