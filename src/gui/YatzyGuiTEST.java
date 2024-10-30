package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.RaffleCup;
import models.YatzyResultCalculator;

import java.util.ArrayList;

public class YatzyGuiTEST extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Yatzy");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private final HBox hbox = new HBox();
    private final VBox vbox = new VBox();
    private final RaffleCup raf = new RaffleCup();

    private final ArrayList<CheckBox> checkBoxArrayList = new ArrayList<>();


    public void initContent(GridPane pane){
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(25);
        pane.setPrefHeight(400);
        pane.setPrefWidth(600);





        for (int i = 0; i < 5; i++) {
            VBox diceBox = new VBox();
            CheckBox checkBox = new CheckBox();

            int die = raf.getDice()[i].getDie();
            diceBox.getChildren().add(new Label(String.valueOf(die)));
            pane.add(checkBox, i+1, 0 );

            checkBoxArrayList.add(checkBox);
            hbox.getChildren().add(diceBox);
        }

        pane.add(hbox,0,0);

        for (int i = 0; i < 15; i++) {
            vbox.getChildren().add(new Label("0"));
        }

        pane.add(vbox,0, 5);


        Button btn = new Button("updateTable");
       pane.add(btn,1,1);
        btn.setOnAction(event -> updateTable());

        Button btnRollAgain = new Button("rollAgain");
        pane.add(btnRollAgain,2,1);
        btnRollAgain.setOnAction(event -> rollAgain());
    }



    //UpdateTable er opdateret når man trykker Kast terningerne.
    public void updateTable(){
        YatzyResultCalculator res = new YatzyResultCalculator(raf.getDice());

        //UpperSection
        for (int i = 1; i < 7; i++) {
            int result = res.upperSectionScore(i);
            vbox.getChildren().set(i-1, new Label(String.valueOf(result)));
        }

        int result = res.onePairScore();
        vbox.getChildren().set(6, new Label(String.valueOf(result)));

        result = res.twoPairScore();
        vbox.getChildren().set(7, new Label(String.valueOf(result)));

        result = res.threeOfAKindScore();
        vbox.getChildren().set(8, new Label(String.valueOf(result)));
    }

    public void updateThrow(){
        for (int i = 0; i < 5; i++) {
            String eyes = String.valueOf(raf.getDice()[i].getDie());
            hbox.getChildren().set(i, new Label(eyes));
        }
    }

    public void rollAgain(){
        for (int i = 0; i < raf.getDice().length; i++) {
            raf.getDice()[i].setRollAgain(!checkBoxArrayList.get(i).isSelected());
        }

        raf.throwDice();
        updateTable();
        updateThrow();
    }


}
