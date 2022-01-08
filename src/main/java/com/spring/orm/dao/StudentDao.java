package com.spring.orm.dao;
import com.spring.orm.entities.Student;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.transaction.Transactional;
import java.util.List;

public class StudentDao {

    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    //create
    @Transactional
    public int insert(Student student){
        Integer i = (Integer) hibernateTemplate.save(student);
        return i;
    }

    //read
    public Student getStudent(int id){
        System.out.println("--------------------read----------------");
        Student s = this.hibernateTemplate.get(Student.class,id);
        return s;
    }

    public List<Student> getAll(){
        List<Student> lst = this.hibernateTemplate.loadAll(Student.class);
        return lst;
    }

    //update
    @Transactional
    public void update(Student student)
    {
        this.hibernateTemplate.update(student);
    }

    //delete
    @Transactional
    public void delete(int id){
        Student st = this.hibernateTemplate.get(Student.class,id);
        this.hibernateTemplate.delete(st);
    }


}
