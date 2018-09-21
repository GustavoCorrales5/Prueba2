package application;

import java.security.SecureRandom;

import javax.swing.JOptionPane;

import com.sun.corba.se.spi.orbutil.fsm.Input;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import jdk.jfr.events.SocketWriteEvent;

public class CampoController2 {

    
    private Main main;
    @FXML
    private  ImageView visor;
    @FXML
    private ImageView bandera;

    public CampoController2() {
   
    }
	public void initialize() {
		iniciar();
	}
	
    
    public void iniciar() {
    	
    	main = new Main();
		SecureRandom random = new SecureRandom();
		
        Image image = new Image(getClass().getResourceAsStream("/"+main.numeroPOkemonSeleccionado()+".gif"));
        visor.setImage(image);
        visor.translateXProperty().setValue(200);
        visor.translateYProperty().setValue(600);
        main.pokemonAtrapador(CampoController2.this, this.visor);
        Image image2 = new Image(getClass().getResourceAsStream("/bandera.gif"));
        bandera.setImage(image2);
        bandera.translateXProperty().setValue(1600);
        bandera.translateYProperty().setValue(500);;
        
    }
    


    @FXML
    void atraparPokemon(MouseEvent event) throws InterruptedException {
    	if(visor.translateXProperty().get() >= (1400)) {
    		visor.setDisable(true);
    	}
    	else {
    	main = new Main();
    	main.cambiarPokemonAtrapado(true);
    	Image im = new Image(getClass().getResourceAsStream("/pokebola.gif"));
    	this.visor.setImage(im);
    	visor.setDisable(true);
   

    	}
    

    }
    

    public void cambiarDesplazamientoPokemon2(ImageView a) throws InterruptedException {
    	main = new Main();
     
    	this.visor = a;
     	
    	for(int i = 0;i<100&& main.LlegoAlaMeta()==false;i +=5) {
    		Thread.sleep(150);
    	
    		visor.translateXProperty().setValue(main.cambioDesplazamiento());
    
    	
    }
    	
 
    }
    public ImageView darImagen() {
    	return this.visor;
    }
    
 
    

}