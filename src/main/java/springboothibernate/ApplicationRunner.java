package springboothibernate;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springboothibernate.model.Course;
import springboothibernate.model.Laptop;
import springboothibernate.model.Student;
import springboothibernate.service.StudentService;

@Component
public class ApplicationRunner implements CommandLineRunner {

  @Autowired
  private StudentService studentService;

  @Override
  public void run(String... args) throws Exception {
    Student s1 = new Student();
    Laptop l1 = new Laptop();

    /*Student s2 = new Student();
    Laptop l2 = new Laptop();*/

    Course c1 = new Course();
    c1.setCourseId(204);
    c1.setCourseName("Java");
    c1.setStudent(s1);

    Course c2 = new Course();
    c2.setCourseId(203);
    c2.setCourseName("J2EE");
    c2.setStudent(s1);

    l1.setLaptopId(102);
    l1.setCompany("Lenovo");

    s1.setStudentId(402);
    s1.setName("Student Name 1");

    /*
    l2.setLaptopId(102);
    l2.setCompany("Dell");

    s2.setStudentId(402);
    s2.setName("Student Name 2");

    l2.setStudent(s2);
    s2.setLaptop(l2);*/

    l1.setStudent(s1);
    s1.setLaptop(l1);
    s1.setCourses(Arrays.asList(c1, c2));

//    studentService.createStudent(s2);
    studentService.createStudent(s1);

    System.out.println("Student saved");

    Student student = studentService.getStudent(s1.getStudentId());
    System.out.println(student);
    student = studentService.getStudentUsingNativeQuery(s1.getStudentId());
    System.out.println(student);
    student = studentService.getStudentUsingNativeQuery(s1.getStudentId());
    System.out.println(student);
  }
}
