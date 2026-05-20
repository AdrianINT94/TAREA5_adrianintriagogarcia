package base.controller;


import org.springframework.stereotype.Controller;

import base.config.StageManager;
import base.model.Observaciones;
import base.model.Trayectoria;
import base.service.DossierService;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


@Controller
public class DossierController {
	
	 private DossierService dossierService;
	 private StageManager stageManager;
	 
    public DossierController(DossierService dossierService, StageManager stageManager) {
		super();
		this.dossierService = dossierService;
		this.stageManager = stageManager;
	}

	@FXML private ComboBox<String> comboArtistas;
    @FXML private TextField txtEspectaculoId;
    @FXML private DatePicker dpFechaInicio;
    @FXML private DatePicker dpFechaFin;
    @FXML private TextField txtRol;
    @FXML private TextField txtCoordinadorId;
    @FXML private TextField txtCalificacion;
    @FXML private TextArea txtObservaciones;
    @FXML public void initialize() { 
          
    }

    @FXML private void guardarTrayectoria() {
        try {
            Long idArtista = 14L; 
            Long idEspectaculo = Long.parseLong(txtEspectaculoId.getText());
            String fechaInicio = dpFechaInicio.getValue().toString();
            String fechaFin = dpFechaFin.getValue().toString();
            String rol = txtRol.getText();

            
            Trayectoria nuevaTrayectoria = new Trayectoria(idEspectaculo, fechaInicio, fechaFin, rol);
            dossierService.anadirTrayectoria(idArtista, nuevaTrayectoria);
            
            System.out.println("Exito a MongoDB ");
            
        } catch (Exception e) {
            System.out.println(" Error al guardar trayectoria: " + e.getMessage());
        }
    }

    @FXML private void guardarObservaciones() {
        try {
            Long idArtista = 14L; 
            Long idCoordinador = Long.parseLong(txtCoordinadorId.getText());
            String evaluacion = txtCalificacion.getText();
            String observacionTexto = txtObservaciones.getText();
            
            Observaciones nuevaObservacion= new Observaciones();
            nuevaObservacion.setIdCoordinador(idCoordinador);
            nuevaObservacion.setEvaluacion(evaluacion);
            nuevaObservacion.setObservacion(observacionTexto);
            
            
            dossierService.anadirObservacion(idArtista,nuevaObservacion);
            System.out.println(" Exito MongoDB ");
            
            
        } catch (Exception e) {
            System.err.println(" Error al guardar observación: " + e.getMessage());
        }
    }
    
    @FXML private void volver() {
    	stageManager.switchScene("menu.fxml", "Panel de control");
    }
}