package com.luck7777.workshopmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luck7777.workshopmongo.domain.Post;
import com.luck7777.workshopmongo.repository.PostRepository;
import com.luck7777.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));		
	}
	
	public List<Post> findByTitle(String text){
		return repo.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date dateMin, Date dateMax){
		dateMax = new Date(dateMax.getTime() + 24 * 60 * 60 * 1000);
		return repo.fullSearch(text, dateMin, dateMax);
	}
}
