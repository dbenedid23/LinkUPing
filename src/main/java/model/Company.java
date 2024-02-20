package model;

import jakarta.persistence.*;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Compañia")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nombre", nullable = false, unique = true)
    private String name;
    @Column(name = "contraseña")
    private String password;
    @Column(name = "descripcion")
    private String description;
    @OneToMany (mappedBy = "company", cascade = CascadeType.ALL)
    private List<JobOffer>jobOffers = new ArrayList<>();
    @OneToMany (mappedBy = "company", cascade = CascadeType.ALL)
    private List<LaboralExperience> laboralExperiences = new ArrayList<>();

    public Company() {
    }

    public List<JobOffer> getJobOffers() {
        return jobOffers;
    }

    public void setJobOffers(List<JobOffer> jobOffers) {
        this.jobOffers = jobOffers;
    }

    public List<LaboralExperience> getLaboralExperiences() {
        return laboralExperiences;
    }

    public void setLaboralExperiences(List<LaboralExperience> laboralExperiences) {
        this.laboralExperiences = laboralExperiences;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Company(String name, String description, String password) {

        this.name = name;
        this.description = description;
        this.password = password;
    }

//    public Company(String name, String description) {
//        this.name = name;
//        this.description = description;
//    }

    @Override
    public String toString() {
        return "Company{" + "name=" + name + ", " + description + '}';
    }


}
