package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDao {
	
	private static String insertData = "insert into studentInfo values (?,?,?,?,?,?)";
	
	private static String updatedata = "update studentInfo set total_marks_gain=? where email_id=?";
	
	private static String deleteData = "delete  from studentinfo WHERE email_id=?;";
	private static String displayData = "SELECT * FROM studentinfo";
	
	public boolean addData(StudentDto1 dto) {
	Connection con  = Service.getConnection();
	try {
		PreparedStatement pstmt = con.prepareStatement(insertData);
		pstmt.setInt(1, 0);
		pstmt.setString(2, dto.getEmailId());
		pstmt.setString(3, dto.getContactNumber());
		pstmt.setString(4, dto.getYearOfPassOut());
		pstmt.setInt(5, dto.getTotalMarks());
		pstmt.setInt(6, dto.getOutOfMarks());
		
		int count = pstmt.executeUpdate();
		
		if (count>0) {
			return true;
		}
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	return false;
		
	}
		public boolean updateData(StudentDto1 dto) {
			Connection con = Service.getConnection();
			
			try {
				PreparedStatement pstmt = con.prepareStatement(updatedata);
			pstmt.setInt(1, dto.getTotalMarks());
			pstmt.setString(2, dto.getEmailId());
			int count = pstmt.executeUpdate();
			
			if (count>0) {
				return true;
			}
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;
		}
		
		public boolean deleteData(StudentDto1 dto) {
			
			Connection con = Service.getConnection();
			
			PreparedStatement pstmt;
			try {
				pstmt = con.prepareStatement(deleteData);
				pstmt.setString(1, dto.getEmailId());
				int count = pstmt.executeUpdate();
				
				if (count>0) {
					return true;
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return false;
			
			
		}
			public ArrayList<StudentDto1> displayData() {
				Connection con = Service.getConnection();
				ArrayList<StudentDto1> arrayList = new ArrayList<StudentDto1>();
				
				try {
					PreparedStatement pstmt = con.prepareStatement(displayData);
					ResultSet rs = pstmt.executeQuery();
				
						
					while(rs.next()) {
						StudentDto1 s = new StudentDto1();
						s.setRollNumber(rs.getInt(1));
						s.setEmailId(rs.getString(2));
						s.setContactNumber(rs.getString(3));
						s.setYearOfPassOut(rs.getString(4));
						s.setTotalMarks(rs.getInt(5));
						s.setOutOfMarks(rs.getInt(6));
						
						
						arrayList.add(s);
						
						
					}
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				return arrayList;
				
			}

}
