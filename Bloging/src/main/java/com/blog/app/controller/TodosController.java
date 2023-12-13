package com.blog.app.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.app.entity.Todos;
import com.blog.app.entity.User;
import com.blog.app.service.ITodosService;

@RestController
@RequestMapping("/api/todos")
public class TodosController {

	@Autowired
	private ITodosService todoService;
	
	// to add todo
	@PostMapping("")
	public ResponseEntity<Todos> addTodo(@RequestBody Todos todo){
		ResponseEntity<Todos> response = new ResponseEntity<Todos>(this.todoService.addTodos(todo),HttpStatus.CREATED);
		return response;
	}

	// Get ALl todos
	@GetMapping("")
	public ResponseEntity<List<Todos>> getAllTodosOfLoggedInUser(Principal principal){
		ResponseEntity<List<Todos>> response = new ResponseEntity<List<Todos>>(this.todoService.getAllTodos(principal),HttpStatus.OK);
		return response;
	}
	
    // get Todo by id
	@GetMapping("/{id}")
	public ResponseEntity<Todos> getTodoById(@PathVariable Long id){
		ResponseEntity<Todos> response = new ResponseEntity<Todos>(this.todoService.getTodosById(id),HttpStatus.OK);
		return response;
	}
	
	// update todo by id
	@PutMapping("/{id}")
	public ResponseEntity<Todos> updateTodo(@PathVariable Long id,@RequestBody Todos todo){
		ResponseEntity<Todos> response = new ResponseEntity<Todos>(this.todoService.updateTodo(todo, id),HttpStatus.OK);
		return response;
	}

	// delete todo by id
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteTodo(@PathVariable Long id){
		ResponseEntity<String> response = new ResponseEntity<String>(this.todoService.deleteTodoById(id) + " Todo Deleted Id : "+id,HttpStatus.CREATED);
		return response;
	}

	// make todo complete
	@PutMapping("/{id}/complete")
	public ResponseEntity<Todos> updateTodoComplete(@PathVariable Long id){
		ResponseEntity<Todos> response = new ResponseEntity<Todos>(this.todoService.updateTodosStatus(id, 1),HttpStatus.OK);
		return response;
	}

	// make todo uncomplete
	@PutMapping("/{id}/unComplete")
	public ResponseEntity<Todos> updateTodoUncomplete(@PathVariable Long id){
		ResponseEntity<Todos> response = new ResponseEntity<Todos>(this.todoService.updateTodosStatus(id, 0),HttpStatus.OK);
		return response;
	}
}
