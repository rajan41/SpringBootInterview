package com.interview.dao;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.interview.model.Movie;


@Repository
@Transactional
public interface MovieDao extends CrudRepository<Movie, String>{

}
