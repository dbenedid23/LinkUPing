package dao;

import model.Candidature;
import model.Company;
import model.JobOffer;
import model.Skill;

import java.util.List;

public interface JobOfferDAO {
    void removeJobOffer(JobOffer jo);
    void updateJobOffer(JobOffer jo);
    List<JobOffer> getJobOffersBySalary(int salary);
    List<JobOffer> getJobOffersByTitle(String title);
    List<JobOffer>getJobOffersBySkills(String skill);
    List<Candidature>getJobOfferCandidatures(JobOffer jo);
    List<JobOffer>getJobOfferByLocation(String location);
    List<JobOffer>getJobOffersBySkill(Skill ski);
    JobOffer getJobOffer(int id);
    List<JobOffer>getJobOffersByWorkDayType(int workDayType);
    void createJobOffer(JobOffer jo);
    List<JobOffer>getJobOffersByCompany(Company co);
}
