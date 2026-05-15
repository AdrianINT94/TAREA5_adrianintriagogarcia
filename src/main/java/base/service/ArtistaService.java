package base.service;

import java.util.List;

import org.springframework.stereotype.Service;

import base.model.Artista;
import base.model.LogOperacion;
import base.repository.ArtistaRepository;
import base.repository.LogRepository;

@Service
public class ArtistaService {

    private final ArtistaRepository artistaRepository;
    private final LogRepository logRepository;

    public ArtistaService(ArtistaRepository artistaRepository,LogRepository logRepository) {
        this.artistaRepository = artistaRepository;
        this.logRepository = logRepository;
    }

    public List<Artista> findAll() {
        return artistaRepository.findAll();
    }

    public Artista save(Artista artista) {
    	Artista guardado = artistaRepository.save(artista);
    	
    	LogOperacion log= new LogOperacion(
    	java.time.LocalDateTime.now(),"admin","NUEVO","Se ha registrado el artista"+guardado.getNombre());
    	logRepository.registrarAccion(log);
    			
        return guardado;
    }

    public void deleteById(Long id) {
        artistaRepository.deleteById(id);
    }
}