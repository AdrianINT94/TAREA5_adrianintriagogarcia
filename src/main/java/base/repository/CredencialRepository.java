package base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import base.model.Credencial;

@Repository
public interface CredencialRepository extends JpaRepository<Credencial,Long>{
	
		Credencial findByNombreusuario(String nombreusuario);
	
}
