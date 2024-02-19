package Services;
import dao.CompanyImplDAO;
import dao.UserImplDAO;
import model.Company;
import model.JobOffer;
import model.User;
import org.checkerframework.checker.units.qual.C;

public class CompanyService {
    private CompanyImplDAO cid;
    public CompanyService(){
        this.cid = new CompanyImplDAO();
    }
    public void createCompany(Company co){
            cid.createCompany(co);
    }
    public void removeCompany(Company co){
            cid.removeCompany(co);
    }
    public Company createCompany(String name){
        Company c = new Company();
        c.setName(name);
        cid.createCompany(c);
        return c;
    }

    public Company createCompany(String name, String description, String password){
        Company c = new Company();
        c.setName(name);
        c.setDescription(description);
        c.setPassword(password);
        cid.createCompany(c);
        return c;
    }
    public void addJobOffer(Company co, JobOffer job){
            cid.getCandidaturesByJobOffer(co, job);
    }
    public boolean inicioCompany(String name, String password) {
        Company co = cid.iniciarCompany(name, password);
        if (co != null) {
            return true;
        } else {
            return false;
        }
    }
}
