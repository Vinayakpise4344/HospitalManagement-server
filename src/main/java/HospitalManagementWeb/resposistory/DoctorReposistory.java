package HospitalManagementWeb.resposistory;

import HospitalManagementWeb.entity.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorReposistory extends JpaRepository<DoctorEntity,Long> {
}
