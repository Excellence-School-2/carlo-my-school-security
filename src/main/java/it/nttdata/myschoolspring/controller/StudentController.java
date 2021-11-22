package it.nttdata.myschoolspring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.nttdata.myschoolspring.entity.Student;
import it.nttdata.myschoolspring.repository.SchoolClassRepo;
import it.nttdata.myschoolspring.repository.StudentRepository;

@Controller
public class StudentController {
    
    private SchoolClassRepo schoolClassRepo;

    private StudentRepository studentRepository;
    public StudentController (StudentRepository studentRepository,SchoolClassRepo schoolClassRepo ) {
        this.studentRepository=studentRepository;
        this.schoolClassRepo=schoolClassRepo;
    }

    @GetMapping("/students")
    public String getStudents (Model model) {
        //Ci restituisce la lista degli studenti e la passa co model
        model.addAttribute("students", studentRepository.findAll()); //NB stduents sarebbe la chiave e ci possiamo mettere quello che vogliamo
         model.addAttribute("title", "List Student MySchool");
        //Ritorno il nome del fil html in Templates
        return "studentslist";
    }

        //Se vogliamo cliccare sulla classe nella lista
    @GetMapping("/students/{section}")
    public String getStudentByClass(Model model, @PathVariable String section) {
       model.addAttribute("title", "Lista studenti " + section);
        //Cosi mi ritorna una lista di una certa sezione
        model.addAttribute("students",studentRepository.findStudentByClass(section) );
        return "studentslist";
    }

    @PostMapping("/addStudent")
    public String postNewStudent(Student student, @RequestParam String section) {
        student.setSchoolClass(schoolClassRepo.findSchoolClassBySection(section));

        //Salvo gli studenti che inserisco tramite form perchè lo passo al metodo
        studentRepository.save(student);

        //Gestisco dati provenienti dal form in html--> mi riporta alla lista
        return "redirect:/students" ;

    }

    //Lo devo fare dopo il PostMapping per farci tornare il form --> devo mappare la richiesta get
    @GetMapping("/addStudent")
    public String getNewStudentForm(Model model) {
        model.addAttribute("sclasses", schoolClassRepo.findAll());
        return "addStudent";

    }


}
