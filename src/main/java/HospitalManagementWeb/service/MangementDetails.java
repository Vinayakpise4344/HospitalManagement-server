package HospitalManagementWeb.service;

import HospitalManagementWeb.resposistory.ManagementReposistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MangementDetails implements UserDetailsService {
    @Autowired
    private ManagementReposistory managementReposistory;




    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return managementReposistory.findByEmail(username).orElseThrow();
    }
}


