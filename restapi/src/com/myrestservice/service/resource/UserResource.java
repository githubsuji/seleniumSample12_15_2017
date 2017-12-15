package com.myrestservice.service.resource;


import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.myrestservice.service.business.UserService;
import com.myrestservice.service.model.User;

@Path("/users")
public class UserResource {
	UserService usrSrvc = new UserService();
	//User usr = new User();
	
	
    @GET
    @Path("/welcome")
    @Produces(MediaType.TEXT_PLAIN)
    public String welcome() {
        return "Welcome to MyRestService. Service is Ready to serve Resources!";
    }
	// CRUD -- READ operation
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<User> getAllUsers() {
        ArrayList<User> userList = usrSrvc.getAllUserDetails();
        return userList;
    }
    
    // CRUD -- READ operation
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<User> getUserForId(@PathParam("id") String id) {
        ArrayList<User> user = usrSrvc.getSingleUserDetais(id);
        return user;
    }
    
    // CRUD -- DELETE operation
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public int deleteUser(@PathParam("id") String id) {
    	int test = usrSrvc.deleteSingleUser(id);
    	return test;
    }
    
    // CRUD -- CREATE operation
    @POST
    @Path("/")
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String addUser(
    		@FormParam("id") String id,
    		@FormParam("name") String name,
    		@FormParam("age") int age) {
    	User user = new User(id, name, age); 
    	String result = usrSrvc.addNewUser(user);
    	return result;	
    }
    
 // CRUD -- CREATE operation
    @PUT
    @Path("/{id}")
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String updateUser(
    		@PathParam("id") String id,
    		@FormParam("name") String name,
    		@FormParam("age") int age) {
    	User user = new User(id, name, age); 
    	String result = usrSrvc.updateUser(id, name, age);
    	return result;	
    }
    
 // CRUD -- CREATE operation
    @PUT
    @Path("/{id}/{username}")
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String updateUserNames(
    		@PathParam("name") String name,
    		@PathParam("id") String id) {
    	User user = new User(name); 
    	String result = usrSrvc.updateAllUserNames(name);
    	return result;	
    }
	//http://localhost:8080/serviceapi/application.wadl
 }
