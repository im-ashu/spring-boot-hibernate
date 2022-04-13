package springboothibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import springboothibernate.model.Student;

@Repository
public class StudentDAO {

  @Autowired
  private SessionFactory sessionFactory;

  public void createStudent(Student student) {
    Session session = sessionFactory.openSession();
    Transaction transaction = session.getTransaction();
    transaction.begin();
    session.persist(student);
    transaction.commit();
    session.close();
  }

  public Student getStudent(int id) {
    Session session = sessionFactory.openSession();
    Transaction transaction = session.getTransaction();
    transaction.begin();
    Student student = session.get(Student.class, id);
    Student student1 = session.get(Student.class, id);
    System.out.println("Inside DAO class " + student1);
    session.close();
    return student;
  }

  public Student getStudentUsingNativeQuery(Integer studentId) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    Query<Student> query = session.createQuery("from Student where studentId=:studentId",
        Student.class);
    query.setParameter("studentId", studentId);
//    query.setCacheable(true);
    Student student = query.getSingleResult();
    session.getTransaction().commit();
    session.close();
    return student;

  }
}
