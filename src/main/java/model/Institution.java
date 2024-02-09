package model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "Institucion")
public class Institution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    @Column(name = "nombre" , nullable = false, unique = true)
    private String name;
    @OneToMany(mappedBy = "institution", cascade = CascadeType.ALL)
    private List<AcademicInfo> academicInfos = new ArrayList<>();

    public Institution() {
    }

    public Institution(String name) {

        this.name = name;
    }

    public List<AcademicInfo> getAcademicInfos() {
        return academicInfos;
    }

    public void setAcademicInfos(List<AcademicInfo> academicInfos) {
        this.academicInfos = academicInfos;
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


}
