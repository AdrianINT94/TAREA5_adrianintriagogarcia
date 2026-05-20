package base.controller;

import org.springframework.stereotype.Component;
import base.config.StageManager;
import base.config.UserSession;
import javafx.fxml.FXML;

@Component
public class MenuController {

    private final StageManager stageManager;
    private final UserSession userSession;

    public MenuController(StageManager stageManager, UserSession userSession) {
        this.stageManager = stageManager;
        this.userSession = userSession;
    }

    @FXML 
    private void irPersonas() { 
        stageManager.switchScene("persona.fxml", "Gestión Personas"); 
    }

    @FXML 
    private void irArtistas() { 
        stageManager.switchScene("artista.fxml", "Gestión Artistas"); 
    }

    @FXML 
    private void irEspectaculos() { 
        stageManager.switchScene("espectaculo.fxml", "Gestión Espectáculos"); 
    }
    @FXML
    private void irNumeros() {
    	stageManager.switchScene("numero.fxml", "Gestion Numeros");
    }
    
    @FXML
    private void irHistorial() {
    	stageManager.switchScene("historial.fxml","Historial");
    }
    
    @FXML
    private void irIncidencias() {
    	stageManager.switchScene("incidencia.fxml", "Gestion indicencias");
    }
    @FXML
    private void irDossier() {
    	stageManager.switchScene("Dossier.fxml", "Gestion Mongdb");
    }

    @FXML
    private void salir() {
        userSession.logout(); 
        stageManager.switchScene("login.fxml", "Login");
    }
}