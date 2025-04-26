package HospitalManagementWeb.Dto;

import HospitalManagementWeb.entity.ManagementEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqRes {
    private String error;
    private String message;
    private Integer statuscode;
    private String token;
    private String refreshtoken;
    private String name;
    private String email;
    private Long id;
    private String EmployeeID;

    private String phoneno;

    private String password;
    private String role;
    private String success;

    private String expirationToken;
    private ManagementEntity managementEntity;
    private List<ManagementEntity> managementEntities;
}
