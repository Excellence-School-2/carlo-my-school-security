package it.nttdata.myschoolspring.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import it.nttdata.myschoolspring.entity.SchoolClass;
import it.nttdata.myschoolspring.entity.Student;
import it.nttdata.myschoolspring.repository.SchoolClassRepo;
import it.nttdata.myschoolspring.repository.StudentRepository;

//Qui implemento il database

@Component //Cosi lo faccio vedere aspring con component
public class Bootstrapdata implements CommandLineRunner{

       //Mi faccio dare le dipendenze da spring ale repository perciò dichiaro degli attributi
       //Li dichiaro final perchè sono questi e basta
       private final StudentRepository studentRepository;
       private final SchoolClassRepo schoolClassRepo;

       //Mi creo il costruttore cosi spring ci da delle classi a doc 
        public Bootstrapdata (StudentRepository studentRepository, SchoolClassRepo schoolClassRepo) {
            this.schoolClassRepo=schoolClassRepo;
            this.studentRepository=studentRepository;
        }

    
/*Vengono passati i parametri di avvio dell'applicativo. QUi creiamo solo delle classi che uso nel database*/
    @Override
    public void run(String... args) throws Exception {
    
        /*Ora creo gli studenti da inserire*/
    SchoolClass schoolClass1 = new SchoolClass("1A");
    SchoolClass schoolClass2 = new SchoolClass("2A");
    SchoolClass schoolClass3 = new SchoolClass("3A");

    Student student1 = new Student("Mario", "ROssi", 14);
    Student student2 = new Student("Maria", "Giggini", 15);
    Student student3 = new Student("GIovanni", "Gialli", 11);
    Student student4 = new Student("Pippo", "Bianchi", 12);
    Student student5 = new Student("Pluto", "Maroni", 13);
    Student student6 = new Student("Marta", "Manvhi", 16);

    //Associo gli studenti alla classe
    student1.setSchoolClass(schoolClass1);
    student2.setSchoolClass(schoolClass3);
    student4.setSchoolClass(schoolClass2);
    student5.setSchoolClass(schoolClass2);
    student6.setSchoolClass(schoolClass3);
    student3.setSchoolClass(schoolClass1);

    //Associamo i repositorycosì da salvere i dati che sto inserendo

        //Prima questo perchè è la classe più forte
        schoolClassRepo.save(schoolClass1);
        schoolClassRepo.save(schoolClass2);
        schoolClassRepo.save(schoolClass3);

    studentRepository.save(student1);
    studentRepository.save(student2);
    studentRepository.save(student3);
    studentRepository.save(student4);
    studentRepository.save(student5);
    studentRepository.save(student6);
    
    
    }
    
}
