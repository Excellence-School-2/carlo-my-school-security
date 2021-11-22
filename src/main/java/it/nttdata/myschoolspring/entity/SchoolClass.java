package it.nttdata.myschoolspring.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class SchoolClass {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String section;

    public SchoolClass(){}
    
    public SchoolClass(String section){
        this.section= section;
    }

    @OneToMany(mappedBy = "schoolClass")
    private List<Student> studentList = new ArrayList<>();


    public  int getStudentNumber(){
        return studentList.size();
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}