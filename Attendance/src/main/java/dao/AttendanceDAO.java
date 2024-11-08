package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AttendanceDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/attendance_db";
    private String jdbcUsername = "root";
    private String jdbcPassword = "756126";

    // Method to insert a new attendance record
    public void insertAttendance(Attendance attendance) throws SQLException {
        String sql = "INSERT INTO attendance (student_id, date, status) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, attendance.getStudentId());
            pstmt.setString(2, attendance.getDate());
            pstmt.setString(3, attendance.getStatus());
            pstmt.executeUpdate();
        }
    }

    // Method to update an existing attendance record
    public void updateAttendance(Attendance attendance) throws SQLException {
        String sql = "UPDATE attendance SET student_id = ?, date = ?, status = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, attendance.getStudentId());
            pstmt.setString(2, attendance.getDate());
            pstmt.setString(3, attendance.getStatus());
            pstmt.setInt(4, attendance.getId());
            pstmt.executeUpdate();
        }
    }

    // Method to delete an attendance record
    public void deleteAttendance(int id) throws SQLException {
        String sql = "DELETE FROM attendance WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}