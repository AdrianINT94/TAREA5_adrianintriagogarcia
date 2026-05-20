package base.service;

import java.util.List;

import org.springframework.stereotype.Service;

import base.model.Artista;
import base.model.DossierArtista;
import base.model.Evaluacion;
import base.model.Observaciones;
import base.model.Trayectoria;
import base.repository.ArtistaRepository;
import base.repository.DossierRepository;

@Service
public class DossierService {

	 private final 	DossierRepository dossierRepository;
	 private final  ArtistaRepository artistaRepository;

	 
	 public DossierService(DossierRepository dossierRepository, ArtistaRepository artistaRepository) {
		super();
		this.dossierRepository = dossierRepository;
		this.artistaRepository = artistaRepository;
	}

	 
	 public List<Artista> obtenerTodosLosArtistas() {
		    return artistaRepository.findAll();
	 }
	
	    public void save(DossierArtista dossier) {
	        dossierRepository.save(dossier);
	    }

	    
	    public DossierArtista findByIdArtista(Long idArtista) {
	        return dossierRepository.findByIdArtista(idArtista);
	    }

	    
	    public void anadirTrayectoria(Long idArtista, Trayectoria nuevaTrayectoria) {
	        DossierArtista dossier = dossierRepository.findByIdArtista(idArtista);
	        if (dossier != null) {
	            dossier.getTrayectoria().add(nuevaTrayectoria);
	            dossierRepository.save(dossier);
	        }
	    }

	    
	    public void anadirObservacion(Long idArtista, Observaciones nuevaObservacion) {
	        DossierArtista dossier = dossierRepository.findByIdArtista(idArtista);
	        if (dossier != null) {
	            dossier.getObservaciones().add(nuevaObservacion);
	            dossierRepository.save(dossier);
	        }
	    }

	    
	    public void anadirEvaluacion(Long idArtista, Evaluacion nuevaEvaluacion) {
	        DossierArtista dossier = dossierRepository.findByIdArtista(idArtista);
	        if (dossier != null) {
	            dossier.getEvaluaciones().add(nuevaEvaluacion);
	            dossierRepository.save(dossier);
	        }
	    }
	}
	 
	 

