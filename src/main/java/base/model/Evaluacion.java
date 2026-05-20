package base.model;

public class Evaluacion {

		private String fecha;
		private String comentario;
		private String nivel;
		private Realizada realizada;
		
		public  Evaluacion() {}

		public String getFecha() {
			return fecha;
		}

		public void setFecha(String fecha) {
			this.fecha = fecha;
		}

		public String getComentario() {
			return comentario;
		}

		public void setComentario(String comentario) {
			this.comentario = comentario;
		}

		public String getNivel() {
			return nivel;
		}

		public void setNivel(String nivel) {
			this.nivel = nivel;
		}

		public Realizada getRealizada() {
			return realizada;
		}

		public void setRealizada(Realizada realizada) {
			this.realizada = realizada;
		}
		
		
}
