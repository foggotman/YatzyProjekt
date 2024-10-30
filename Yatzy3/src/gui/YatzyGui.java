package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import models.Die;
import models.RaffleCup;
import models.YatzyResultCalculator;

public class YatzyGui extends Application {
    RaffleCup dean = new RaffleCup();
    YatzyResultCalculator deanUdregner = new YatzyResultCalculator(dean.getFemDice());
    Die enkeltTerning = new Die(dean.getDieValue(0));


    private final Label Terning1 = new Label("0");
    private final Label Terning2 = new Label("0");
    private final Label Terning3 = new Label("0");
    private final Label Terning4 = new Label("0");
    private final Label Terning5 = new Label("0");
    CheckBox hold1 = new CheckBox("Hold");
    CheckBox hold2 = new CheckBox("Hold");
    CheckBox hold3 = new CheckBox("Hold");
    CheckBox hold4 = new CheckBox("Hold");
    CheckBox hold5 = new CheckBox("Hold");
    Button kasteKnap = new Button("Kast terninger");
    private final Label antalKastTilbage = new Label("Antal kast tilbage: 3");
    private int antalKast = 3;

    private final Label enere = new Label("1ere:");
    private final Label toere = new Label("2ere:");
    private final Label treere = new Label("3ere:");
    private final Label firer = new Label("4ere:");
    private final Label femmere = new Label("5ere:");
    private final Label seksere = new Label("6ere:");
    private final TextField enereT = new TextField("0");
    private final TextField toereT = new TextField("0");
    private final TextField treereT = new TextField("0");
    private final TextField firereT = new TextField("0");
    private final TextField femmereT = new TextField("0");
    private final TextField seksereT = new TextField("0");

    private final Label sum = new Label("Sum: ");
    private final Label bonus = new Label("Bonus: ");
    private final TextField sumT = new TextField();
    private final TextField bonusT = new TextField();

    private  final Label etPar = new Label("Et par: ");
    private  final Label toPar = new Label("To par: ");
    private  final Label treEns = new Label("Tre ens: ");
    private  final Label fireEns = new Label("Fire ens: ");
    private  final Label lilleStraight = new Label("Lille straight: ");
    private  final Label storStraight = new Label("Store straight: ");
    private  final Label fuldtHus = new Label("Fuldt hus: ");
    private  final Label chance = new Label("Chance: ");
    private  final Label yatzy = new Label("Yatzy: ");
    private final TextField etParT = new TextField("0");
    private final TextField toParT = new TextField("0");
    private final TextField treEnsT = new TextField("0");
    private final TextField fireEnsT = new TextField("0");
    private final TextField lilleStraightT = new TextField("0");
    private final TextField storStraightT = new TextField("0");
    private final TextField fuldtHusT = new TextField("0");
    private final TextField chanceT = new TextField("0");
    private final TextField yatzyT = new TextField("0");




    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Gui Demo 1");
        GridPane pane1 = new GridPane();
        this.initContent(pane1);
        Scene scene1 = new Scene(pane1);
        primaryStage.setScene(scene1);
        primaryStage.show();
    }

    private void initContent(GridPane pane1) {
        pane1.setGridLinesVisible(false);
        pane1.setPadding(new Insets(20));
        pane1.setHgap(10);
        pane1.setVgap(10);

        pane1.add(Terning1, 0, 0);
        pane1.add(hold1, 0, 1);
        pane1.add(Terning2, 1, 0);
        pane1.add(hold2, 1, 1);
        pane1.add(Terning3, 2, 0);
        pane1.add(hold3, 2, 1);
        pane1.add(Terning4, 3, 0);
        pane1.add(hold4, 3, 1);
        pane1.add(Terning5, 4, 0);
        pane1.add(hold5, 4, 1);
        pane1.add(kasteKnap, 4, 2);
        kasteKnap.setOnAction(event -> this.kastTerninger());
        pane1.add(antalKastTilbage, 1, 2);

        pane1.add(enere, 0, 3);
        pane1.add(toere, 0, 4);
        pane1.add(treere, 0, 5);
        pane1.add(firer, 0, 6);
        pane1.add(femmere, 0, 7);
        pane1.add(seksere, 0, 8);
        pane1.add(enereT, 1, 3);
        pane1.add(toereT, 1, 4);
        pane1.add(treereT, 1, 5);
        pane1.add(firereT, 1, 6);
        pane1.add(femmereT, 1, 7);
        pane1.add(seksereT, 1, 8);

        pane1.add(sum, 2, 9);
        pane1.add(sumT, 3, 9);
        pane1.add(bonus, 2, 10);
        pane1.add(bonusT, 3, 10);

        pane1.add(etPar, 0, 11);
        pane1.add(toPar, 0, 12);
        pane1.add(treEns, 0, 13);
        pane1.add(fireEns, 0, 14);
        pane1.add(lilleStraight, 0, 15);
        pane1.add(storStraight, 0, 16);
        pane1.add(fuldtHus, 0, 17);
        pane1.add(chance, 0, 18);
        pane1.add(yatzy, 0, 19);
        pane1.add(etParT, 1, 11);
        pane1.add(toParT, 1, 12);
        pane1.add(treEnsT, 1, 13);
        pane1.add(fireEnsT,1 , 14);
        pane1.add(lilleStraightT, 1, 15);
        pane1.add(storStraightT, 1, 16);
        pane1.add(fuldtHusT, 1, 17);
        pane1.add(chanceT, 1, 18);
        pane1.add(yatzyT, 1, 19);

    }

    private void kastTerninger() {
        if (antalKast > 0) {
            antalKast--;
            antalKastTilbage.setText("Antal kast tilbage: " + antalKast);

            Die[] currentDice = new Die[5];
            for (int i = 0; i < 5; i++) {
                currentDice[i] = new Die(dean.getDieValue(i)); // Assuming getDieValue() returns a Die object
            }
            dean.throwDice();
            deanUdregner.updateSum(dean.getFemDice());
            if (!hold1.isSelected()) {
                Terning1.setText(String.valueOf(dean.getDieValue(0))); // Use the int directly
            } else {
                dean.setDieValue(0, currentDice[0]);
                Terning1.setText(String.valueOf(currentDice[0].getEyes())); // Get from stored Die
            }
            if (!hold2.isSelected()) {
                Terning2.setText(String.valueOf(dean.getDieValue(1)));
            } else {
                dean.setDieValue(1, currentDice[1]);
                Terning2.setText(String.valueOf(currentDice[1].getEyes()));
            }
            if (!hold3.isSelected()) {
                Terning3.setText(String.valueOf(dean.getDieValue(2)));
            } else {
                dean.setDieValue(2, currentDice[2]);
                Terning3.setText(String.valueOf(currentDice[2].getEyes()));
            }
            if (!hold4.isSelected()) {
                Terning4.setText(String.valueOf(dean.getDieValue(3)));
            } else {
                dean.setDieValue(3, currentDice[3]);
                Terning4.setText(String.valueOf(currentDice[3].getEyes()));
            }
            if (!hold5.isSelected()) {
                Terning5.setText(String.valueOf(dean.getDieValue(4)));
            } else {
                dean.setDieValue(4, currentDice[4]);
                Terning5.setText(String.valueOf(currentDice[4].getEyes()));
            }
        } else if(antalKast == 0){
            kasteKnap.setDisable(true);
            etParT.setText("" + deanUdregner.onePairScore());
            toParT.setText("" + deanUdregner.twoPairScore());
            treEnsT.setText("" + deanUdregner.threeOfAKindScore());
            fireEnsT.setText("" + deanUdregner.fourOfAKindScore());
            lilleStraightT.setText("" + deanUdregner.smallStraightScore());
            storStraightT.setText("" + deanUdregner.largeStraightScore());
            fuldtHusT.setText("" + deanUdregner.fullHouseScore());
            chanceT.setText("" + deanUdregner.chanceScore());
            yatzyT.setText("" + deanUdregner.yatzyScore());

        }

    }

}