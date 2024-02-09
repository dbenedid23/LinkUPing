package model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Candidature")
public class Candidature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nombre", nullable = false, unique = true)
    private String name;
    @Column(name = "Descripción")
    private String description;
    @Column(name = "Estado")
    private int Status;
    @Column(name = "CoverLetter")
    private String coverLetterPath;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "jobOffers_id")
    private JobOffer jobOffers;

    public Candidature() {
    }

    public Candidature(String name, String description, int status, String coverLetterPath) {

        this.name = name;
        this.description = description;
        Status = status;
        this.coverLetterPath = coverLetterPath;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public JobOffer getJobOffers() {
        return jobOffers;
    }

    public void setJobOffers(JobOffer jobOffers) {
        this.jobOffers = jobOffers;
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

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public String getCoverLetterPath() {
        return coverLetterPath;
    }

    public void setCoverLetterPath(String coverLetterPath) {
        this.coverLetterPath = coverLetterPath;
    }
}
