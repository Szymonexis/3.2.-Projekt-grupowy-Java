package com.example.projekt7;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.sql.*;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
        insertCar(new Car("bimer", "bmw"));
    }

    public long insertCar(Car car) {
        String SQLinsert = "INSERT INTO tblcars(carname,brand) "
                + "VALUES(?,?)";

        long id = 0;

        try (Connection conn = HelloApplication.conn;
             PreparedStatement preparedStatement = conn.prepareStatement(SQLinsert, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(0, car.getId());
            preparedStatement.setString(1, car.getCarname());
            preparedStatement.setString(2, car.getBrand());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                try (ResultSet rs = preparedStatement.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getLong(1);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }

}