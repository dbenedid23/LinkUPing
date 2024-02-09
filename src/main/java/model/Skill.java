/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author devo
 */
@Entity
@Table(name = "skills")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nombre", nullable = false)
    private String nombre;
        @ManyToMany(cascade = {CascadeType.ALL, CascadeType.MERGE})
        @JoinTable(
            name = "Skill users",
            joinColumns = @JoinColumn(name = "skill_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
        )
        private List<User> users = new ArrayList<>();
    @ManyToMany(mappedBy = "skill", fetch = FetchType.LAZY)
    private List<JobOffer> jobOffer = new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<JobOffer> getJobOffer() {
        return jobOffer;
    }

    public void setJobOffer(List<JobOffer> jobOffer) {
        this.jobOffer = jobOffer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }





    public Skill(String nombre) {
        this.nombre = nombre;
    }
}
