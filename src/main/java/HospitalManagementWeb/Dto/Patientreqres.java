package HospitalManagementWeb.Dto;

import HospitalManagementWeb.entity.DoctorEntity;
import HospitalManagementWeb.entity.PatientEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patientreqres {
    private String patientName;
    private String gender;
    private int age;
    private String contactNumber;
    private String email;
    private String address;
    private String department;
    private String appointmentDate; // Can be LocalDate if needed
    private String appointmentTime; // Can be LocalTime if needed
    private String medicalConcern;
    private String appointmentType;   // OPD / Emergency / Follow-up
    private String paymentMethod;     // Cash / Online / Insurance
    private Long doctor_id;
    private String message;
    private Integer statuscode;
    private PatientEntity patientEntity;
    private List<PatientEntity> patientEntities;

}
