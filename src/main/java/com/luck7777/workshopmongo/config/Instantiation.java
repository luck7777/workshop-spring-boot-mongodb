package com.luck7777.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.luck7777.workshopmongo.domain.Post;
import com.luck7777.workshopmongo.domain.User;
import com.luck7777.workshopmongo.dto.AuthorDTO;
import com.luck7777.workshopmongo.repository.PostRepository;
import com.luck7777.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("20/10/2020"), "Partiu Viagem!", "Vou viajar para Bahia, abraços", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("25/10/2020"), "Bom dia!", "Acordei feliz hoje.", new AuthorDTO(maria));
			
		postRepository.saveAll(Arrays.asList(post1, post2));
		
	}

}
