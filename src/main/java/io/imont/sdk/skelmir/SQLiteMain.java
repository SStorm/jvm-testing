package io.imont.sdk.skelmir;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Copyright 2017 IMONT Technologies
 * Created by romanas on 27/01/2017.
 */

public class SQLiteMain {

    public static void main(String[] args) throws Exception {
        Class.forName("org.sqlite.JDBC");
        Connection connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
        Statement statement = connection.createStatement();
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS test (aa integer);");
        ResultSet rs = connection.getMetaData().getColumns("main", null, "test", "aa");
        System.out.println("Found: " + rs.next());
    }
}
