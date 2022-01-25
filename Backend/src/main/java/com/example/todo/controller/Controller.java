package com.example.todo.controller;

import com.example.todo.entities.ToDo;
import com.example.todo.service.ToDoService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    final String org = "http://127.0.0.1:5500";

    @Autowired
    private ToDoService toDoService;

    @GetMapping(value = "/todo")
    @CrossOrigin(origins = org)
    public List<ToDo> getToDos(){
        return toDoService.getAll();
    }

    @PostMapping(value = "/todo")
    @CrossOrigin(origins = org)
    public void saveToDo(@RequestBody String json) throws JSONException {
        toDoService.addTodo(json);
    }

    @DeleteMapping(value = "/todo")
    @CrossOrigin(origins = org)
    public void deleteToDo(@RequestParam long id){
        toDoService.deleteTodo(id);
    }

    @PutMapping(value = "/todo")
    @CrossOrigin(origins = org)
    public void updateToDo(@RequestBody String json) throws JSONException {
        toDoService.updateTodo(json);
    }
}
