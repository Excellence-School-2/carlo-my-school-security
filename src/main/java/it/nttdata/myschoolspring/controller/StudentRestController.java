package it.nttdata.myschoolspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import it.nttdata.myschoolspring.entity.Student;
import it.nttdata.myschoolspring.repository.StudentRepository;

@RestController
public class StudentRestController {

    private StudentRepository studentRepository;

    public StudentRestController(StudentRepository studentRepository){
        this.studentRepository= studentRepository;
    }

    //Mi deve tornare una lista di studenti
    @GetMapping("/api/v0/students")
    public Iterable<Student> getStudents(){

       // List<Student> students = new ArrayList<>();
 // studentRepository.findAll().forEach(students::add);
      return  studentRepository.findAll();
      //  return students;

    }

    //Facciamo la GET per un singolo studente
    @GetMapping("/api/v0/students/{id}")
    public Student getStudent(@PathVariable Long id) {

        return studentRepository.findById(id).get();

    }

}

