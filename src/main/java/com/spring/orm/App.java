package com.spring.orm;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
        Student st = new Student(12,"Aman","America");
        studentDao.update(st);
        List<Student> list = studentDao.getAll();
       for(Student s:list)
           System.out.println(s.getStudentId() +" "+s.getStudentName()+" "+s.getStudentCity());

        System.out.println("Done--------- ");
    }
}
