package com.interview.service;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interview.dao.MovieDao;
import com.interview.model.Movie;

@Service
public class MovieService {

	
	@Autowired
	MovieDao movieDao;

	
	private static List<Movie> users=new ArrayList<Movie>();
	
	public List<Movie> findAll()
	{
		List<Movie> rs =null;
		try {
		 rs= (List<Movie>) movieDao.findAll();
		
			if (rs.isEmpty() != true)
				//moviename = rs.getName();
			System.out.println("Moviename : "+ rs.isEmpty());
			return rs;
		} catch (Exception e) {
			System.out.println("ERROR " + e);
			return rs;
		}
		
	}
	
	
	//method that adds a user in the list 
	public String save(Movie movie)
	{
		String result = null;
		try {
			boolean rst = movieDao.save(movie) != null;
			if (rst) {
				result = "Success";
			}
			return result;
		} catch (Exception e) {
			System.out.println("ERROR " + e);
			return "ERROR";
		}
	}
	
	
	//method that find a particular user from the list
	@SuppressWarnings("unused")
	public Movie findOne(String id)
	{
		String moviename = "";
		Movie rs =null;
		try {
		 rs= movieDao.findById(id).get();
		
			if (rs.getName() != null)
				moviename = rs.getName();
			System.out.println("Moviename : "+ moviename);
		
			
		} catch (Exception e) {
			System.out.println("ERROR " + e);
		}
		return rs;

	}
	
	
	//method that delete a user resource  
	public String deleteById(String id)  
	{  
		String moviename = "";
		boolean rs ;
		try {
		 rs= movieDao.existsById(id);
		
			if (rs == true) { 
				moviename="found";
				movieDao.deleteById(id);
			}else {
				moviename="";
			}    System.out.println("Moviename : "+ moviename);
		
			
		} catch (Exception e) {
			System.out.println("ERROR " + e);
		}
		return moviename;
	}
	
}
