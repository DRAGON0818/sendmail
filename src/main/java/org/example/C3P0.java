package org.example;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class C3P0 {
    public static void main(String[] args) throws SQLException {
        ComboPooledDataSource oracle = new ComboPooledDataSource("oracle");
        Connection connection = oracle.getConnection();
        System.out.println(connection);

    }
}
