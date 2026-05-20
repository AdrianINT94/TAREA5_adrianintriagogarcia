package base.model;

public class Observaciones {

		private Long idCoordinador;
		private String evaluacion;
		private String observacion;
		private String fecha;
		
		public Observaciones() {
			
		}

		public Observaciones(Long idCoordinador, String evaluacion, String observacion, String fecha) {
			super();
			this.idCoordinador = idCoordinador;
			this.evaluacion = evaluacion;
			this.observacion = observacion;
			this.fecha = null;
		}

		public Long getIdCoordinador() {
			return idCoordinador;
		}

		public void setIdCoordinador(Long idCoordinador) {
			this.idCoordinador = idCoordinador;
		}

		public String getEvaluacion() {
			return evaluacion;
		}

		public void setEvaluacion(String evaluacion) {
			this.evaluacion = evaluacion;
		}

		public String getObservacion() {
			return observacion;
		}

		public void setObservacion(String observacion) {
			this.observacion = observacion;
		}

		public String getFecha() {
			return fecha;
		}

		public void setFecha(String fecha) {
			this.fecha = fecha;
		}
		
		
}
