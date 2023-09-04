package com.openapi.v1.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openapi.entity.Foo;
import com.openapi.repos.FooRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/foo/v1")
@Tag(name = "Foo Service", description = "the Foo API with description tag annotation")
public class FooController {

	@Autowired
	private FooRepository repo;

	@Operation(summary = "Get all foos")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "found foos", content = {
			@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Foo.class))) }),
			@ApiResponse(responseCode = "404", description = "No Foos found", content = @Content) })
	@GetMapping("/")
	public ResponseEntity<List<Foo>> get() {
		List<Foo> list = repo.getFooList();
		if (list.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@Operation(summary = "Create a foo")
	    @ApiResponses(value = {
	            @ApiResponse(responseCode = "201", description = "foo created", content = { @
	                    Content(mediaType = "application/json", schema = @Schema(implementation = Foo.class))}),
	            @ApiResponse(responseCode = "404", description = "Bad request", content = @Content) })
	@PostMapping("/")
	ResponseEntity<Foo> addFoo(@RequestBody @Valid Foo foo){
		 
		HttpHeaders httpHeaders = new HttpHeaders();
	    httpHeaders.setLocation(linkTo(FooController.class).slash(foo.getId()).toUri());
		try{ 
			repo.add(foo);
		 }catch(Exception exe) {
			 return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		 }
		return new ResponseEntity<>(foo, httpHeaders, HttpStatus.CREATED);
	}
}
