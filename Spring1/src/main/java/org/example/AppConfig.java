package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan("org.example")
public class AppConfig {
    // by using bean
    @Bean
    public Address addr1(){
        Address a=new Address(101,"bpur",450331);

        return a;
    }
    @Bean
    public Address addr2(){
        Address a=new Address(102,"pune",450311);

        return a;
    }
    @Bean
    public  Subject sub(){
        List<String> sl=new ArrayList<>();
        sl.add("java");
        sl.add("react");
        sl.add("angular");
        sl.add("sql");
        Subject s=new Subject(sl);
        return s;
    }
    @Bean
    @Scope("prototype")
    public Student stu1(){
        Student s= new Student(1,"Amruta","java");
        Address a=new Address();
        s.setId(1);
        s.setName("Amruta");
        s.setCourse("java");
        Address a=new Address();
        a.setHouseNo(101);
        a.setCity("bpur");
        a.setPincode(4503310);
        s.setAddress(a);
        return  s;
    }
}