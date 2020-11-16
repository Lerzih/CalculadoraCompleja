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

public class CalculadoraCompleja extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		// Variables
		
		Complejo complejo1 = new Complejo();
		Complejo complejo2 = new Complejo();
		Complejo resultImaginario = new Complejo();
		
		IntegerProperty real1 = new SimpleIntegerProperty(0);
		IntegerProperty imaginario1 = new SimpleIntegerProperty(0);
		IntegerProperty real2 = new SimpleIntegerProperty(0);
		IntegerProperty imaginario2 = new SimpleIntegerProperty(0);
		
		// Interfaz
		
		HBox caja = new HBox(10);
		caja.setAlignment(Pos.CENTER);
		
		// Primer Complejo
		
		HBox numero1 = new HBox(5);
		TextField real1_textF = new TextField();
		real1_textF.maxWidthProperty().set(50);
		TextField real2_textF = new TextField();
		real2_textF.maxWidthProperty().set(50);
		Text signo1_text = new Text("+");
		Text imaginario1 = new Text("i");
		numero1.getChildren().addAll(real1_textF, signo1_text, real2_textF, imaginario1);
		
		// Segundo Complejo
		
		HBox numero2 = new HBox(5);
		TextField real3_textF = new TextField();
		real3_textF.maxWidthProperty().set(50);
		TextField real4_textF = new TextField();
		real4_textF.maxWidthProperty().set(50);
		Label signo2_text = new Label("+");
		Text imaginario2 = new Text("i");
		numero2.getChildren().addAll(real3_textF, signo2_text, real4_textF, imaginario2);
		
		// Resultado Complejo
		
		HBox resultado = new HBox(5);
		TextField resultado1_textF = new TextField();
		resultado1_textF.setDisable(true);
		resultado1_textF.maxWidthProperty().set(50);
		TextField resultado2_textF = new TextField();
		resultado2_textF.setDisable(true);
		resultado2_textF.maxWidthProperty().set(50);
		Label signo3_text = new Label("+");
		Text imaginario3 = new Text("i");
		resultado.getChildren().addAll(resultado1_textF, signo3_text, resultado2_textF, imaginario3);
		
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
		
		
		
		// Suma
		// Para la suma, primero los valores del label tienen que cambiar de signo
		
		
		
		Scene escena = new Scene(caja, 320, 200);
		
		primaryStage.setScene(escena);
		primaryStage.setTitle("CalculadoraCompleja");
		primaryStage.show();
		
	}
	public static void main(String[] args) {
		launch(args);
	}

}
