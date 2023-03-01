package crudapp.model;

import java.util.List;
import java.util.Set;

public class Developer {
    private int id;
    private String firstName;
    private String lastName;
    private Set<Skill> skillList;
    private Specialty specialty;
    private Status status;
    public Developer() {
    }

    public Developer(String firstName, String lastName, Set<Skill> skillList, Specialty specialty) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = Status.ACTIVE;
        this.skillList = skillList;
        this.specialty = specialty;
    }

    public Set<Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(Set<Skill> skillList) {
        this.skillList = skillList;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

}
