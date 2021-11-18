package Lecture_18;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Lecture_18 {
    Connection connection;
    Statement statement;

    String url = "jdbc:mysql://db4free.net/testqa07?user=testqa07&password=testqa07";

    @BeforeTest
    public void precondition() throws Exception {
        this.connection = DriverManager.getConnection(url);
        this.statement = connection.createStatement();

    }

    @Test
    public void insert1SQL() throws Exception {
        statement.executeUpdate("INSERT INTO user_table (userID, firstName) VALUES (19, 'Helen')");
        ResultSet resultset = statement.executeQuery("select * from user_table where userID = 19");
        resultset.next();
        String result = resultset.getString("firstName");
        System.out.println(result);
    }

    @Test
    public void insert2SQL() throws Exception {
        statement.executeUpdate("INSERT INTO user_table (userID, firstName) VALUES (22, 'someUser')");
        ResultSet resultset = statement.executeQuery("select * from user_table where userID = 22");
        resultset.next();
        String result = resultset.getString("firstName");
        System.out.println(result);
    }

    @Test
    public void update1SQL() throws Exception {
        statement.executeUpdate("UPDATE user_table SET firstName = 'QA_07' WHERE userID = 22");
        ResultSet resultset = statement.executeQuery("select * from user_table where userID = 22");
        resultset.next();
        String result = resultset.getString("firstName");
        System.out.println(result);
    }

    @Test
    public void update2SQL() throws Exception {
        statement.executeUpdate("UPDATE user_table SET firstName = 'CHECK' WHERE userID = 19");
        ResultSet resultset = statement.executeQuery("select * from user_table where userID = 19");
        resultset.next();
        String result = resultset.getString("firstName");
        System.out.println(result);
    }

    @Test
    public void delete1SQL() throws Exception {
        statement.executeUpdate("DELETE FROM user_table WHERE userID = 19");
        List<List<String>> data = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery("select * from user_table");
            while (resultSet.next()) {
                List<String> row = new ArrayList<>();
                for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                    row.add(resultSet.getString(i));
                }
                data.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(data);

    }
}
