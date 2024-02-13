/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;
import dao.CompanyImplDAO;
import dao.UserImplDAO;
import model.*;

/**
 *
 * @author dev
 */
public class UserService {
    private UserImplDAO uid;
    public UserService() {
        this.uid = new UserImplDAO();
    }
    public void createUser(User  user){
        uid.createUser(user);
    }
    
    public void getUser(String name) {
        uid.getUsersByName(name);
    }
    public User createUser(String userName){
        User u = new User();
        u.setNombre(userName);
        uid.createUser(u);
        return u;
    }
    public void iniciarUser(String nombre, String password) {
        uid.inicioUser(nombre, password);
    }
    public void addJobExperience(User user, LaboralExperience lab, Company co){
        lab.setCompany(co);
        lab.setUser(user);
        user.getLaboralExperiences().add(lab);
        uid.updateUser(user);
    }
    public void addSkill(User user, String nombre) {
        Skill skills = new Skill(nombre);
        user.getSkills().add(skills);
        skills.getUsers().add(user);
        System.out.println(user);
        
        uid.updateUser(user);

    }
    public void addAcademicInfo(User user, AcademicInfo aca){
       
        aca.setUser(user);
        user.getAcademicInfos().add(aca);
        uid.updateUser(user);
    }
    public void addCandidature(User user, Candidature ca, JobOffer job){
        ca.setUser(user);
        ca.setJobOffers(job);
        user.getCandidatures().add(ca);
        uid.updateUser(user);
    }
    public void addCandidature(User user, Candidature ca) {
        ca.setUser(user);
        user.getCandidatures().add(ca);
        uid.updateUser(user);
    }
    public void addSkill(User user, Skill skill){//Preguntasion a profezo
        user.getSkills().add(skill);
        skill.getUsers().add(user);
        uid.updateUser(user);
    }
    public void addJobExperience(User user, LaboralExperience lab) {
        lab.setUser(user);
        user.getLaboralExperiences().add(lab);
        uid.updateUser(user);
    }
    public void addAcademicInfo(User user, AcademicInfo aca, Institution ins) {
        aca.setUser(user);
        aca.setInstitution(ins);
        user.getAcademicInfos().add(aca);
        uid.updateUser(user);
    }
    public void addCandidature(User user, JobOffer job, String coverLetterPath, String name) {//preguntar
        Candidature ca = new Candidature();
        ca.setJobOffers(job);
        ca.setUser(user);
        ca.setCoverLetterPath(coverLetterPath);
        ca.setName(name);
        user.getCandidatures().add(ca);
        uid.updateUser(user);
    }
    public void addCandidature(User user, JobOffer job) {//preguntar 
        Candidature ca = new Candidature();
        ca.setJobOffers(job);
        ca.setUser(user);
        user.getCandidatures().add(ca);
        uid.updateUser(user);
    }
    public void removeUser(User user){
        uid.removeUser(user);
    }
    public User createUser(String name, String description, int telephone, String mail, String password){
        User u = new User();
        u.setNombre(name);
        u.setDescription(description);
        u.setTelephone(telephone);
        u.setMail(mail);
        u.setPassword(password);
        uid.createUser(u);
        return u;
    }
}
