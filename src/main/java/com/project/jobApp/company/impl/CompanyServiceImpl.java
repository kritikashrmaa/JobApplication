package com.project.jobApp.company.impl;

import com.project.jobApp.company.Company;
import com.project.jobApp.company.CompanyRepository;
import com.project.jobApp.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {



    private final CompanyRepository companyRepository;
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public List<com.project.jobApp.company.Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Company company1, Long id) {
        Optional<Company> companyOptional=companyRepository.findById(id);

        if(companyOptional.isPresent()){
            Company company=companyOptional.get();
            company.setDescription(company1.getDescription());
            company.setName(company1.getName());
            company.setJobs(company1.getJobs());
            companyRepository.save(company);
            return true;
        }


        return false;
    }

    @Override
    public boolean deleteCompany(Long id) {
        if(companyRepository.existsById(id)) {
            companyRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

}
