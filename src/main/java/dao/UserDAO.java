/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import model.*;

import java.util.List;

/**
 *
 * @author dev
 */
public interface UserDAO {
    void createUser(User u);
    void addSkill(String skillName);
    List<AcademicInfo> getUserAcademicInfo(User u);
    void removeUser(User u);
    User getUser(int id);
    List<Skill> getUserSkills(User u);
    List<Skill> getUserSkillsByName(String name);
    List<Candidature> getUserCandidatures(User u);
    List<User> getUsersByName(String name);
    void updateUser(User u);
    List<LaboralExperience> getUserLaboralExperience(User u);
    User getUserByName(String name);
    User inicioUser(String nombre, String password);
    List<LaboralExperience> getUserLaboralExperience(String name);
    List<AcademicInfo> getUserAcademic(String name);
    
}
