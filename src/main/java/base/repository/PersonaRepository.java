package base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import base.model.Persona;

@Repository
public interface PersonaRepository  extends JpaRepository<Persona,Long>{
	

}
