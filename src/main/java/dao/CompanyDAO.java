package dao;

import model.Candidature;
import model.Company;
import model.JobOffer;

import java.util.List;

public interface CompanyDAO {
    Company getCompanyByName(String companyName);
    List<Candidature> getCandidaturesByJobOffer(Company co, JobOffer jo);
    void updateCompany(Company co);
    List<JobOffer>getJobOffers(Company co);
    void removeCompany(Company co);
    void createCompany(Company co);
    Company getCompany(int id);
    //
}
