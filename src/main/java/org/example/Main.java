package org.example;

import org.example.config.FactoryConfiguration;
import org.example.embed.FullName;
import org.example.entity.Marks;
import org.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();

        FullName fullName = new FullName("Kamal","Silva");

        //Student -->
        Student student = new Student();
        student.setId(3);
        student.setName(fullName);
        student.setAddress("Moratuwa");

        //Marks -->
        Marks marks = new Marks();
        marks.setId(1);
        marks.setSubject("PRF");
        marks.setMarks(90);

        //Transaction Opening
        Transaction transaction = session.beginTransaction();

        //save -->
        session.save(student);
        session.save(marks);

        //update  -->
        //session.update(student);
        //session.update(marks);

        //delete  -->
        // session.delete(student);
        // session.delete(marks);


        transaction.commit();
        session.close();
    }
}
