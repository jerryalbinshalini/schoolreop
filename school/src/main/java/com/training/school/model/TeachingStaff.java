package com.training.school.model;

import javax.persistence.*;

@Entity
@Table(name="teachingstaff")
public class TeachingStaff {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="staffName")
    private String staffName;
    @Column(name="subjectName")
    private String subjectName;
    @Column(name="staffExperience")
    private String staffExperience;



    @Column(name="staffDescription")
    private String staffDescription;
    public TeachingStaff(){

    }
    public TeachingStaff(String staffName,String subjectName,String staffExperience,String staffDescription){
       this.staffName=staffName;
       this.subjectName=subjectName;
       this.staffExperience=staffExperience;
       this.staffDescription=staffDescription;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getStaffExperience() {
        return staffExperience;
    }

    public void setStaffExperience(String staffExperience) {
        this.staffExperience = staffExperience;
    }
    public String getStaffDescription() {
        return staffDescription;
    }

    public void setStaffDescription(String staffDescription) {
        this.staffDescription = staffDescription;
    }
}
