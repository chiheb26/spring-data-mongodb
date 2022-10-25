package com.global.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.book.entity.Author;
import com.global.book.repository.AuthorRepo;
import com.global.book.repository.CustomAuthorRepo;

@Service
public class AuthorService {

	@Autowired
	private AuthorRepo authorRepo;

	@Autowired
	private CustomAuthorRepo customAuthorRepo;
	
	public Author findById(String id) {
		return authorRepo.findById(id).get();
	}

	
	public List<Author> findAll() {
		return authorRepo.findAll();
	}
	
	public Author insert(Author entity) {
		if(entity.getId()!= null) {
			throw new RuntimeException("ID Is given !");
		}
		return authorRepo.save(entity);
	}
	
	public List<Author> insertAll(List<Author> entities) {

		return authorRepo.saveAll(entities);
	}
	public Author update(Author entity) {
		
		Author author = findById(entity.getId());
		author.setName(entity.getName());
		author.setEmail(entity.getEmail());
		author.setPhone(entity.getPhone());
		
		return authorRepo.save(author);
	}
	public void delete(String id) {
		authorRepo.deleteById(id);
	}
	
	public Author findAuthorByEmail(String email) {
		return authorRepo.findAuthorByEmail(email);
	}
	public Author findAuthorByEmail2(String email) {
		return authorRepo.findAuthorByEmail2(email);
	}
	public 	Author findAuthorByEmailAndPhone(String email,String phone) {
		return authorRepo.findAuthorByEmailAndPhone(email,phone);

	}
	
	public void updateByEmail(String email,String name,String phone) {
		customAuthorRepo.updateByEmail(email, name, phone);
	}

	
}
