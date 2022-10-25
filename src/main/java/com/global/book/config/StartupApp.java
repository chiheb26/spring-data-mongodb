package com.global.book.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.global.book.entity.Author;
import com.global.book.repository.AuthorRepo;

@Component
public class StartupApp implements CommandLineRunner{
	
	@Autowired
	private AuthorRepo authorRepo;
	
	@Override
	public void run(String... args) throws Exception {
		if(authorRepo.findAll().isEmpty()) {
			Author author1 = new Author();
			author1.setName("author 1");
			author1.setEmail("email1@mail.com");
			author1.setPhone("1111111111");
			
			Author author2 = new Author();
			author2.setName("author 2");
			author2.setEmail("email2@mail.com");
			author2.setPhone("2222222222");
			
			Author author3 = new Author();
			author3.setName("author 3");
			author3.setEmail("email3@mail.com");
			author3.setPhone("3333333333");
			authorRepo.insert(Arrays.asList(author1,author2,author3));
		}
		
	}

}
