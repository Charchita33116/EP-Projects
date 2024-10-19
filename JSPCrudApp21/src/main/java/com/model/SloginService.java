package com.model;
import java.sql.*;

public class SloginService {
	
	String url = "jdbc:mysql://localhost:3306/klu";
	String uname = "root";
	String pw = "root";
	Connection con =null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public boolean loginMainpage(Slogin s) throws Exception
	{
		con = DriverManager.getConnection(url, uname, pw);
		ps = con.prepareStatement("select count(*) from slogin where username = ? and password = ?");
		ps.setString(1, s.getUsername());
		ps.setString(2, s.getPassword());
		rs = ps.executeQuery();
		if(rs.next())
		{
			if(rs.getInt(1) == 1)
			{
				return true;
			}
			else
			{	
				return false;
			}
		}
		return false;
	}
}
