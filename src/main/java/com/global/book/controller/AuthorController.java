package com.global.book.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.global.book.entity.Author;
import com.global.book.service.AuthorService;

@RestController
@RequestMapping("/author")
@Validated
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Author> findById(@PathVariable  String id) {
		return ResponseEntity.ok(authorService.findById(id));
	}
	
	@GetMapping("")
	public ResponseEntity<List<Author>> findAll() {
		return ResponseEntity.ok(authorService.findAll());
	}
	@PostMapping("")
	public ResponseEntity<Author> insert(@RequestBody @Valid Author author) {
		
		return ResponseEntity.ok(authorService.insert(author));
	}
	
	@PutMapping("")
	public ResponseEntity<Author> update(@RequestBody @Valid Author author) {
		return ResponseEntity.ok(authorService.update(author));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Author> delete(@PathVariable String id) {
		authorService.delete(id);
		return ResponseEntity.ok(null);
	}
	@GetMapping("/find-by-email/{email}")
	public ResponseEntity<Author> findAuthorByEmail(@PathVariable @Email String email) {
		return ResponseEntity.ok(authorService.findAuthorByEmail(email));
	}
	@GetMapping("/find-by-email2/{email}")
	public ResponseEntity<Author> findAuthorByEmail2(@PathVariable @Email String email) {
		return ResponseEntity.ok(authorService.findAuthorByEmail2(email));
	}
	@GetMapping("/find-by-email/{email}/{phone}")
	public ResponseEntity<Author> findAuthorByEmailAndPhone(@PathVariable @Email String email ,@PathVariable String phone) {
		return ResponseEntity.ok(authorService.findAuthorByEmailAndPhone(email,phone));
	}
	
	@PutMapping("/custom")
	public ResponseEntity<?> updateByEmail(@RequestParam @Email String email,@RequestParam String name,@RequestParam String phone) {

		authorService.updateByEmail(email, name, phone);
		return ResponseEntity.ok(null);
	}
}
