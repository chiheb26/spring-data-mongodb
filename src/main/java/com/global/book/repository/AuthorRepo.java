package com.global.book.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.global.book.entity.Author;

@Repository
public interface AuthorRepo extends MongoRepository<Author, String> {
	
	@Query("{email:'?0'}")
	Author findAuthorByEmail(String email);
	@Query(value="{email:'?0'}",fields="{'name':1,'email':1}")
	Author findAuthorByEmail2(String email);
	
	@Query("{email:'?0',phone:'?1'}")
	Author findAuthorByEmailAndPhone(String email,String phone);
	
	long count();
}
