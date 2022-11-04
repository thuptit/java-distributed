/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author thunv
 */
public class Subject {
    private String SubjectID, SubjectCode, SubjectName,Faculty;
    private int Credit;
    public Subject(){
        
    }

    public Subject(String SubjectID, String SubjectCode, String SubjectName, String Faculty, int Credit) {
        this.SubjectID = SubjectID;
        this.SubjectCode = SubjectCode;
        this.SubjectName = SubjectName;
        this.Faculty = Faculty;
        this.Credit = Credit;
    }

    public String getSubjectID() {
        return SubjectID;
    }

    public void setSubjectID(String SubjectID) {
        this.SubjectID = SubjectID;
    }

    public String getSubjectCode() {
        return SubjectCode;
    }

    public void setSubjectCode(String SubjectCode) {
        this.SubjectCode = SubjectCode;
    }

    public String getSubjectName() {
        return SubjectName;
    }

    public void setSubjectName(String SubjectName) {
        this.SubjectName = SubjectName;
    }

    public String getFaculty() {
        return Faculty;
    }

    public void setFaculty(String Faculty) {
        this.Faculty = Faculty;
    }

    public int getCredit() {
        return Credit;
    }

    public void setCredit(int Credit) {
        this.Credit = Credit;
    }
    
}
