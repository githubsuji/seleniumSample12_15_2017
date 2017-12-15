package com.myrestservice.service.business;

import java.util.ArrayList;

import com.myrestservice.service.dao.UserDao;
import com.myrestservice.service.model.User;

public class UserService {

	UserDao userObj = new UserDao();
	
	public ArrayList<User> getAllUserDetails() {
        ArrayList<User> userList = userObj.getUserDetails();
        System.out.println("I reached inside service getAllUserDetais");
        return userList;
    }
	
	public ArrayList<User> getSingleUserDetais(String usrid){
		ArrayList<User> user = userObj.getUserDetail(usrid);
		System.out.println("I reached inside service getSingleUserDetais");
		return user;
		
	}
	
	public int  deleteSingleUser(String usrid) {
		int result = userObj.deleteUserDetail(usrid);
		System.out.println("I reached inside service deleteSingleUserDetais");
		return result;
	}
	
	public String addNewUser(User user) {
		int i = userObj.addUser(user);
		if(i>0) {
			return "Inserted Successfully";
		}
		else {
			return "Insertion Failed";
		}
	}
	
	public String updateUser(String id, String name,int age) {
		int i = userObj.updateUser(id, name, age);
		if(i>0) {
			return "Updated Successfully";
		}
		else {
			return "Updation Failed";
		}
	}
	
	public String updateAllUserNames(String name) {
		int i = userObj.updateUserNames(name);
		if(i>0) {
			return "User names updated successfully";
		}
		else {
			return "Updation Failed";
		}
	}
}