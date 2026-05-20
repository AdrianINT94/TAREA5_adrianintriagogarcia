package base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import base.model.Numero;

@Repository
public interface NumeroRepository extends JpaRepository<Numero,Long> {
	
	

}
