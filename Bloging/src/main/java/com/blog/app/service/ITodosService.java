package com.blog.app.service;

import java.security.Principal;
import java.util.List;

import com.blog.app.entity.Todos;
import com.blog.app.entity.User;

public interface ITodosService {
    
	public List<Todos> getAllTodos(Principal principal);
	
	public Todos getTodosById(Long id);
	
	public Todos addTodos(Todos todo);
	
	public Todos updateTodo(Todos todo,Long id);
	
	public Boolean deleteTodoById(Long id);
	
	public Todos updateTodosStatus(Long id,Integer status);
}
