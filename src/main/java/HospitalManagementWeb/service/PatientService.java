package HospitalManagementWeb.service;

import HospitalManagementWeb.Dto.Patientreqres;
import HospitalManagementWeb.entity.DoctorEntity;
import HospitalManagementWeb.entity.PatientEntity;
import HospitalManagementWeb.resposistory.DoctorReposistory;
import HospitalManagementWeb.resposistory.PatientReposistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private PatientReposistory patientRepository;

    @Autowired
    private DoctorReposistory doctorRepository;

    public Patientreqres savePatient(Patientreqres req) {
        Patientreqres response = new Patientreqres();
        try {
            // Get doctor from DB using ID from request
            Optional<DoctorEntity> doctorOpt = doctorRepository.findById(req.getDoctor_id());

            if (doctorOpt.isPresent()) {
                DoctorEntity doctor = doctorOpt.get();

                // Map request to entity
                PatientEntity patient = new PatientEntity();
                patient.setPatientName(req.getPatientName());
                patient.setGender(req.getGender());
                patient.setAge(req.getAge());
                patient.setContactNumber(req.getContactNumber());
                patient.setEmail(req.getEmail());
                patient.setAddress(req.getAddress());
                patient.setDepartment(req.getDepartment());
                patient.setAppointmentDate(req.getAppointmentDate());
                patient.setAppointmentTime(req.getAppointmentTime());
                patient.setMedicalConcern(req.getMedicalConcern());
                patient.setAppointmentType(req.getAppointmentType());
                patient.setPaymentMethod(req.getPaymentMethod());

                // Set doctor for the patient
                patient.setDoctor_id(doctor);  // Set the fetched doctor entity

                // Save patient
                PatientEntity savedPatient = patientRepository.save(patient);

                // Prepare response
                response.setPatientEntity(savedPatient);
                response.setMessage("Patient saved successfully");
                response.setStatuscode(200);
            } else {
                response.setMessage("Doctor not found");
                response.setStatuscode(404);
            }
        } catch (Exception e) {
            response.setMessage("Something went wrong");
            response.setStatuscode(500);
        }
        return response;
    }

}
