package com.goit.practice.http.practice;

import com.goit.practice.http.User;
//import javafx.application.Application;
//import javafx.scene.Group;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.VBox;
//import javafx.scene.text.Text;
//import javafx.stage.Stage;
import okhttp3.MediaType;
import okhttp3.RequestBody;

import java.io.IOException;

public class Task5 {
//        extends Application {
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 600;
    private static final String CREATE_USER_URL = "https://pingponggoit.herokuapp.com/createUser";
    private static final MediaType JSON_MEDIA_TYPE = MediaType.parse("application/json; charset=utf-8");


//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        Stage stage = new Stage();
//        Group group = new Group();
//        VBox vBox = new VBox();
//        vBox.getChildren().add(new Text("Create user"));
//        createUserHBox(vBox);
//        group.getChildren().add(vBox);
//        Scene scene = new Scene(group, WIDTH, HEIGHT);
//        stage.setTitle("User");
//        stage.setScene(scene);
//        stage.show();
//    }
//
//    private HBox createUserHBox(VBox vBox) {
//        HBox createUserBox = new HBox();
//        TextField name = new TextField();
//        createUserBox.getChildren().add(new Text("Name:"));
//        createUserBox.getChildren().add(name);
//
//        TextField surname = new TextField();
//        createUserBox.getChildren().add(new Text("Surname:"));
//        createUserBox.getChildren().add(surname);
//
//        TextField salary = new TextField();
//        createUserBox.getChildren().add(new Text("Salary:"));
//        createUserBox.getChildren().add(salary);
//
//        TextField gender = new TextField();
//        createUserBox.getChildren().add(new Text("Gender:"));
//        createUserBox.getChildren().add(gender);
//
//        Button saveButton = new Button("Save");
//        vBox.getChildren().addAll(createUserBox);
//        vBox.getChildren().add(saveButton);
//
//        Text responseMessage = new Text();
//        vBox.getChildren().add(responseMessage);
//
//        saveButton.setOnAction((action) -> {
//            User user = new User.Builder()
//                    .name(name.getText())
//                    .surname(surname.getText())
//                    .gender(gender.getText())
//                    .salary(Integer.parseInt(salary.getText()))
//                    .build();
//
//            try {
//                User resultUser = HttpUtil.sendPost(CREATE_USER_URL, RequestBody.create(JSON_MEDIA_TYPE, JsonUtil.writeValueAsString(user)),
//                        User.class);
//                responseMessage.setText("User saved with id " + resultUser.getId());
//            } catch (IOException e) {
//                responseMessage.setText("Error while creating user " + e.getMessage());
//            }
//        });
//
//        return createUserBox;
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
}
