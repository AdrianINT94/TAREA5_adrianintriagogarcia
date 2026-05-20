package base.service;

import java.util.List;
import org.springframework.stereotype.Service;
import base.model.LogOperacion;
import base.model.Persona;
import base.repository.LogRepository;
import base.repository.PersonaRepository;

@Service
public class PersonaService {

    private final PersonaRepository personaRepository;
    private final LogRepository logRepository;
    
    public PersonaService(PersonaRepository personaRepository,LogRepository logRepository) {
        this.personaRepository = personaRepository;
        this.logRepository =logRepository;
    }

    public List<Persona> findAll() {
        return personaRepository.findAll();
    }

    public Persona save(Persona persona) {
    	Persona guardada = personaRepository.save(persona);
    	
    	LogOperacion log= new LogOperacion(java.time.LocalDateTime.now(),"admin","Nuevo","Se ha registrado la persona" +guardada.getNombre());
    	logRepository.registrarAccion(log);
    	
    	return guardada;  
    }

    public void deleteById(Long id) {
        personaRepository.deleteById(id);
    }
}