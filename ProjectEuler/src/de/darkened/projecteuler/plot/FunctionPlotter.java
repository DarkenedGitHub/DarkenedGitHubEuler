package de.darkened.projecteuler.plot;

import java.util.List;
import java.util.function.DoubleUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.stage.Stage;

public class FunctionPlotter extends Application {
	
	private static double minVal;
	private static double maxVal;
	private static double step;
	private static DoubleUnaryOperator[] functions;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		LineChart<Number, Number> lineChart = new LineChart<>(new NumberAxis(), new NumberAxis());
		Scene scene = new Scene(lineChart, 1000, 800);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		for (DoubleUnaryOperator function : functions) {
			DoubleStream xValueStream = DoubleStream.iterate(minVal, xValue -> xValue += step).limit((long) ((maxVal - minVal) / step + 1));
			List<Data<Number, Number>> series = xValueStream.mapToObj(x -> new Data<Number, Number>(x, function.applyAsDouble(x))).collect(Collectors.toList());
			lineChart.getData().add(new Series<>(FXCollections.observableList(series)));
		}
	}

	public static void plotFunction(double _minVal, double _maxVal, double _step, DoubleUnaryOperator... _functions) {
		minVal = _minVal;
		maxVal = _maxVal;
		step = _step;
		functions = _functions;
		launch();
	}

}
