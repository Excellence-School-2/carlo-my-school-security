package it.nttdata.myschoolspring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.nttdata.myschoolspring.entity.SchoolClass;

public interface SchoolClassRepo extends CrudRepository<SchoolClass, Long> {
    
    @Query(" SELECT s FROM SchoolClass s WHERE s.section = :section ")
    public SchoolClass findSchoolClassBySection(@Param("section") String section);
}
