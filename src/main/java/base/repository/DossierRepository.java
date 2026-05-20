package base.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import base.model.DossierArtista;

public interface DossierRepository extends MongoRepository<DossierArtista,String>{

		DossierArtista findByIdArtista(Long IdArtista);
}
