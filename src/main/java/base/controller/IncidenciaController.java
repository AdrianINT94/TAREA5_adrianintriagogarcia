package base.controller;

import org.springframework.stereotype.Controller;

import base.config.StageManager;
import base.incidencias.Incidencia;
import base.incidencias.ResolucionIncidencia;
import base.repository.IncidenciaRepository;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


@Controller
public class IncidenciaController {
	
	@FXML private ComboBox<String> cbTipo;
	@FXML private TextArea txtDescripcion;
	@FXML private TextField  txtIdEspectaculo, txtIdNumero;
	@FXML private TableView<Incidencia> tablaIncidencias;
	@FXML private TableColumn<Incidencia, Long> colId;
	@FXML private TableColumn<Incidencia,String> colTipo,colDesc;
	@FXML private TableColumn<Incidencia,Boolean> colResuelta;
	@FXML private Button btnResolver;
	
	private final IncidenciaRepository repo;
	private final StageManager stageManager;
	
	
	public IncidenciaController(IncidenciaRepository repo, StageManager stageManager) {
		super();
		this.repo = repo;
		this.stageManager = stageManager;
	}

	@FXML
	public void initialize() {
		cbTipo.setItems(FXCollections.observableArrayList("TECNICA","ARTISTICA","ORGANIZATIVA"));
		colId.setCellValueFactory(new PropertyValueFactory<>("id"));
		colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
		colDesc.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
		colResuelta.setCellValueFactory(new PropertyValueFactory<>("resuelta"));
		actualizarTabla();
	
	}
	
	@FXML
	void guardarIncidencia() {
		Incidencia nueva = new Incidencia();
		nueva.setTipo(cbTipo.getValue());
		nueva.setDescripcion(txtDescripcion.getText());
		
		try {
			
			if(!txtIdEspectaculo.getText().isEmpty()) nueva.setIdEspectaculo(Long.parseLong(txtIdEspectaculo.getText()));
			if(!txtIdNumero.getText().isEmpty())nueva.setIdNumero(Long.parseLong(txtIdNumero.getText()));
			
			
			repo.guardar(nueva);
		}catch(Exception e) {
			System.out.println("Error");
			
		}
		}
		@FXML 
		void actualizarTabla() {
			tablaIncidencias.setItems(FXCollections.observableArrayList(repo.obtenerTodas()));
			
		}
		@FXML 
		void limpiarCampos() {
			txtDescripcion.clear();
			
			txtIdEspectaculo.clear();
			txtIdNumero.clear();
			cbTipo.getSelectionModel().clearSelection();
		
	}
		@FXML
		void onResolverClick(ActionEvent event) {
		    
		    Incidencia seleccionada = tablaIncidencias.getSelectionModel().getSelectedItem();
		    
		    if (seleccionada != null) {
		        ResolucionIncidencia resolucion = new ResolucionIncidencia();
		        resolucion.setAccionesRealizadas("Incidencia resuelta.");
		        resolucion.setIdPersonaResuelve(1L);

		        repo.resolver(seleccionada, resolucion);
		        actualizarTabla();
		    } else {
		        System.out.println("Selecciona una fila primero");

		    }
		}
		    @FXML 
		    private void volverMenu() {
		    	stageManager.switchScene("menu.fxml","Panel de control");
		    
      }
}