package base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import base.model.Coordinador;

@Repository
public interface CoordinadorRepository extends JpaRepository<Coordinador,Long> {

}
