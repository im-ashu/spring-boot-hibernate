package springboothibernate.model;

import java.util.List;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Student {

  @Id
  @Column(name = "student_id", nullable = false)
  private Integer studentId;

  private String name;

  @OneToOne(fetch = FetchType.EAGER, mappedBy = "student", cascade = CascadeType.ALL)
  private Laptop laptop;

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "student", cascade = CascadeType.ALL)
  private List<Course> courses;

  public Student() {
  }

  public Integer getStudentId() {
    return studentId;
  }

  public void setStudentId(Integer studentId) {
    this.studentId = studentId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setLaptop(Laptop laptop) {
    this.laptop = laptop;
  }

  public Laptop getLaptop() {
    return laptop;
  }

  public List<Course> getCourses() {
    return courses;
  }

  public void setCourses(List<Course> courses) {
    this.courses = courses;
  }

  @Override
  public String toString() {
    return "Student{" + "studentId=" + studentId + ", name='" + name + '\'' + ", laptop=" + laptop
        + ", courses=" + courses + '}';
  }
}
