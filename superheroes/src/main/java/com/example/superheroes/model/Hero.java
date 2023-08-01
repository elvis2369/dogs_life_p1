package com.example.superheroes.model;

import jakarta.persistence.*;


@Entity
@Table(name="heroes")
public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String alias;

    private String superpower;

    private int teamid;

    @Override
    public String toString() {
        return "Hero{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", alias='" + alias + '\'' +
                ", superpower='" + superpower + '\'' +
                ", teamid=" + teamid +
                '}';
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "alias", nullable = false)
    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    @Column(name = "superpower", nullable = false)
    public String getSuperpower() {
        return superpower;
    }

    public void setSuperpower(String superpower) {
        this.superpower = superpower;
    }

    @Column(name = "teamid", nullable = false)
    public int getTeamid() {
        return teamid;
    }

    public void setTeamid(int teamid) {
        this.teamid = teamid;
    }
}
