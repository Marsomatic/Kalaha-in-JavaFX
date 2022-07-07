import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.geometry.Pos;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * Beschreibung
 *
 * @version 1.1.0 vom 24.06.2022
 * @author Matej Markovic 
 */

public class Kalaha extends Application {
  // Anfang Attribute
  Button[] btn = new Button[14];
  private Button restart = new Button();
  private Rectangle p1Rect = new Rectangle();
  private Rectangle p1Mulde = new Rectangle();
  private Rectangle p2Rect = new Rectangle();
  private Rectangle p2Mulde = new Rectangle();
  private Text win = new Text();
  private Text score1 = new Text();
  private int scoreP1 = 0;
  private String score1Text = "Player 1:\n   " + scoreP1;
  private Text score2 = new Text();
  private int scoreP2 = 0;
  private String score2Text = "Player 2:\n   " + scoreP2;
  
  private int[] score = {4, 4, 4, 4, 4, 4, 0, 4, 4, 4, 4, 4, 4, 0};
  private boolean turn = true; // true = player1; false = player2
  private boolean player1Win = false;
  // Ende Attribute
  
  public void start(Stage primaryStage) {
    Pane r = new Pane();
    Scene scene = new Scene(r, 500, 250);
    // Anfang Komponenten
    for (int i = 0; i < 14; i++) {
      btn[i] = new Button();
    }
    for (int i = 0; i < 14; i++) {
      btn[i].setText(String.valueOf(score[i]));
      btn[i].setStyle("-fx-background-radius: 5em; ");
    }
    
    p1Rect.setX(130);
    p1Rect.setY(125);
    p1Rect.setWidth(240);
    p1Rect.setHeight(40); 
    r.getChildren().add(p1Rect);
    
    p1Mulde.setX(370);
    p1Mulde.setY(85);
    p1Mulde.setWidth(40);
    p1Mulde.setHeight(80);
    r.getChildren().add(p1Mulde);
    
    
    p2Rect.setX(130);
    p2Rect.setY(85);
    p2Rect.setWidth(240);
    p2Rect.setHeight(40); 
    r.getChildren().add(p2Rect);
    
    p2Mulde.setX(90);
    p2Mulde.setY(85);
    p2Mulde.setWidth(40);
    p2Mulde.setHeight(80);
    r.getChildren().add(p2Mulde);
    
    // Start Farbe
    p1Rect.setFill(Color.web("#38f251", 0.5));
    p1Mulde.setFill(Color.web("#38f251", 0.5));
    p2Rect.setFill(Color.web("#636363", 0.5));
    p2Mulde.setFill(Color.web("#636363", 0.5));
    
    win.setTranslateX(185);
    win.setTranslateY(30);
    win.setFont(Font.font ("Verdana", 20));
    win.setFill(Color.web("#367d9c"));
    //win.setText("Player 1 won!");
    r.getChildren().add(win);
    
    score1.setTranslateX(30);
    score1.setTranslateY(30);
    score1.setFont(Font.font ("Verdana", 15));
    score1.setFill(Color.web("#367d9c"));
    score1.setText(score1Text);
    r.getChildren().add(score1);
    
    score2.setTranslateX(400);
    score2.setTranslateY(30);
    score2.setFont(Font.font ("Verdana", 15));
    score2.setFill(Color.web("#367d9c"));
    score2.setText(score2Text);
    r.getChildren().add(score2);
    
    restart.setLayoutX(200);
    restart.setLayoutY(200);
    restart.setPrefSize(100, 20);
    restart.setText("Restart");
    EventHandler<ActionEvent> restartAction = new EventHandler<ActionEvent>() {
      public void handle(ActionEvent e)
      {
        //score = {4, 4, 4, 4, 4, 4, 0, 4, 4, 4, 4, 4, 4, 0};
        for (int i = 0; i<score.length; i++) {
          if (i != 6 && i != 13) {
            score[i] = 4;
          } else {
            score[i] = 0;  
          } // end of if-else
        } // end of for
        win.setText("");
        turn = true;
        update();
      }
    };
    restart.setOnAction(restartAction);
    r.getChildren().add(restart);
    // =============================================================
    
    btn[0].setLayoutX(135);
    btn[0].setLayoutY(130);
    btn[0].setPrefSize(30, 30);
    EventHandler<ActionEvent> e0 = new EventHandler<ActionEvent>() {
      public void handle(ActionEvent e)
      {
        action(0);
      }
    };
    btn[0].setOnAction(e0);
    r.getChildren().add(btn[0]);
    
    // =============================================================
    
    btn[1].setLayoutX(175);
    btn[1].setLayoutY(130);
    btn[1].setPrefSize(30, 30);
    EventHandler<ActionEvent> e1 = new EventHandler<ActionEvent>() {
      public void handle(ActionEvent e)
      {
        action(1);
      }
    };
    btn[1].setOnAction(e1);
    r.getChildren().add(btn[1]);
    
    // =============================================================
    
    btn[2].setLayoutX(215);
    btn[2].setLayoutY(130);
    btn[2].setPrefSize(30, 30);
    EventHandler<ActionEvent> e2 = new EventHandler<ActionEvent>() {
      public void handle(ActionEvent e)
      {
        action(2);
      }
    };
    btn[2].setOnAction(e2);
    r.getChildren().add(btn[2]);
    
    // =============================================================
    
    btn[3].setLayoutX(255);
    btn[3].setLayoutY(130);
    btn[3].setPrefSize(30, 30);
    EventHandler<ActionEvent> e3 = new EventHandler<ActionEvent>() {
      public void handle(ActionEvent e)
      {
        action(3);
      }
    };
    btn[3].setOnAction(e3);
    r.getChildren().add(btn[3]);
    
    // =============================================================
    
    btn[4].setLayoutX(295);
    btn[4].setLayoutY(130);
    btn[4].setPrefSize(30, 30);
    EventHandler<ActionEvent> e4 = new EventHandler<ActionEvent>() {
      public void handle(ActionEvent e)
      {
        action(4);
      }
    };
    btn[4].setOnAction(e4);
    r.getChildren().add(btn[4]);
    
    // =============================================================
    
    btn[5].setLayoutX(335);
    btn[5].setLayoutY(130);
    btn[5].setPrefSize(30, 30);
    EventHandler<ActionEvent> e5 = new EventHandler<ActionEvent>() {
      public void handle(ActionEvent e)
      {
        action(5);
      }
    };
    btn[5].setOnAction(e5);
    r.getChildren().add(btn[5]);
    
    // =============================================================
    
    btn[6].setLayoutX(375);
    btn[6].setLayoutY(90);
    btn[6].setPrefSize(30, 70);
    EventHandler<ActionEvent> e6 = new EventHandler<ActionEvent>() {
      public void handle(ActionEvent e)
      {
        
      }
    };
    btn[6].setOnAction(e6);
    r.getChildren().add(btn[6]);
    
    // =============================================================
    
    btn[7].setLayoutX(335);
    btn[7].setLayoutY(90);
    btn[7].setPrefSize(30, 30);
    EventHandler<ActionEvent> e7 = new EventHandler<ActionEvent>() {
      public void handle(ActionEvent e)
      {
        action(7);
      }
    };
    btn[7].setOnAction(e7);
    r.getChildren().add(btn[7]);
    
    // =============================================================
    
    btn[8].setLayoutX(295);
    btn[8].setLayoutY(90);
    btn[8].setPrefSize(30, 30);
    EventHandler<ActionEvent> e8 = new EventHandler<ActionEvent>() {
      public void handle(ActionEvent e)
      {
        action(8);
      }
    };
    btn[8].setOnAction(e8);
    r.getChildren().add(btn[8]);
    
    // =============================================================
    
    btn[9].setLayoutX(255);
    btn[9].setLayoutY(90);
    btn[9].setPrefSize(30, 30);
    EventHandler<ActionEvent> e9 = new EventHandler<ActionEvent>() {
      public void handle(ActionEvent e)
      {
        action(9);
      }
    };
    btn[9].setOnAction(e9);
    r.getChildren().add(btn[9]);
    
    // =============================================================
    
    btn[10].setLayoutX(215);
    btn[10].setLayoutY(90);
    btn[10].setPrefSize(30, 30);
    EventHandler<ActionEvent> e10 = new EventHandler<ActionEvent>() {
      public void handle(ActionEvent e)
      {
        action(10);
      }
    };
    btn[10].setOnAction(e10);
    r.getChildren().add(btn[10]);
    
    // =============================================================
    
    btn[11].setLayoutX(175);
    btn[11].setLayoutY(90);
    btn[11].setPrefSize(30, 30);
    EventHandler<ActionEvent> e11 = new EventHandler<ActionEvent>() {
      public void handle(ActionEvent e)
      {
        action(11);
      }
    };
    btn[11].setOnAction(e11);
    r.getChildren().add(btn[11]);
    
    // =============================================================
    
    btn[12].setLayoutX(135);
    btn[12].setLayoutY(90);
    btn[12].setPrefSize(30, 30);
    EventHandler<ActionEvent> e12 = new EventHandler<ActionEvent>() {
      public void handle(ActionEvent e)
      {
        action(12);
      }
    };
    btn[12].setOnAction(e12);
    r.getChildren().add(btn[12]);
    
    // =============================================================
    
    btn[13].setLayoutX(95);
    btn[13].setLayoutY(90);
    btn[13].setPrefSize(30, 70);
    EventHandler<ActionEvent> e13 = new EventHandler<ActionEvent>() {
      public void handle(ActionEvent e)
      {
        
      }
    };
    btn[13].setOnAction(e13);
    r.getChildren().add(btn[13]);
    
    // =============================================================
    
    primaryStage.setOnCloseRequest(e -> System.exit(0));
    primaryStage.setTitle("Kalaha");
    primaryStage.setScene(scene);
    primaryStage.show();
  } // end of public Kalaha
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    launch(args);
    
  } // end of main
  
  public void checkEmpty(int index) {
    /*
    ueberpruefe ob der zug bei einem eigenen feld mit score 0 endet und ob der feld gueltig ist (auf der richtigen seite)
      --> endfeld-index: (index + score) % 14
      sammelmulde += endfeldfeld + feld gegenueber;
        --> feld gegenueber index: 12 - endfeld-index
      feld und feld gegenueber 0 setzen
    */
    int endfeld = (index + score[index]) % 14; 
    if (turn) {  
      if (score[endfeld] == 1 && endfeld < 6) {
        score[6] += 1 + score[12 - endfeld];
        score[endfeld] = 0;
        score[12 - endfeld] = 0;
      }        
    } else {
      if (score[endfeld] == 1 && endfeld > 6 && endfeld < 13) {
        score[13] += 1 + score[12 - endfeld];
        score[endfeld] = 0;
        score[12 - endfeld] = 0;
      }
    }     
  }
  
  public boolean checkWin() {     
    int sum1 = 0;
    int sum2 = 0;
    for (int i = 0; i < 6; i++) {
      sum1 += score[i];
    }
    for (int i = 7; i < 13; i++) {
      sum2 += score[i];
    }
    if (sum1 == 0 || sum2 == 0) {
      if (score[6] > score[13]) {
        player1Win = true;
        return true;
      } else if (score[6] < score[13]){
        return true;
      } // end of if 
    }
    return false;
  }
  
  public void action(int index) {
    int endfeld = (index + score[index]) % 14;
    
    if (turn && index < 6) {
      if (!checkWin()) {
        for (int i = 0; i < score[index]; i++) {
          score[(index+1 + i)%score.length]++;
        }
        checkEmpty(index);
        if (endfeld == 6) {
          score[index] = 0;
          update();
        } else {
          score[index] = 0;
          turn = !turn;
          update();  
          } // end of if-else// end of if
        
      } 
    } else if(!turn && index < 13 && index > 6) {
      if (!checkWin()) {
        for (int i = 0; i < score[index]; i++) {
          score[(index+1 + i)%score.length]++;
        }
        checkEmpty(index);
        if (endfeld == 13) {
          score[index] = 0;
          update();
        } else {
          score[index] = 0;
          turn = !turn;
          update();  
          } // end of if-else// end of if
      } // end of if  
    } // end of if-else
    
  }
  
  public void update () {
    for (int i = 0; i < score.length; i++) {
      btn[i].setText(String.valueOf(score[i]));
    }
    if (turn) {
      p1Rect.setFill(Color.web("#38f251", 0.5));
      p1Mulde.setFill(Color.web("#38f251", 0.5));
      p2Rect.setFill(Color.web("#636363", 0.5));
      p2Mulde.setFill(Color.web("#636363", 0.5));
    } else {
      p2Rect.setFill(Color.web("#38f251", 0.5));
      p2Mulde.setFill(Color.web("#38f251", 0.5));
      p1Rect.setFill(Color.web("#636363", 0.5));
      p1Mulde.setFill(Color.web("#636363", 0.5));
      } // end of if-else
    if (checkWin()) {
      if (player1Win) {
        win.setText("Player 1 won!");
        scoreP1 += 1;
      } else {
        win.setText("Player 2 won!");
        scoreP2 += 1;
      } // end of if-else 
    }
    score1Text = "Player 1:\n   " + scoreP1;
    score1.setText(score1Text);
    score2Text = "Player 2:\n   " + scoreP2;
    score2.setText(score2Text);
  }

  // Ende Methoden
} // end of class Kalaha
