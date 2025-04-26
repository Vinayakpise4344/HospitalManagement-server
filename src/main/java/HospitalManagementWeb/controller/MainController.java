package HospitalManagementWeb.controller;


import HospitalManagementWeb.Dto.Drreqres;
import HospitalManagementWeb.Dto.Patientreqres;
import HospitalManagementWeb.Dto.ReqRes;
import HospitalManagementWeb.entity.ManagementEntity;
import HospitalManagementWeb.service.DoctorService;
import HospitalManagementWeb.service.ManagementService;
import HospitalManagementWeb.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class MainController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private ManagementService managementService;
    @PostMapping("/auth/register")
    public ReqRes addmanagementuser(@RequestBody ReqRes reqRes){

        return managementService.register(reqRes);
    }

    @PostMapping("/auth/login")
    public ReqRes login(@RequestBody ReqRes reqRes){
        return  managementService.Login(reqRes);
    }

    @GetMapping("/management/getalluser")
    public List<ManagementEntity> getAll(){
      return managementService.getallusers();
    }

    @PostMapping("/adddoctordetails")
    public Drreqres adddoctordetails(@RequestBody Drreqres drreqres){
        return  doctorService.addDoctors(drreqres);
    }
    @PostMapping("/addpatientdetails")
    public Patientreqres adddpatientdetails(@RequestBody Patientreqres patientreqres){
        return patientService.savePatient(patientreqres);
    }


}
