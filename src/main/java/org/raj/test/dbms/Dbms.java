package org.raj.test.dbms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.raj.test.model.Data;

public class Dbms {
	private ArrayList<Data> list = new ArrayList<>();
	String sql = null;
	Connection con =null;
	public Dbms() {
		
		String url = "jdbc:mysql://remotemysql.com:3306/TWGJR6N4cw";
		String username = "TWGJR6N4cw";
		String password = "bwQP8xAzFd";
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url, username, password);
			
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(27+" ->"+e);
			e.printStackTrace();
		}
	}
	
	public ArrayList<Data> getAll() {
		list.clear();
		sql = "SELECT * from raj;";
		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs =st.executeQuery(sql);
			while(rs.next()) {
				Data d = new Data();
				d.setId(rs.getInt(1));
				d.setName(rs.getString(2));
				d.setValue(rs.getInt(3));
				list.add(d);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(48+" ->"+e);
			e.printStackTrace();
		}
		return list;
	}
	
	public Data getData(int id) {
		Data d  =new Data();
		sql = "select * from raj where id = "+id;
		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs =st.executeQuery(sql);
			if(rs.next()) {
				d.setId(rs.getInt(1));
				d.setName(rs.getString(2));
				d.setValue(rs.getInt(3));
			}
		} catch (Exception e) {
			System.out.println(67+" ->"+e);
			e.printStackTrace();
		}
		return d;
	}

	public void createData(Data d) {
		sql = "insert into raj values(?,?,?)";
		PreparedStatement st;
		try {
			st = con.prepareStatement(sql);
//			ResultSet rs =st.executeQuery();
			st.setInt(1,d.getId());
			st.setString(2,d.getName());
			st.setInt(3, d.getValue());
			st.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
}
