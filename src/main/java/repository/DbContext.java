/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import model.Subject;

/**
 *
 * @author thunv
 */
public class DbContext {

    private JdbcSQLServerConnection connection;

    public DbContext() {
        this.connection = new JdbcSQLServerConnection();
    }

    public List getSubjects() throws ClassNotFoundException, SQLException {
        Connection cnn = this.connection.getConnection();
        String query = "select * from subjects";
        List<Subject> subjects = new ArrayList<Subject>();
        Statement state = cnn.createStatement();
        ResultSet rs = state.executeQuery(query);
        while (rs.next()) {
            System.out.println(rs.getString("SubjectID"));
            subjects.add(new Subject(rs.getString("SubjectID"), rs.getString("SubjectCode"), rs.getString("SubjectName"), rs.getString("Faculty"), 0));
        }
        return subjects;
    }

    public void createSubject(Subject subject) throws ClassNotFoundException, SQLException {
        Connection cnn = this.connection.getConnection();
        String query = "insert into subjects(SubjectID,SubjectCode,SubjectName,Faculty,Credit) values(?,?,?,?,?)";
        try (PreparedStatement pstmt = cnn.prepareStatement(query);) {
            pstmt.setString(1, subject.getSubjectID());
            pstmt.setString(2, subject.getSubjectCode());
            pstmt.setString(3, subject.getSubjectName());
            pstmt.setString(4, subject.getFaculty());
            pstmt.setString(5, Integer.toString(subject.getCredit()));
            ResultSet rs = pstmt.executeQuery();
        } // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
