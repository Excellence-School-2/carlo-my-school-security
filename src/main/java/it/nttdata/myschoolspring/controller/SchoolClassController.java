package it.nttdata.myschoolspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.nttdata.myschoolspring.repository.SchoolClassRepo;

@Controller
public class SchoolClassController {

    private SchoolClassRepo schoolClassRepo;
    //Crepo costruttore della reprository
    public SchoolClassController(SchoolClassRepo schoolClassRepo) {
        this.schoolClassRepo=schoolClassRepo;
    }

    //Devo mappare la richiesta utente e fornirlo sottoforma di template compilato
    //I controller restituiscono sempre delle stringhe
    //GetMapping serve per fare la request e devo fare il percorso su cui faccio il mapping della get

    @GetMapping("/classes")
    public String getSchoolClasses(Model model) {
        //Nel model devo isnerire il repository perchè ho messo li i dati
        //Cosi posso passarli al html grazie al controller
        model.addAttribute("schoolClasses", schoolClassRepo.findAll());
        return "schoolclass";
    }
    
}
