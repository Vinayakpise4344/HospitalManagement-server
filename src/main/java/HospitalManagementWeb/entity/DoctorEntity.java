package HospitalManagementWeb.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

@Entity
@Data
@Table(name = "Doctor")
public class DoctorEntity {


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getSpecialization() {
        return Specialization;
    }

    public void setSpecialization(String specialization) {
        Specialization = specialization;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public Double getFees() {
        return fees;
    }

    public void setFees(Double fees) {
        this.fees = fees;
    }
    public Long getDr_ID() {
        return Dr_ID;
    }

    public void setDr_ID(Long dr_ID) {
        Dr_ID = dr_ID;
    }

    public Long getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(Long doctor_id) {
        this.doctor_id = doctor_id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Dr_ID;

    @Column(name = "doctor_id")
    private Long doctor_id;

    private String Name;
    private String phoneno;
    private String Specialization;
    private Integer age;
    private String email;
    private String experience;
    private Double fees;
}
