package it.nttdata.myschoolspring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Student {
//NB: l'id inizia da 4 perchè questa cosa la gesisce h2 attraverso il comando generationTYpe
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //Va passata la stategia di generazione
    private Long id;

    private String name;
    private String surname;
    private int age;

    public Student() {}
    public Student(String name, String surname, int age) {
        this.surname=surname;
        this.name=name;
        this.age=age;
    }

    @ManyToOne //CIs non stanti studenti in una classe e non devo mappare perchè nella classe c'è già
    @JoinColumn(name="schoolClass_id") //Si mette il nome della tabella che si crea 
    @JsonIgnore
    private SchoolClass schoolClass;

   
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public SchoolClass getSchoolClass() {
        return schoolClass;
    }
    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }
    
}
