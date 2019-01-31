
package com.vue2.test.boot.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vue2.test.boot.data.dao.TodoDao;
import com.vue2.test.boot.data.entity.Todo;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

	@Autowired
	private TodoDao todoDao = null;

	public TodoController() {

	}

	@CrossOrigin
	@RequestMapping(value="/todos", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Get all Todo entities.", notes="Get all Todo entities.")
	public ResponseEntity<List<Todo>> getAllTodos() {
		return new ResponseEntity<>(todoDao.findAll(), HttpStatus.OK);
	}

	@CrossOrigin
	@RequestMapping(value="/todos/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Get specified Todo entity by Id.", notes="Get specified Todo entity by Id.")
	public ResponseEntity<Todo> getTodoById(@ApiParam(value="Id of existing Todo entity.", required=true) @PathVariable("id") long id) {
		return new ResponseEntity<>(todoDao.findOne(id), HttpStatus.OK);
	}

	@CrossOrigin
	@RequestMapping(value="/todos", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Create a new Todo entity.", notes="Create a new Todo entity.")
	public ResponseEntity<Todo> addNewTodo(@ApiParam(value="Todo details.", required=true) @RequestBody Todo newTodo) {
		return new ResponseEntity<>(todoDao.save(newTodo), HttpStatus.OK);
	}

	@CrossOrigin
	@RequestMapping(value="/todos/{id}/completed/{status}", method=RequestMethod.PATCH, produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Get specified Todo entity by Id.", notes="Get specified Todo entity by Id.")
	public ResponseEntity<Boolean> toggleCompletedById(@ApiParam(value="Id of existing Todo entity.", required=true) @PathVariable("id") long id,
		@ApiParam(value="'completed'-status", required=true) @PathVariable("status") boolean status) {
		Todo todo = todoDao.findOne(id);
		todo.setCompleted(status);
		todoDao.saveAndFlush(todo);
		return new ResponseEntity<>(todo.isCompleted(), HttpStatus.OK);
	}

	@CrossOrigin
	@RequestMapping(value="/todos/{id}", method=RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Get specified Todo entity by Id.", notes="Get specified Todo entity by Id.")
	public ResponseEntity<Long> deleteTodoById(@ApiParam(value="Id of existing Todo entity.", required=true) @PathVariable("id") long id) {
		todoDao.delete(id);
		return new ResponseEntity<>(id, HttpStatus.OK);
	}

	@CrossOrigin
	@RequestMapping(value="/todos", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Update a existed Todo entity.", notes="Update a existed Todo entity.")
	public ResponseEntity<Todo> UpdateTodoDetails(@ApiParam(value="Todo details.", required=true) @RequestBody Todo todo) {
		return new ResponseEntity<>(todoDao.saveAndFlush(todo), HttpStatus.OK);
	}
}