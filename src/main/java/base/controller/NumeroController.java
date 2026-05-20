package base.controller;

import org.springframework.stereotype.Component;
import base.config.StageManager;
import base.model.*;
import base.service.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.List;
import javafx.collections.FXCollections;

@Component
public class NumeroController {

    private final NumeroService numeroService;
    private final ArtistaService artistaService;
    private final EspectaculoService espectaculoService;
    private final StageManager stageManager;

    public NumeroController(NumeroService numeros, ArtistaService artistas, EspectaculoService espectaculos, StageManager stageManager) {
        this.numeroService = numeros;
        this.artistaService = artistas;
        this.espectaculoService = espectaculos;
        this.stageManager = stageManager;
    }

    @FXML private TextField txtNombre, txtDuracion ;
    @FXML private ComboBox<Espectaculo> cbEspectaculo;
    @FXML private ListView<Artista> listaArtistas;
    @FXML private ListView<Numero> listaNumeros;

    @FXML
    public void initialize() {
        cbEspectaculo.getItems().setAll(espectaculoService.findAll());
        listaArtistas.getItems().setAll(artistaService.findAll());
        cargar();
    }

    @FXML
    private void guardar() {
        String nombre = txtNombre.getText();
        
        Espectaculo espectaculo = cbEspectaculo.getValue();
        Artista artista = listaArtistas.getSelectionModel().getSelectedItem();
        Double duracion;

        try {
            duracion = Double.parseDouble(txtDuracion.getText());
        } catch (Exception e) {
            return;
        }
        if (nombre.isBlank()  || espectaculo == null || artista == null) return;
        
        Numero numero = new Numero();
        numero.setNombre(nombre);
        numero.setDuracion(duracion);
        numero.setEspectaculo(espectaculo);
        numero.setArtistas(new java.util.ArrayList<>(List.of(artista))); 

        numeroService.save(numero);
        cargar();
    }
    
    @FXML 
    private void borrar() {
    	Numero seleccionado = listaNumeros.getSelectionModel().getSelectedItem();
    	if(seleccionado ==null)return;
    	
    	numeroService.deleteById(seleccionado.getId());	
    	cargar();
    	}
    
    
    @FXML
    private void volverMenu() {
    	stageManager.switchScene("menu.fxml", "Panel de Control");
    }

    private void cargar() {
    	List<Numero> todoslosNumeros = numeroService.findAll();
        listaNumeros.setItems(FXCollections.observableArrayList(todoslosNumeros));
    }
}
