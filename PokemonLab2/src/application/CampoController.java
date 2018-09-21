package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class CampoController {

    
    private Main main;
    @FXML
    private  ImageView visor;
    @FXML
    private ImageView bandera;

    public CampoController() {
   
    }
	public void initialize() {
		iniciar();
	}
	
    
    public void iniciar() {
    	
    	
        Image image = new Image(getClass().getResourceAsStream("/pokebola.gif"));
       
       
        
       visor.setImage(image);
       visor.translateXProperty().setValue(200);
       visor.translateYProperty().setValue(600);
       
       Image image2 = new Image(getClass().getResourceAsStream("/bandera.gif"));
       bandera.setImage(image2);
       bandera.translateXProperty().setValue(1600);
       bandera.translateYProperty().setValue(500);;
     
       
     

        
    }
    
 

    @FXML
    void liberarPokemon(MouseEvent event) throws InterruptedException {
    	main = new Main();
    	
    	Image im = new Image(getClass().getResourceAsStream("/"+main.pokemonLiberado(CampoController.this, this.visor)+".gif"));
    	
    	this.visor.setImage(im);
    	visor.setDisable(true);
 
    	

    }
    
    public void cambiarDesplazamientoPokemon(ImageView a) throws InterruptedException {
    	main = new Main();
     
    	this.visor = a;
     	
    	for(int i = 0;i<100&& main.LlegoAlaMeta()==false;i +=5) {
    		Thread.sleep(150);
    	
    		visor.translateXProperty().setValue(main.cambioDesplazamiento());
    	
    }
    	main.aviso();
 
    }
    public ImageView darImagen() {
    	return this.visor;
    }
    
 
    

}