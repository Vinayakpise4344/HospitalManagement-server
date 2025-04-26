package HospitalManagementWeb.service;

import HospitalManagementWeb.Dto.ReqRes;
import HospitalManagementWeb.entity.ManagementEntity;
import HospitalManagementWeb.resposistory.ManagementReposistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ManagementService {
    @Autowired
    private ManagementReposistory managementReposistory;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

   public ReqRes register(ReqRes registerrequest){
          ReqRes reqRes = new ReqRes();
          try {
              ManagementEntity managementEntity = new ManagementEntity();
              managementEntity.setEmail(registerrequest.getEmail());
              managementEntity.setName(registerrequest.getName());
              managementEntity.setEmployeeID(registerrequest.getEmployeeID());
              managementEntity.setPhoneno(registerrequest.getPhoneno());
              managementEntity.setRole(registerrequest.getRole());
              managementEntity.setPassword(passwordEncoder.encode(registerrequest.getPassword()));
              ManagementEntity managementEntity1 = managementReposistory.save(managementEntity);
              if(managementEntity1.getId()!= null){
                  reqRes.setManagementEntity(managementEntity);
                  reqRes.setMessage("User Saved Sucessfully");
                  reqRes.setStatuscode(200);
              }
          }catch (Exception e){
              reqRes.setStatuscode(400);
              reqRes.setMessage(e.getMessage());
          }
          return reqRes;
   }
   
   public ReqRes Login(ReqRes loginreg){
       ReqRes response = new ReqRes();
       try {
           authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginreg.getEmail(),loginreg.getPassword()));
           var user = managementReposistory.findByEmail(loginreg.getEmail()).orElseThrow();
           var jwt = jwtUtils.generateToken(user);
           var refreshToken = jwtUtils.refreshToken(new HashMap<>(),user);
           response.setStatuscode(200);
           response.setToken(jwt);
           response.setRefreshtoken(refreshToken);
           response.setExpirationToken("24");
           response.setMessage("Sucessfully Loged In");

       } catch (Exception e) {
           response.setStatuscode(500);
           response.setMessage(e.getMessage());
       }
       return response;
   }

   public List<ManagementEntity> getallusers(){
       return managementReposistory.findAll();
   }
}
