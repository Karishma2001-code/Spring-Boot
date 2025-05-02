package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {
    @Value("2")
    private int id;

    public Student(int id, String name, String course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

       @Value("Komal")
    private String name;
    @Value("IT")
    private String course;
    @Autowired
    @Qualifier("addr2")
    private Address address;
    @Autowired
    private Subject subject;




    // by using setter

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }
    public void setCourse(String course) {
        this.course = course;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public void displayInfo() {
        System.out.println("Student ID: " + id);
        System.out.println("Name      : " + name);
        System.out.println("Course    : " + course);
        System.out.println("Address    : " + address);
        System.out.println("Subject    : " + subject);
    }
  /*  @PostConstruct
    public void start(){
        System.out.println("Starting methord");
    }
   @PreDestroy
    public void  end(){
        System.out.println("end methord");
    }*/
}

