package dad.javafx.calculadora.compleja;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CalculadoraCompleja extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		// Interfaz
		
		HBox caja = new HBox();
		
		HBox numero1 = new HBox();
		TextField real1_textF = new TextField();
		TextField real2_textF = new TextField();
		Text signo1_text = new Text("+");
		numero1.getChildren().addAll(real1_textF, signo1_text, real2_textF);
		HBox numero2 = new HBox();
		TextField real3_textF = new TextField();
		TextField real4_textF = new TextField();
		Text signo2_text = new Text("+");
		numero2.getChildren().addAll(real3_textF, signo2_text, real4_textF);
		
		HBox resultado = new HBox();
		TextField resultado1_textF = new TextField();
		resultado1_textF.setDisable(true);
		TextField resultado2_textF = new TextField();
		resultado1_textF.setDisable(true);
		Text signo3_text = new Text("+");
		resultado.getChildren().addAll(resultado1_textF, signo3_text, resultado2_textF);
		
		VBox combo = new VBox();
		ComboBox<String> signo = new ComboBox<String>();
		signo.getItems().addAll("+", "-", "x", "/");
		combo.getChildren().add(signo);
		combo.setAlignment(Pos.CENTER);
		VBox valores = new VBox();
		valores.getChildren().addAll(numero1, numero2, resultado);
		valores.setAlignment(Pos.CENTER);
		caja.getChildren().addAll(combo, valores);
		
		// Operaciones
		
		Complejo complejo1 = new Complejo();
		Complejo complejo2 = new Complejo();
		Complejo resultImaginario = new Complejo();
		
		Scene escena = new Scene(caja, 320, 200);
		
		primaryStage.setScene(escena);
		primaryStage.setTitle("CalculadoraCompleja");
		primaryStage.show();
		
	}
	public static void main(String[] args) {
		launch(args);
	}
	

}
