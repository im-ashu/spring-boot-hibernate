package springboothibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboothibernate.dao.StudentDAO;
import springboothibernate.model.Student;

@Service
public class StudentService {

  @Autowired
  private StudentDAO studentDAO;

  public void createStudent(Student student) {
    studentDAO.createStudent(student);
  }

  public Student getStudent(Integer studentId) {
    return studentDAO.getStudent(studentId);
  }

  public Student getStudentUsingNativeQuery(Integer studentId) {
    return studentDAO.getStudentUsingNativeQuery(studentId);
  }
}
