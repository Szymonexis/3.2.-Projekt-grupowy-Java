package com.example.projekt7;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class HelloApplication extends Application {
    public static Connection conn;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws SQLException {
        conn.close();
    }

    public static void main(String[] args) throws SQLException {
        connectToDatabase();
        launch();
    }

    private static void connectToDatabase() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/";
        Properties props = new Properties();
        props.setProperty("user", PostgresAccess.USERNAME.getValue());
        props.setProperty("password", PostgresAccess.PASSWORD.getValue());
        props.setProperty("ssl","false");
        conn = DriverManager.getConnection(url, props);

        String deleteSql = "Drop Table tblcars";
        Statement delStatement = conn.createStatement();
        delStatement.executeUpdate(deleteSql);
        delStatement.close();

        String createSql = "Create Table tblcars(id int primary key, carname varchar, brand varchar)";
        Statement createStatement = conn.createStatement();
        createStatement.executeUpdate(createSql);
        createStatement.close();
    }
}