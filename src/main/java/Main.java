
import Services.CompanyService;
import Services.UserService;
import model.AcademicInfo;
import model.Company;
import model.JobOffer;
import model.LaboralExperience;
import model.Skill;
import model.User;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author dev
 */
public class Main {

    public static void main(String[] args) {
        UserService us = new UserService();
        CompanyService cs = new CompanyService();
        LaboralExperience laboralExperience = new LaboralExperience("enuadadasnoaa", "madrid", false, "trabajoso", 20, 29);
        AcademicInfo academicInfo = new AcademicInfo("aguaadsadsdsda", 27, 31, "currentia", "meanscore");
        User u = new User("pocholito", "eyehuasca", 0101012, "algo@algo", "contraseña");
        JobOffer jobOffer = new JobOffer("titaaudlo", 2333, "detalles", true, "locations", 2, 999, 0);
        Company co = new Company("cooocoteriassss", "descripcion", "coco4laif");
        Skill skill = new Skill("gaaalletonnnnn");
//us.removeUser(u);

        //us.createUser(u);
        us.getUser("coco");
        cs.createCompany(co);
        us.addAcademicInfo(u, academicInfo);
        us.addJobExperience(u, laboralExperience);
        us.addJobExperience(u, laboralExperience, co); 
        us.addSkill(u, skill);
        us.addSkill(u, "paaatatonnnnnnn");


    }
}
