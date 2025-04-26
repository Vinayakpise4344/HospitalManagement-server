package HospitalManagementWeb.resposistory;

import HospitalManagementWeb.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientReposistory extends JpaRepository<PatientEntity,Long> {
}
