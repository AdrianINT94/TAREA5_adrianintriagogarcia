package base.service;

import java.util.List;

import base.incidencias.Incidencia;
import base.incidencias.ResolucionIncidencia;
import base.repository.IncidenciaRepository;

public class IncidenciaService {

	private IncidenciaRepository incidenciaRepository;

    
    public List<Incidencia> listarTodas() {
        return incidenciaRepository.obtenerTodas();
    }

    
    public List<Incidencia> buscarPorTipo(String tipo) {
        return incidenciaRepository.buscarPorTipo(tipo);
    }

    
    public void registrarNueva(Incidencia incidencia) {
        incidenciaRepository.guardar(incidencia);
    }

    
    public void resolverIncidencia(Incidencia incidencia, ResolucionIncidencia resolucion) {
        
        incidenciaRepository.resolver(incidencia, resolucion);
}
}
