package base.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import base.model.Artista;
import base.model.DossierArtista;
import base.model.LogOperacion;
import base.repository.ArtistaRepository;
import base.repository.LogRepository;

@Service
public class ArtistaService {

    private final ArtistaRepository artistaRepository;
    private final LogRepository logRepository;
    private final DossierService dossierService;
   
	public ArtistaService(ArtistaRepository artistaRepository, LogRepository logRepository,
			DossierService dossierService ) {
		super();
		this.artistaRepository = artistaRepository;
		this.logRepository = logRepository;
		this.dossierService = dossierService;	
	}

    public List<Artista> findAll() {
        return artistaRepository.findAll();
    }
    	
    public Artista save(Artista artista) {
    	Artista guardado = artistaRepository.save(artista);
    	
    	LogOperacion log= new LogOperacion(
    	java.time.LocalDateTime.now(),"admin","NUEVO","Se ha registrado el artista"+guardado.getNombre());
    	logRepository.registrarAccion(log);
    		
    	DossierArtista nuevoDossier = new DossierArtista();
    	nuevoDossier.setIdArtista(guardado.getId());
    	nuevoDossier.setNombre(guardado.getNombre());
    	nuevoDossier.setEmail(guardado.getEmail());
    	nuevoDossier.setNacionalidad(guardado.getNacionalidad());
    	nuevoDossier.setApodo(guardado.getApodo());
    	
    	nuevoDossier.setEspecialidades(new ArrayList<>());
    	nuevoDossier.setHabilidades(new ArrayList<>());
    	nuevoDossier.setTrayectoria(new ArrayList<>());
    	nuevoDossier.setObservaciones(new ArrayList<>());
    	nuevoDossier.setEvaluaciones(new ArrayList<>());
    	
    	
    	dossierService.save(nuevoDossier);
    	
        return guardado;
    }
    
    public Artista update (Artista artista) {
    	Artista actualizado = artistaRepository.save(artista);
    	
    	LogOperacion log= new LogOperacion(java.time.LocalDateTime.now(), "Admin", "Modificar", "Se ha registrado bien"+actualizado.getNombre());
    	logRepository.registrarAccion(log);
    	DossierArtista dossier = dossierService.findByIdArtista(actualizado.getId());
    	
    	if ( dossier != null) {
    		
    		dossier.setNombre(actualizado.getNombre());
    		dossier.setEmail(actualizado.getEmail());
    		dossier.setNacionalidad(actualizado.getNacionalidad());
    		dossier.setApodo(actualizado.getApodo());
    		
    		dossierService.save(dossier);
    	}
    	return actualizado;
    	
    	
    }

    public void deleteById(Long id) {
        artistaRepository.deleteById(id);
    }
}