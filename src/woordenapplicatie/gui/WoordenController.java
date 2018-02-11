package woordenapplicatie.gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import woordenapplicatie.WoordenManager;

/**
 * FXML Controller class
 *
 * @author frankcoenen
 */
public class WoordenController implements Initializable {

    private static final String DEFAULT_TEXT = "Een, twee, drie, vier\n" +
            "Hoedje van, hoedje van\n" +
            "Een, twee, drie, vier\n" +
            "Hoedje van papier\n" +
            "\n" +
            "Heb je dan geen hoedje meer\n" +
            "Maak er één van bordpapier\n" +
            "Eén, twee, drie, vier\n" +
            "Hoedje van papier\n" +
            "\n" +
            "Een, twee, drie, vier\n" +
            "Hoedje van, hoedje van\n" +
            "Een, twee, drie, vier\n" +
            "Hoedje van papier\n" +
            "\n" +
            "En als het hoedje dan niet past\n" +
            "Zetten we 't in de glazenkas\n" +
            "Een, twee, drie, vier\n" +
            "Hoedje van papier";

    private WoordenManager manager;

    @FXML
    private Button btAantal;
    @FXML
    private TextArea taInput;
    @FXML
    private Button btSorteer;
    @FXML
    private Button btFrequentie;
    @FXML
    private Button btConcordantie;
    @FXML
    private TextArea taOutput;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        taInput.setText(DEFAULT_TEXT);
        manager = new WoordenManager();
    }

    @FXML
    private void aantalAction(ActionEvent event) {
        String[] gesplitteString = manager.splitString(taInput.getText());
        int amountTotal = manager.getAmountAllWords(gesplitteString);

        int amountDistinct = manager.getAmountDistinctWords(gesplitteString);

        taOutput.setText("Totaal aantal woorden: " + amountTotal + "\n" + "Verschillende woorden: " + amountDistinct);
    }

    @FXML
    private void sorteerAction(ActionEvent event) {
        String[] gesplitteString = manager.splitString(taInput.getText());
        TreeSet<String> woorden = new TreeSet<>();
        Collections.addAll(woorden, gesplitteString);
        String alleWoorden = "";
        for(String s : woorden.descendingSet()){
            alleWoorden += s + "\n";
        }
        taOutput.setText(alleWoorden);
    }

    @FXML
    private void frequentieAction(ActionEvent event) {
        String[] gesplitteString = manager.splitString(taInput.getText());
        Map<String, Integer> frequency = manager.getFrequency(gesplitteString);
        taOutput.setText(frequency.toString());
    }

    @FXML
    private void concordatieAction(ActionEvent event) {
        Map<String, Set<Integer>> concordatie = manager.getConcordatie(taInput.getText());
        taOutput.setText(concordatie.toString());
    }

}