package vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.models.Company;
import vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.repositories.CompanyRepository;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    public Company findByUsernameAndPassword(String username, String password){
        return companyRepository.findByUserUsernameAndUserPassword(username, password);
    }
}
