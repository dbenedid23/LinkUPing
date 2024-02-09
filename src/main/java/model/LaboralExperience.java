package model;

import jakarta.persistence.*;
@Entity
@Table(name = "LaboralExperiences")
public class LaboralExperience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Titulo_trabajo", nullable = false)
    private String jobTittle;
    @Column(name = "localización")
    private String location;
    @Column(name = "actual")
    private boolean current;
    @Column(name = "descripcion")
    private String description;
    @Column(name = "fechaInicial")
    private int initDate;
    @Column(name = "FechaFin")
    private int endDate;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "company_id")
    private Company company;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    private User user;

    public LaboralExperience() {
    }

    public LaboralExperience(String jobTittle, String location, boolean current, String description, int initDate, int endDate) {

        this.jobTittle = jobTittle;
        this.location = location;
        this.current = current;
        this.description = description;
        this.initDate = initDate;
        this.endDate = endDate;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJobTittle() {
        return jobTittle;
    }

    public void setJobTittle(String jobTittle) {
        this.jobTittle = jobTittle;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isCurrent() {
        return current;
    }

    public void setCurrent(boolean current) {
        this.current = current;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getInitDate() {
        return initDate;
    }

    public void setInitDate(int initDate) {
        this.initDate = initDate;
    }

    public int getEndDate() {
        return endDate;
    }

    public void setEndDate(int endDate) {
        this.endDate = endDate;
    }
}
