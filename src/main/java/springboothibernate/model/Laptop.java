package springboothibernate.model;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Laptop {

  @Id
  @Column(name = "laptop_id", nullable = false)
  private Integer laptopId;

  private String company;

  @OneToOne()
  @JoinColumn(name = "student_id")
  private Student student;

  public Laptop() {
  }

  public Student getStudent() {
    return student;
  }

  public Integer getLaptopId() {
    return laptopId;
  }

  public void setLaptopId(Integer laptopId) {
    this.laptopId = laptopId;
  }

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public void setStudent(Student student) {
    this.student = student;
  }

  @Override
  public String toString() {
    return "Laptop{" +
        "laptopId=" + laptopId +
        ", company='" + company + '\'' +
        '}';
  }
}
