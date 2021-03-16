package application;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class PartiesApplication extends Application {
    
    private HashMap<String, HashMap<Integer, Double>> finPartiesSupport;

    public PartiesApplication() {
        this.finPartiesSupport = readData("partiesdata.tsv"); 
    }

    public static void main(String[] args) {
        launch(PartiesApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        NumberAxis xAxis = new NumberAxis(1968, 2008, 4);
        NumberAxis yAxis = new NumberAxis(0, 30, 5);
        xAxis.setLabel("Year");
        yAxis.setLabel("Support");

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Relative support of the parties");
        addDataToLineChart(lineChart);

        stage.setScene(new Scene(lineChart, 600, 400));
        stage.setTitle("Finnish parties application");
        stage.show();
    }
    
    public HashMap<String, HashMap<Integer, Double>> readData(String fileName) {
        HashMap<String, HashMap<Integer, Double>> electionsVoting = new HashMap<>();
        ArrayList<Integer> electionYears = new ArrayList<>();
        
        try (Scanner input = new Scanner(Paths.get(fileName))) {
            
            String line = input.nextLine();
            String[] parts = line.split("\t");
            
            for (int i = 1; i < parts.length; i++) {
                electionYears.add(Integer.parseInt(parts[i]));
            }
            
            while (input.hasNext()) {

                String anotherLine = input.nextLine();
                parts = anotherLine.split("\t");
                String politicalParty = parts[0];
                HashMap<Integer, Double> dataValues = new HashMap<>();
                for (int i = 1; i < parts.length; i++) {
                    if (!parts[i].equals("-")) {
                        int votingYear = electionYears.get(i - 1);
                        double percentage = Double.parseDouble(parts[i]);
                        dataValues.put(votingYear, percentage);
                    }
                }
                
                electionsVoting.put(politicalParty, dataValues);
            }
            
        } catch (IOException e) {
            System.err.println("Error: " + e.toString());
        }
        
        return electionsVoting;
    }
    
    private void addDataToLineChart(LineChart<Number, Number> lineChart) {
        finPartiesSupport.keySet().stream().forEach(party -> {
            XYChart.Series data = new XYChart.Series();
            data.setName(party);

            finPartiesSupport.get(party).entrySet().stream().forEach(pair -> {
                data.getData().add(new XYChart.Data(pair.getKey(), pair.getValue()));
            });

            lineChart.getData().add(data);
        });
    }    
}