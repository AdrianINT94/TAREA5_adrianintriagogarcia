package base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import base.model.Espectaculo;

@Repository
public interface EspectaculoRepository extends JpaRepository<Espectaculo,Long> {

}
