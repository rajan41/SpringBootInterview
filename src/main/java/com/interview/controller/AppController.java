package com.interview.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.interview.model.Movie;
import com.interview.service.MovieService;
import com.interview.service.UserNotFoundException;


@RestController  
public class AppController {
	
	@Autowired
	MovieService movieService;
	
	@RequestMapping(value = "/")
	public ModelAndView  helloWorld()
	{
		ModelAndView  mav = new ModelAndView();
		System.out.println("my name is kahn");
		mav.setViewName("show");
	    return mav;
	}
	
	@GetMapping("/movie")
	public List<Movie> retriveAllMovie()
	{
	  return movieService.findAll();
	  
	}
	
	@GetMapping("/movie/{id}")
	public Movie retriveMovie(@PathVariable String id)
	{
		Movie movie=null;
		movie=movieService.findOne(id);
	   if(movie ==null)
			try {
				throw new UserNotFoundException("id: "+ id);
			} catch (UserNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	   return movie;
	}
	
	
	@PostMapping("/movie")
	public void createUser(@RequestBody Movie movie)
	{
		String savedMovie=movieService.save(movie);	
		
	}
	
	/****************Delete**********************/
	@DeleteMapping("/movie/{id}")  
	public void deleteUser(@PathVariable String id)  
	{  
		String deletemovie= movieService.deleteById(id);  
		if(deletemovie==null)
			try {
				throw new UserNotFoundException("id: "+ id);
			} catch (UserNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	}  
}
