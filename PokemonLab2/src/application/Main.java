package application;
	
import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.Campo;
import modelo.HiloCampo;
import modelo.HiloCampo2;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	private static Stage primaryStage;
	private static BorderPane root;
	private static Image im;
	private static Campo camp;
	public int numeroPokemon;
	private Image ima;
	private static int numeroPokemonSeleccionado;
	private HiloCampo hC;
	private long initialTime;
	private HiloCampoController hCC;
	private static CampoController cC;
	private static CampoController2 cC2;
	private HiloCampo2 hC2;
	private HiloCampoController2 hCC2;
	private static BorderPane root2;
	
	
	public Main() {
	
	}
	@Override
	public void start(Stage primaryStage) {
		try {
			this.primaryStage = primaryStage;
			root = (BorderPane)FXMLLoader.load(getClass().getResource("Inicio.fxml"));
			Scene scene = new Scene(root);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			  this.im = new Image(getClass().getResourceAsStream("/todo.jpg"));
		
			 
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void seleccionPokemon() {
		
			// TODO Auto-generated method stub
		camp = new Campo();
		FXMLLoader loader =  new FXMLLoader();
		loader.setLocation(Main.class.getResource("Seleccion.fxml"));
		root= null;
		try {
			root = loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		primaryStage.close();
		Stage clientVipDiaStage = new Stage();
		clientVipDiaStage.setTitle("Selecci�n");
		clientVipDiaStage.initModality(Modality.WINDOW_MODAL);
		clientVipDiaStage.initOwner(primaryStage);
		Scene scene = new Scene(root);
		clientVipDiaStage.setScene(scene);		
		clientVipDiaStage.showAndWait();
			
		}
	
	public static void seleccionPokemon2() {
		
		// TODO Auto-generated method stub
	camp = new Campo();
	FXMLLoader loader =  new FXMLLoader();
	loader.setLocation(Main.class.getResource("Seleccion2.fxml"));
	root= null;
	try {
		root = loader.load();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	primaryStage.close();
	Stage clientVipDiaStage = new Stage();
	clientVipDiaStage.setTitle("Selecci�n");
	clientVipDiaStage.initModality(Modality.WINDOW_MODAL);
	clientVipDiaStage.initOwner(primaryStage);
	Scene scene = new Scene(root);
	clientVipDiaStage.setScene(scene);		
	clientVipDiaStage.showAndWait();
		
	}
	
	public static void abrirLanzamiento(int a) {
		
		// TODO Auto-generated method stub
		cC = new CampoController();
		FXMLLoader loader =  new FXMLLoader();
		loader.setLocation(Main.class.getResource("Campo.fxml"));
		root= null;
		try {
			
			root = loader.load();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Stage clientVipDiaStage = new Stage();
		clientVipDiaStage.setTitle("Lanzamiento");
		clientVipDiaStage.initModality(Modality.WINDOW_MODAL);
		clientVipDiaStage.initOwner(primaryStage);
		clientVipDiaStage.close();
		  BackgroundSize s = new BackgroundSize(1154,645,false,false,true,true);
		 BackgroundImage nb = new BackgroundImage(im, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, null,s);
		
		root.setBackground(new Background(nb));
		
		Scene scene = new Scene(root);
		clientVipDiaStage.setScene(scene);		
		clientVipDiaStage.showAndWait();
		
	}
	public static void abrirAtrapar(int a) {
		
		// TODO Auto-generated method stub
		cC2 = new CampoController2();
		FXMLLoader loader2 =  new FXMLLoader();
		loader2.setLocation(Main.class.getResource("SuperCampo1.fxml"));
	
		root= null;
		try {
			System.out.println(loader2);
			root = loader2.load();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Stage clientVipDiaStage = new Stage();
		clientVipDiaStage.setTitle("Atrapar");
		clientVipDiaStage.initModality(Modality.WINDOW_MODAL);
		clientVipDiaStage.initOwner(primaryStage);
		  BackgroundSize s = new BackgroundSize(1154,645,false,false,true,true);
		 BackgroundImage nb = new BackgroundImage(im, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, null,s);
		
		root.setBackground(new Background(nb));
		
		Scene scene = new Scene(root);
		clientVipDiaStage.setScene(scene);		
		clientVipDiaStage.showAndWait();
		
	}
	
	public static void main(String[] args) {
		launch(args);
		System.out.println("hilo");
	}
	
	public  int numeroPokemon() {
		
		int a = camp.darNumeroPokemon();
		
		return a;
	}
	
	public static void pokemonSeleccionado(int a) {
		
		numeroPokemonSeleccionado = a;
		
		abrirLanzamiento(a);
	}
	
	public static void pokemonParaAtrapar(int a) {
		numeroPokemonSeleccionado = a;
		camp.cambiarNumeroPokemonSeleccionado(a);
		abrirAtrapar(a);
	}
	
	public int pokemonLiberado(CampoController a, ImageView visor) {
		this.initialTime = System.currentTimeMillis();
		hC = new HiloCampo(camp,camp.seleccionarPokemon(numeroPokemonSeleccionado),initialTime);
		
		
		hCC = new HiloCampoController(a,visor);
		hC.start();
		hCC.start();
		
		this.cC = a;
		return numeroPokemonSeleccionado;
	}
	
	public double cambioDesplazamiento() {
	return	camp.darDesplazamiento();
	}
	
	public boolean LlegoAlaMeta() {
		return camp.darDiferenciaDistancia();
	}
	
	public void aviso() {
		JOptionPane.showMessageDialog(null, "Su "+ camp.darPokemonSeleccionado().nombre() + " recorri� "+ camp.distanciaRecorrida()+ " metros.", "LLEGO A LA META", 1);
	}
	
	public void pokemonAtrapador(CampoController2 a, ImageView visor) {
		this.initialTime = System.currentTimeMillis();
		hC2 = new HiloCampo2(camp,camp.seleccionarPokemon(numeroPokemonSeleccionado),initialTime);
		
		
		hCC2 = new HiloCampoController2(a,visor);
		hC2.start();
		hCC2.start();
		
		this.cC2 = a;
		
	}
	
	public boolean pokemonAtrapado() {
		return camp.pokemonAtrapado();
	}
	
	public void cambiarPokemonAtrapado(boolean a) {
		camp.cambiarPokemonAtrapado(a);
	}
	
	public int numeroPOkemonSeleccionado() {
		return camp.numeroPokemonSeleccionado();
	}

	

}
