package com.myrestservice.service.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.myrestservice.service.model.User;

public class UserDao {

	Connection conn= null;
	PreparedStatement pstmt=null;
	ResultSet rs =null;
	DataSource dataSource;
	
	public UserDao() {
		try {
			Context initContext  = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			dataSource = (DataSource)envContext.lookup("jdbc/testdb");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//Function to fetch User details from User.UserDetails table
	
			public ArrayList<User> getUserDetails(){
				
				ArrayList<User> user_list=new ArrayList<User>();
				try {
					conn=dataSource.getConnection();
					String sql1= "select * from User.UserDetails";
					System.out.println(sql1);
					pstmt=conn.prepareStatement(sql1);
					rs=pstmt.executeQuery();
					while(rs.next()) {
						User user = new User();
						user.usrid = rs.getString(1);
						user.usrname = rs.getString(2);
						user.usrage = rs.getInt(3);
						user_list.add(user);
					}
					
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				return user_list;
			}
			
	//Function to fetch  a particular User details from User.UserDetails table
	
			public ArrayList<User> getUserDetail(String usrid){
				
				ArrayList<User> user=new ArrayList<User>();
				try {
					conn=dataSource.getConnection();
					String sql1= "select * from User.UserDetails where usrid='"+usrid+"'";
					System.out.println(sql1);
					pstmt=conn.prepareStatement(sql1);
					rs=pstmt.executeQuery();
					while(rs.next()) {
						User usr = new User();
						usr.usrid = rs.getString(1);
						usr.usrname = rs.getString(2);
						usr.usrage = rs.getInt(3);
						user.add(usr);
					}
					
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				return user;
			}
	
	//Function to delete particular user details from User.UserDetails table
			
			public int  deleteUserDetail(String usrid){
				System.out.println("I reached inside delete dao");
				int result=0;
				try {
					conn=dataSource.getConnection();
					String sql2= "delete from User.UserDetails where usrid='"+usrid+"'";
					System.out.println(sql2);
					pstmt=conn.prepareStatement(sql2);
					result = pstmt.executeUpdate();
					result++;
					System.out.println("value of result is"+result);
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				return result;
			}

			
	//Function to insert User details to User.UserDetails table
			
			public int  addUser(User user){
			int i = 0;
			try {
					conn=dataSource.getConnection();
					String sql3= "insert into User.UserDetails values(?,?,?)";
					
					pstmt=conn.prepareStatement(sql3);
					pstmt.setString(1,user.usrid);
					pstmt.setString(2,user.usrname);
					pstmt.setInt(3,user.usrage);
					pstmt.executeUpdate();
					i++;
					
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				return i;
			}
			
	//Function to Update User details to User.UserDetails table
			
			public int updateUser(String id, String name,int age) {
				int i=0;
				try {
					
					conn = dataSource.getConnection();
					String sql4 = "update User.UserDetails set usrname ='"+ name +"',usrage = "+ age + " where usrid = '"+id+"'";
					System.out.println(sql4);
					pstmt = conn.prepareStatement(sql4);
					pstmt.executeUpdate();
					i++;
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				return i;
			}
			
	//Function to Update User details to User.UserDetails table
			
			public int updateUserNames(String name) {
				int i=0;
				try {
					
					conn = dataSource.getConnection();
					String sql5 = "update User.UserDetails set usrname ='"+ name +"'";
					System.out.println(sql5);
					pstmt = conn.prepareStatement(sql5);
					pstmt.executeUpdate();
					i++;
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				return i;
			}	
	//Function to get Userids into select box of update.html
			
			//showUsrIds()
			public ArrayList<String> showUsrIds(){
				
				ArrayList<String> usr_ids = new ArrayList<String>();
				
				try {
					
					conn = dataSource.getConnection();
					String sql5 = "select usrid from User.UserDetails";
					pstmt = conn.prepareStatement(sql5);
					rs = pstmt.executeQuery();
					while(rs.next()) {
						usr_ids.add(rs.getString(1));
					}
				}
				
				catch(Exception e) {
					e.printStackTrace();
				}
				return usr_ids;
			}
			
				
}
