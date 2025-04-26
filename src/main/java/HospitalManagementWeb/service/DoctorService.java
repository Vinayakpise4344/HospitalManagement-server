package HospitalManagementWeb.service;

import HospitalManagementWeb.Dto.Drreqres;
import HospitalManagementWeb.entity.DoctorEntity;
import HospitalManagementWeb.resposistory.DoctorReposistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
    @Autowired
    private DoctorReposistory doctorReposistory;

    public Drreqres addDoctors(Drreqres drreqres) {
        Drreqres response = new Drreqres();
        try {
            DoctorEntity doctorEntity = new DoctorEntity();
            doctorEntity.setDoctor_id(drreqres.getDoctor_id());
            doctorEntity.setAge(drreqres.getAge());
            doctorEntity.setEmail(drreqres.getEmail());
            doctorEntity.setName(drreqres.getName());
            doctorEntity.setPhoneno(drreqres.getPhoneno());
            doctorEntity.setFees(drreqres.getFees());
            doctorEntity.setSpecialization(drreqres.getSpecialization());
            doctorEntity.setExperience(drreqres.getExperience());

            // Save to DB
            DoctorEntity savedDoctor = doctorReposistory.save(doctorEntity);

            // Set values in response
            response.setDoctorEntity(savedDoctor);
            response.setDoctor_id(savedDoctor.getDoctor_id());
            response.setAge(savedDoctor.getAge());
            response.setEmail(savedDoctor.getEmail());
            response.setPhoneno(savedDoctor.getPhoneno());
            response.setFees(savedDoctor.getFees());
            response.setSpecialization(savedDoctor.getSpecialization());
            response.setExperience(savedDoctor.getExperience());
            response.setMessage("Your Doctor has been saved");
            response.setStatuscode(202);

        } catch (Exception e) {
            response.setMessage("Something went wrong");
            response.setStatuscode(401);
        }
        return response;

    }

}
