package it.nttdata.myschoolspring.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.nttdata.myschoolspring.entity.Student;

//Il repository deve implementate delle azioni come la scrittura e la lettura
public interface StudentRepository extends CrudRepository <Student, Long>{
    
    //Mi creo una query che mi permette di filtrare gli studenti di una specifica classe
    //invece di avere tutti gli studenti quando lo chiediamo
    //IN () devo scrivere il formato JPA la query
    @Query(" SELECT s FROM Student s WHERE s.schoolClass.section = :section ")
    public Collection<Student> findStudentByClass(@Param("section") String section);

}
