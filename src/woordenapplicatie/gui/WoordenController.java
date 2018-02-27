package woordenapplicatie.gui;

import java.net.URL;
import java.util.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import woordenapplicatie.logic.ILogic;
import woordenapplicatie.logic.WoordenManager;

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

    private ILogic logic;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        taInput.setText(DEFAULT_TEXT);
        logic = new WoordenManager();
    }

    @FXML
    private void aantalAction(ActionEvent event) {
        int amountTotal = logic.getAmountAllWords(taInput.getText());
        int amountDistinct = logic.getAmountDistinctWords(taInput.getText());
        taOutput.setText("Totaal aantal woorden: " + amountTotal + "\n" + "Verschillende woorden: " + amountDistinct);
    }

    @FXML
    private void sorteerAction(ActionEvent event) {

        Iterator<String> iterator = logic.getSorteerAction(taInput.getText());
        StringBuilder builder = new StringBuilder();
        while (iterator.hasNext()){
            builder.append(iterator.next());
            if(iterator.hasNext()){
                builder.append("\n");
            }
        }
        taOutput.setText(builder.toString());
    }

    @FXML
    private void frequentieAction(ActionEvent event) {
        //O(1) haalt een hashmap op
        Map<String, Integer> frequency = logic.getFrequency(taInput.getText());
        taOutput.setText(frequency.toString());
    }

    @FXML
    private void concordatieAction(ActionEvent event) {
        HashMap<String, Set<Integer>> resultMap = (HashMap<String, Set<Integer>>) logic.getConcordatie(taInput.getText());
        Set<String> allWords = resultMap.keySet();
        StringBuilder outputString = new StringBuilder();
        for (String word : allWords) {
            outputString.append(word).append(" [");

            Set<Integer> lineOccurrences = resultMap.get(word);

            for (Integer lineNumber : lineOccurrences) {
                outputString.append(lineNumber).append(",");
            }
            outputString.deleteCharAt(outputString.length() - 1);
            outputString.append("]\n");
        }
        taOutput.setText(outputString.toString());
    }
}