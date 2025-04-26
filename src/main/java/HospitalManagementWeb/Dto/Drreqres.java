package HospitalManagementWeb.Dto;

import HospitalManagementWeb.entity.DoctorEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Drreqres {
    private Long doctor_id;

    private String Name;
    private String phoneno;
    private String Specialization;
    private Integer age;
    private String email;
    private String experience;
    private Double fees;
    private  String message;
    private Integer statuscode;
    private DoctorEntity doctorEntity;
    private List<DoctorEntity> doctorEntities;
}

