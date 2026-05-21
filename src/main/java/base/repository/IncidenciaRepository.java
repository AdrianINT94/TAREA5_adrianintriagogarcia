package base.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import base.incidencias.Incidencia;
import base.incidencias.ResolucionIncidencia;

@Repository
public class IncidenciaRepository {
	
		private String urlServidor ="ficheros/incidencias.odb;user=admin;password=admin";
		
		private EntityManager getEntityManager() {
			EntityManagerFactory fabrica = Persistence.createEntityManagerFactory(urlServidor);
			return fabrica.createEntityManager();
		}
		
		public void guardar(Incidencia incidencia) {
			EntityManager sesion = getEntityManager();
			try {
				sesion.getTransaction().begin();
				sesion.persist(incidencia);
				sesion.getTransaction().commit();
				System.out.println("Incidencia guardara con exito en ObjectDB");
			}catch(Exception e) {
				
	}finally {
		sesion.close();
			}
		}
		public List<Incidencia> obtenerTodas(){
			EntityManager sesion = getEntityManager();
			try {
				TypedQuery<Incidencia> consulta = sesion.createQuery("SELECT i FROM Incidencia i",Incidencia.class);
				return consulta.getResultList();
	}finally {
		sesion.close();
			}
		}
		public List<Incidencia> buscarPorTipo(String tipoSeleccionado){
			EntityManager sesion = getEntityManager();
			try {
				TypedQuery<Incidencia> query = sesion.createQuery("SELECT i FROM Incidencia i WHERE i.tipo =:valor",Incidencia.class);
				query.setParameter("valor",tipoSeleccionado);
				return query.getResultList();
				
			}catch(Exception e) {
				e.printStackTrace();
				return null;
	}finally {
		sesion.close();
			}
		}
		public void resolver (Incidencia incidencia,ResolucionIncidencia resolucion) {
			EntityManager sesion = getEntityManager();
			try {
				
				sesion.getTransaction().begin();
				incidencia.setResuelta(true);
				sesion.merge(incidencia);
				resolucion.setIncidencia(incidencia);
				sesion.persist(resolucion);
				sesion.getTransaction().commit();
				System.out.println("Resolucion guardada correctamente");
			}catch(Exception e) {
				e.printStackTrace();
			
		}finally {
			sesion.close();
		}
}
}
