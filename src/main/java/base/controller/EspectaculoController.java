package base.controller;

import java.time.LocalDate;
import org.springframework.stereotype.Controller;
import base.config.StageManager;
import base.model.*;
import base.service.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;


import java.io.File;

@Controller
public class EspectaculoController {

    private final EspectaculoService espectaculoService;
    private final CoordinadorService coordinadorService;
    private  final ExistDBService existDBService;
    private final StageManager stageManager;
    
    
    public EspectaculoController(EspectaculoService espectaculoService, CoordinadorService coordinadorService,ExistDBService existDBService,StageManager stageManager ) {
        this.espectaculoService = espectaculoService;
        this.coordinadorService = coordinadorService;
        this.existDBService = existDBService;
        this.stageManager = stageManager;
    }

    @FXML private TextField txtNombre;
    @FXML private DatePicker dpInicio, dpFin;
    @FXML private ComboBox<Coordinador> cbCoordinador;
    @FXML private TableView<Espectaculo> tablaEspectaculos; 
    @FXML private TableColumn<Espectaculo, String> colNombre;
    @FXML private TableColumn<Espectaculo, LocalDate> colInicio;

    @FXML
    public void initialize() {
        cbCoordinador.getItems().setAll(coordinadorService.findAll());
        colNombre.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("nombre"));
        colInicio.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("fechaInicio"));
        tablaEspectaculos.getItems().setAll(espectaculoService.findAll());
    }
    @FXML 
    public void generarInforme() {
    	
    	Espectaculo seleccionado = tablaEspectaculos.getSelectionModel().getSelectedItem();
    	if(seleccionado ==null) {
    		System.out.println("Porfavor selecciona un espectaculo de la lista");
    		return;
    	}
    	try {
    		File xml = espectaculoService.generarInformeXML(seleccionado);
    		existDBService.guardarInforme(xml);
    		System.out.println("Exito");
    		
    	}catch(Exception e) {
    		System.out.println("Error al exportar"+e.getMessage());
    	}
    }
    
    

    @FXML
    private void guardar() {
        String nombre = txtNombre.getText();
        LocalDate fechaInicio = dpInicio.getValue(), fechaFin = dpFin.getValue();
        Coordinador coordinador = cbCoordinador.getValue();

        if (nombre == null || nombre.isBlank() || fechaInicio == null || fechaFin == null || coordinador == null) return;

        
        if (nombre.length() > 25 || fechaFin.isBefore(fechaInicio) || fechaFin.isAfter(fechaInicio.plusYears(1))) return;

        
        espectaculoService.save(new Espectaculo(nombre, fechaInicio, fechaFin, coordinador));
        
        tablaEspectaculos.getItems().setAll(espectaculoService.findAll());
    }


	@FXML
	private void volver() {
		stageManager.switchScene("menu.fxml", "Panel de control");
	}
	}
