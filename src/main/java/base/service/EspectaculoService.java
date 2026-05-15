package base.service;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

import org.springframework.stereotype.Service;

import base.model.Espectaculo;
import base.repository.EspectaculoRepository;

@Service
public class EspectaculoService {

    private final EspectaculoRepository espectaculoRepository;

    public EspectaculoService(EspectaculoRepository espectaculoRepository) {
        this.espectaculoRepository = espectaculoRepository;
    }

    public List<Espectaculo> findAll() {
        return espectaculoRepository.findAll();
    }

    public Espectaculo save(Espectaculo espectaculo) {
        return espectaculoRepository.save(espectaculo);
    }

    public void deleteById(Long id) {
        espectaculoRepository.deleteById(id);
    }
    public File generarInformeXML(Espectaculo espectaculo) {
    	File carpeta = new File("ficheros");
    	if (!carpeta.exists()) carpeta.mkdir();
    	
    	File archivo = new File(carpeta,  espectaculo.getNombre() +"informe xml");
    	
    	try(PrintWriter fichero = new PrintWriter(archivo)){
    		fichero.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    		fichero.println("<espectaculo");
    		fichero.println("<nombre> " + espectaculo.getNombre() + "</nombre>");
    		fichero.println("<inicio>" + espectaculo.getFechaInicio()+ "</inicio");
    		fichero.println("</espectaculo>");
    	}catch(Exception e) {
    		System.out.println("algo a fallado al crear el XML "+ e.getMessage());
    		
    	}
    	return archivo;
    }
}