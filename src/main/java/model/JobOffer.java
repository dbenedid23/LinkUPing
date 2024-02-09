package model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "JobOffers")
public class JobOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "titulo", nullable = false)
    private String title;
    @Column(name = "salarioMax")
    private int maxSalary;
    @Column(name = "detalles")
    private String details;
    @Column(name = "abierto", nullable = false)
    private boolean open;
    @Column(name = "location", nullable = false)
    private String location;
    @Column(name = "requerimientos")
    private int requiredCandidates;
    @Column(name = "salarioMin")
    private int minSalary;
    @Column(name = "diaDeTrabajo")
    private int workDayType;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "company_id")
    private Company company;
    @OneToMany(mappedBy = "jobOffers", cascade = CascadeType.ALL)
    private List<Candidature> candidature = new ArrayList<>();
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "JobOffer skill",
            joinColumns = @JoinColumn(name = "JobOffer_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private List<Skill> skill = new ArrayList<>();
    public JobOffer() {
    }

    public int getWorkDayType() {
        return workDayType;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Candidature> getCandidature() {
        return candidature;
    }

    public void setCandidature(List<Candidature> candidature) {
        this.candidature = candidature;
    }

    public List<Skill> getSkill() {
        return skill;
    }

    public void setSkill(List<Skill> skill) {
        this.skill = skill;
    }

    public void setWorkDayType(int workDayType) {
        this.workDayType = workDayType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getRequiredCandidates() {
        return requiredCandidates;
    }

    public void setRequiredCandidates(int requiredCandidates) {
        this.requiredCandidates = requiredCandidates;
    }

    public int getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }

    public JobOffer(String title, int maxSalary, String details, boolean open, String location, int requiredCandidates, int minSalary, int WorkDayType) {

        this.title = title;
        this.maxSalary = maxSalary;
        this.details = details;
        this.open = open;
        this.location = location;
        this.requiredCandidates = requiredCandidates;
        this.minSalary = minSalary;
        this.workDayType = WorkDayType;
    }


}
