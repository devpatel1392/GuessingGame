
package guessinggame;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.math.*;

public class GuessingGame extends Application {
    private int counter = 0;
    @Override
    public void start(Stage primaryStage) {
        
        RadioButton rb1 = new RadioButton("One");
        RadioButton rb2 = new RadioButton("Two");
        RadioButton rb3 = new RadioButton("Three");
        RadioButton rb4 = new RadioButton("Four");
        
        ToggleGroup tg = new ToggleGroup();
        
        rb1.setToggleGroup(tg);
        rb2.setToggleGroup(tg);
        rb3.setToggleGroup(tg);
        rb4.setToggleGroup(tg);
        
        TextArea textArea = new TextArea();
        textArea.setPrefColumnCount(10);
        
        Button btn = new Button("Guess");
        btn.setOnAction(e -> textArea.setText(isRight()));
        
        VBox vb1 = new VBox(rb1, rb3);
        vb1.setPadding(new Insets(10));
        vb1.setAlignment(Pos.CENTER_LEFT);
        VBox vb2 = new VBox(rb2, rb4);
        vb2.setPadding(new Insets(10));
        vb2.setAlignment(Pos.CENTER_LEFT);
        VBox vb3 = new VBox(btn, textArea);
        vb3.setPadding(new Insets(10));
        vb3.setAlignment(Pos.CENTER_RIGHT);
        
        BorderPane pane = new BorderPane();
        pane.setLeft(vb1);
        pane.setCenter(vb2);
        pane.setRight(vb3);
        
        Scene scene = new Scene(pane, 300, 250);
        
        primaryStage.setTitle("Guessing Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    private String isRight() {
        double r = Math.random();
        if (r < 0.25) {
            return ("Correct!\nWins: " + ++counter);
        } else {
            return ("Wrong!\nWins: " + counter);
        }
        
    }
    
}
