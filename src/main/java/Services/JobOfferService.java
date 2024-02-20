package Services;
import dao.CompanyImplDAO;
import dao.JobOfferImplDAO;
import model.Candidature;
import model.Company;
import model.JobOffer;

import java.util.List;

public class JobOfferService {
    private JobOfferImplDAO jid;

    public JobOfferService(){
        this.jid = new JobOfferImplDAO();
    }


    public void closeJobOffer(JobOffer job){
        jid.removeJobOffer(job);//?????????????????????? askinnnn
    }
    public void removeJobOffer(JobOffer job){
            jid.removeJobOffer(job);

    }
    public JobOffer createJobOffer(String name, Company co){
        JobOffer j = new JobOffer();
        j.setTitle(name);
        j.setCompany(co);
        jid.createJobOffer(j);
        return j;
    }
    public List<Candidature> getCandidaturesJobOffers(JobOffer job){
        return null;
    }
    public void createJobOffer(JobOffer jo){
            jid.createJobOffer(jo);
    }
    public List<JobOffer> getJobOffers(){
        List<JobOffer> jos = jid.getAllJobOffers();
        return jos;
    }
}
