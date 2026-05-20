package base.model;

import java.util.List;

public class Trayectoria {

		private Long idEspectaculo;
		
		private String fechaInicio;
		private String fechaFin;
		private String rol;
		private List<NumeroDossier> numeros;
		
		public Trayectoria() {}

		
		public Trayectoria(Long idEspectaculo, String fechaInicio, String fechaFin, String rol) {
			super();
			this.idEspectaculo = idEspectaculo;
			this.fechaInicio = fechaInicio;
			this.fechaFin = fechaFin;
			this.rol = rol;
		}

		public Long getIdEspectaculo() {
			return idEspectaculo;
		}

		public void setIdEspectaculo(Long idEspectaculo) {
			this.idEspectaculo = idEspectaculo;
		}


		public String getFechaInicio() {
			return fechaInicio;
		}

		public void setFechaInicio(String fechaInicio) {
			this.fechaInicio = fechaInicio;
		}

		public String getFechaFin() {
			return fechaFin;
		}

		public void setFechaFin(String fechaFin) {
			this.fechaFin = fechaFin;
		}

		public String getRol() {
			return rol;
		}

		public void setRol(String rol) {
			this.rol = rol;
		}

		public List<NumeroDossier> getNumeros() {
			return numeros;
		}

		public void setNumeros(List<NumeroDossier> numeros) {
			this.numeros = numeros;
		}

		
		
}
