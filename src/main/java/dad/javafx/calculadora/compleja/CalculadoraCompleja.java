package dad.javafx.calculadora.compleja;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class CalculadoraCompleja extends Application{
	
	// Variables
	
	Complejo complejo1 = new Complejo();
	Complejo complejo2 = new Complejo();
	Complejo resultImaginario = new Complejo();

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		// Interfaz
		
		HBox caja = new HBox(10);
		caja.setAlignment(Pos.CENTER);
		
		// Primer Complejo
		
		HBox numero1 = new HBox(5);
		TextField real1_textF = new TextField();
		real1_textF.maxWidthProperty().set(50);
		TextField imaginario1_textF = new TextField();
		imaginario1_textF.maxWidthProperty().set(50);
		Text signo1_text = new Text("+");
		Text im1 = new Text("i");
		numero1.getChildren().addAll(real1_textF, signo1_text, imaginario1_textF, im1);
		
		// Segundo Complejo
		
		HBox numero2 = new HBox(5);
		TextField real2_textF = new TextField();
		real2_textF.maxWidthProperty().set(50);
		TextField imaginario2_textF = new TextField();
		imaginario2_textF.maxWidthProperty().set(50);
		Label signo2_text = new Label("+");
		Text im2 = new Text("i");
		numero2.getChildren().addAll(real2_textF, signo2_text, imaginario2_textF, im2);
		
		// Resultado Complejo
		
		HBox resultado = new HBox(5);
		TextField resultado1_textF = new TextField();
		resultado1_textF.setDisable(true);
		resultado1_textF.maxWidthProperty().set(50);
		TextField resultado2_textF = new TextField();
		resultado2_textF.setDisable(true);
		resultado2_textF.maxWidthProperty().set(50);
		Label signo3_text = new Label("+");
		Text im3 = new Text("i");
		resultado.getChildren().addAll(resultado1_textF, signo3_text, resultado2_textF, im3);
		
		// VBox para el combo y los hbox
		
		VBox combo = new VBox();
		
		ComboBox<String> signo = new ComboBox<String>();
		signo.getItems().addAll("+", "-", "x", "/");
		signo.setValue("+");
		combo.getChildren().add(signo);
		combo.setAlignment(Pos.CENTER);
		
		VBox valores = new VBox();
		Separator separador = new Separator();
		valores.getChildren().addAll(numero1, numero2, separador, resultado);
		valores.setAlignment(Pos.CENTER);
		valores.setSpacing(7);
		caja.getChildren().addAll(combo, valores);
		
		// Bindeos
		
		Bindings.bindBidirectional(real1_textF.textProperty(), complejo1.realProperty(), new NumberStringConverter());
		Bindings.bindBidirectional(imaginario1_textF.textProperty(), complejo1.imaginarioProperty(), new NumberStringConverter());
		
		Bindings.bindBidirectional(real2_textF.textProperty(), complejo2.realProperty(), new NumberStringConverter());
		Bindings.bindBidirectional(imaginario2_textF.textProperty(), complejo2.imaginarioProperty(), new NumberStringConverter());
		
		
		
		// Suma
		// Para la suma, primero los valores del label tienen que cambiar de signo
		
		signo.getSelectionModel().selectedItemProperty().addListener((o, ov, nv) -> {
			if (signo.getSelectionModel().getSelectedItem().equals("+")) {
				resultImaginario = complejo1.add(complejo2);
				resultado1_textF.textProperty().bind(resultImaginario.realProperty().asString("%.2f"));
				resultado2_textF.textProperty().bind(resultImaginario.imaginarioProperty().asString("%.2f"));
			}
			if (signo.getSelectionModel().getSelectedItem().equals("-")) {
				resultImaginario = complejo1.restar(complejo2);
				resultado1_textF.textProperty().bind(resultImaginario.realProperty().asString("%.2f"));
				resultado2_textF.textProperty().bind(resultImaginario.imaginarioProperty().asString("%.2f"));
			}
			if (signo.getSelectionModel().getSelectedItem().equals("x")) {
				resultImaginario = complejo1.multiply(complejo2);
				resultado1_textF.textProperty().bind(resultImaginario.realProperty().asString("%.2f"));
				resultado2_textF.textProperty().bind(resultImaginario.imaginarioProperty().asString("%.2f"));
			}
			if (signo.getSelectionModel().getSelectedItem().equals("/")) {
				resultImaginario = complejo1.divide(complejo2);
				resultado1_textF.textProperty().bind(resultImaginario.realProperty().asString("%.2f"));
				resultado2_textF.textProperty().bind(resultImaginario.imaginarioProperty().asString("%.2f"));
			}
		});
		
		
		Scene escena = new Scene(caja, 320, 200);
		
		primaryStage.setScene(escena);
		primaryStage.setTitle("CalculadoraCompleja");
		primaryStage.show();
		
	}
	public static void main(String[] args) {
		launch(args);
	}

}
