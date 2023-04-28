package com.training.school.model;


import javax.persistence.*;

@Entity
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="studentName")
    private String studentName;
    @Column(name="bloodGroup")
    private String bloodGroup;
    @Column(name="course")
    private String course;
    @Column(name="emailId")
    private String emailId;
    public Student(){

    }
    public Student(String studentName,String bloodGroup,String course,String emailId){
        this.studentName=studentName;
        this.bloodGroup=bloodGroup;
        this.course=course;
        this.emailId=emailId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {

        this.studentName = studentName;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
