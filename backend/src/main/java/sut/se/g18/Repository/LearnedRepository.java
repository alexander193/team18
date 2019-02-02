package sut.se.g18.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import sut.se.g18.Entity.LearnedEntity;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface LearnedRepository extends JpaRepository<LearnedEntity, Long> {

}
