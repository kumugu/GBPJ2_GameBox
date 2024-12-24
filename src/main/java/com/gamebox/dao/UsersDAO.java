package com.gamebox.dao;

import java.sql.*;

import com.gamebox.dto.UsersDTO;
import com.gamebox.util.DBConnectionUtil;

public class UsersDAO {

	public UsersDTO getUserByUsername(String username) {
		String sql = "SELECT * FROM USERS WHERE USERNAME = ?";
		UsersDTO user = null;
		
		try (Connection conn = DBConnectionUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
				pstmt.setString(1, username);
			
			try	(ResultSet rs = pstmt.executeQuery()) { 
				if (rs.next()) {
					user = new UsersDTO();
					user.setUserId(rs.getInt("USER_ID"));
					user.setUsername(rs.getString("USERNAME"));
					user.setPassword(rs.getString("PASSWORD"));
					user.setEmail(rs.getString("EMAIL"));
					user.setProfileImage(rs.getString("PROFILE_IMAGE"));
					user.setCreatedAt(rs.getTimestamp("CREATED_AT"));
					user.setRole(rs.getString("ROLE"));
				}
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}
}
