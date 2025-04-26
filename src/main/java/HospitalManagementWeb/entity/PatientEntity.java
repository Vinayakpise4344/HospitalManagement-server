package HospitalManagementWeb.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity

@Table(name = "Patientaappointment")
public class PatientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ptId;

    private String patientName;
    private String gender;
    private int age;
    private String contactNumber;
    private String email;
    private String address;

    private String department;
// Optional - can link to Doctor entity later

    private String appointmentDate; // Can be LocalDate if needed
    private String appointmentTime; // Can be LocalTime if needed

    private String medicalConcern;
    private String appointmentType;   // OPD / Emergency / Follow-up
    private String paymentMethod;     // Cash / Online / Insurance

    //many appointment can associated with one doctor
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private DoctorEntity doctor_id;


    public Long getPtId() {
        return ptId;
    }

    public void setPtId(Long ptId) {
        this.ptId = ptId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getMedicalConcern() {
        return medicalConcern;
    }

    public void setMedicalConcern(String medicalConcern) {
        this.medicalConcern = medicalConcern;
    }

    public String getAppointmentType() {
        return appointmentType;
    }

    public void setAppointmentType(String appointmentType) {
        this.appointmentType = appointmentType;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public DoctorEntity getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(DoctorEntity doctor_id) {
        this.doctor_id = doctor_id;
    }
}
