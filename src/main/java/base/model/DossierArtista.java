package base.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class DossierArtista {
		
	
		@Id
		private String id;
		private String nombre;
		private String email;
		private String nacionalidad;
		private String apodo;
		private Long idArtista;
		private List<String> especialidades;
		private List<String> habilidades;
		private List<Trayectoria> trayectoria;
		private List<Observaciones> observaciones;
		private List<Evaluacion> evaluaciones;
		
		public DossierArtista() {}

		public DossierArtista(String id, String nombre, String email, String nacionalidad, String apodo, Long idArtista,
				List<String> especialidades, List<String> habilidades, List<Trayectoria> trayectoria,
				List<Observaciones> observaciones, List<Evaluacion> evaluaciones) {
			super();
			this.id = id;
			this.nombre = nombre;
			this.email = email;
			this.nacionalidad = nacionalidad;
			this.apodo = apodo;
			this.idArtista = idArtista;
			this.especialidades = especialidades;
			this.habilidades = habilidades;
			this.trayectoria = trayectoria;
			this.observaciones = observaciones;
			this.evaluaciones = evaluaciones;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getNacionalidad() {
			return nacionalidad;
		}

		public void setNacionalidad(String nacionalidad) {
			this.nacionalidad = nacionalidad;
		}

		public String getApodo() {
			return apodo;
		}

		public void setApodo(String apodo) {
			this.apodo = apodo;
		}

		public Long getIdArtista() {
			return idArtista;
		}

		public void setIdArtista(Long idArtista) {
			this.idArtista = idArtista;
		}

		public List<String> getEspecialidades() {
			return especialidades;
		}

		public void setEspecialidades(List<String> especialidades) {
			this.especialidades = especialidades;
		}

		public List<String> getHabilidades() {
			return habilidades;
		}

		public void setHabilidades(List<String> habilidades) {
			this.habilidades = habilidades;
		}

		public List<Trayectoria> getTrayectoria() {
			return trayectoria;
		}

		public void setTrayectoria(List<Trayectoria> trayectoria) {
			this.trayectoria = trayectoria;
		}

		public List<Observaciones> getObservaciones() {
			return observaciones;
		}

		public void setObservaciones(List<Observaciones> observaciones) {
			this.observaciones = observaciones;
		}

		public List<Evaluacion> getEvaluaciones() {
			return evaluaciones;
		}

		public void setEvaluaciones(List<Evaluacion> evaluaciones) {
			this.evaluaciones = evaluaciones;
		}
		
}
