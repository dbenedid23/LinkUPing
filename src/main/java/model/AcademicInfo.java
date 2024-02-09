package model;

import jakarta.persistence.*;

@Entity
@Table(name = "InfoAcademica")
public class AcademicInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "titulo", nullable = false)
    private String tittle;
    @Column(name = "Fecha Inicial")
    private int initialDate;
    @Column(name = "Fecha fin")
    private int endDate;
    @Column(name = "current")
    private String current;
    @Column(name = "mean_score")
    private String meanScore;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "institution_id")
    private Institution institution;


    public AcademicInfo(String tittle, int initialDate, int endDate, String current, String meanScore) {
        this.tittle = tittle;
        this.initialDate = initialDate;
        this.endDate = endDate;
        this.current = current;
        this.meanScore = meanScore;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public int getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(int initialDate) {
        this.initialDate = initialDate;
    }

    public int getEndDate() {
        return endDate;
    }

    public void setEndDate(int endDate) {
        this.endDate = endDate;
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    public String getMeanScore() {
        return meanScore;
    }

    public void setMeanScore(String meanScore) {
        this.meanScore = meanScore;
    }

    public AcademicInfo() {
    }



}
