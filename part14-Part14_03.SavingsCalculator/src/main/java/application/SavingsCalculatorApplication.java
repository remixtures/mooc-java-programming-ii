package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SavingsCalculatorApplication extends Application {

    public static void main(String[] args) {
        launch(SavingsCalculatorApplication.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        BorderPane layout = new BorderPane();
        VBox sliderBox = new VBox();
        BorderPane topSubLayout = new BorderPane();
        BorderPane bottomSubLayout = new BorderPane();

        Label monthlySavings = new Label("Monthly savings");
        Label annualInterestRates = new Label("Yearly interest rate");

        Slider monthsSlider = new Slider(25, 250, 25);
        Slider annualRateSlider = new Slider(0, 10, 3);

        Label currentMonthValue = new Label(monthsSlider.getValue() + "");
        Label currentAnnualRate = new Label(annualRateSlider.getValue() + "");
        
        monthsSlider.setMajorTickUnit(25);
        monthsSlider.setSnapToTicks(true);
        
        annualRateSlider.setMajorTickUnit(1);
        annualRateSlider.setSnapToTicks(true);
        
        monthsSlider.setShowTickLabels(true);
        monthsSlider.setShowTickMarks(true);
        annualRateSlider.setShowTickLabels(true);
        annualRateSlider.setShowTickMarks(true);

        SavingsAccount account = new SavingsAccount(monthsSlider.getValue(), annualRateSlider.getValue());

        topSubLayout.setLeft(monthlySavings);
        topSubLayout.setCenter(monthsSlider);
        topSubLayout.setRight(currentMonthValue);
        bottomSubLayout.setLeft(annualInterestRates);
        bottomSubLayout.setCenter(annualRateSlider);
        bottomSubLayout.setRight(currentAnnualRate);

        topSubLayout.setPadding(new Insets(20, 10, 10, 20));
        bottomSubLayout.setPadding(new Insets(20, 10, 10, 20));

        sliderBox.getChildren().addAll(topSubLayout, bottomSubLayout);

        layout.setTop(sliderBox);
        layout.setCenter(createLineChart(account));

        annualRateSlider.valueProperty().addListener(event -> {
            currentAnnualRate.setText((double) Math.round(annualRateSlider.getValue() * 100) / 100 + "");
            account.setMonthlyRecord(monthsSlider.getValue());
            account.setInterestRate(annualRateSlider.getValue());
            layout.setCenter(createLineChart(account));
        });

        monthsSlider.valueProperty().addListener(event -> { 
            currentMonthValue.setText((double) Math.round(monthsSlider.getValue()) + "");
            account.setMonthlyRecord(monthsSlider.getValue());
            account.setInterestRate(annualRateSlider.getValue());
            layout.setCenter(createLineChart(account));
        });

        window.setScene(new Scene(layout));
        window.show();       
    }
    
    private LineChart<Number, Number> createLineChart(SavingsAccount account) {
        NumberAxis yAxis = new NumberAxis();
        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        LineChart<Number, Number> savingsLineChart = new LineChart(xAxis, yAxis);
        savingsLineChart.setTitle("Savings Calculator");
        XYChart.Series annualSavings = new XYChart.Series();
        XYChart.Series annualSavingsWithoutInterest = new XYChart.Series();
        annualSavings.setName("Savings with Interest");
        annualSavingsWithoutInterest.setName("Savings without Interest");

        for (int i = 0; i <= 30; i++) {
            annualSavingsWithoutInterest.getData().add(new XYChart.Data(i, account.getBalanceWithoutInterest()));
            annualSavings.getData().add(new XYChart.Data(i, account.getBalance()));
            account.increaseYear();
        }
        savingsLineChart.getData().add(annualSavingsWithoutInterest);
        savingsLineChart.getData().add(annualSavings);
        return savingsLineChart;
    }
}