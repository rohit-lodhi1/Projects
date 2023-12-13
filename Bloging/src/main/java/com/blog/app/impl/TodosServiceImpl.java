package com.blog.app.impl;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.app.Exceptions.TodosNotFoundException;
import com.blog.app.entity.Todos;
import com.blog.app.entity.User;
import com.blog.app.repository.ITodosRepository;
import com.blog.app.service.ITodosService;
import com.blog.app.service.IUserService;

@Service
public class TodosServiceImpl implements ITodosService{
	
	@Autowired
	private ITodosRepository todoRepo;
	
	@Autowired
	private IUserService userService;
	
	
	// To Get All the Todos of Logged In user
	@Override
	public List<Todos> getAllTodos(Principal principal) {
		User user = this.userService.findByUserName(principal.getName());
		return this.todoRepo.findByUser(user);
	}

	// To Get the Todo by ID 
	@Override
	public Todos getTodosById(Long id) {
		Todos todo = this.todoRepo.findById(id).orElseThrow(()->new TodosNotFoundException("Todo not found with id : "+id));
			return todo;
	}

	// To ADD the Todo 
	@Override
	public Todos addTodos(Todos todo) {
		return this.todoRepo.save(todo);
	}

	// To Update the Todo by ID 
	@Override
	public Todos updateTodo(Todos todo, Long id) {
		if(this.todoRepo.existsById(id))
			return this.todoRepo.save(todo);
		throw new TodosNotFoundException("Todo not found with id : "+id);
	}

	// To Delete the Todo by ID 
	@Override
	public Boolean deleteTodoById(Long id) {
	
		if(this.todoRepo.existsById(id)){
			this.todoRepo.deleteById(id);
			return true;	
		}
		throw new TodosNotFoundException("Todo not found with id : "+id);
	}

	// To Update the Todo Status 
	@Override
	public Todos updateTodosStatus(Long id, Integer status) {
		Todos todo = this.todoRepo.findById(id).orElseThrow(()->new TodosNotFoundException("Todo Not Found with id : "+id));
			todo.setCompleted(status==1?true:false);
			return this.todoRepo.save(todo);
	}

}
