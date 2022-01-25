package com.example.todo.service;

import com.example.todo.entities.ToDo;
import com.example.todo.repository.Repo;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoService {

    @Autowired
    private Repo repo;

    public List<ToDo> getAll(){
        ArrayList<ToDo> list = new ArrayList<>();
        repo.findAll().forEach(list::add);
        return list;
    }

    public void addTodo(String toDo) throws JSONException {
        JSONObject toAdd = new JSONObject(toDo);
        ToDo td = new ToDo(0, toAdd.getString("name"), toAdd.getBoolean("status"));
        repo.save(td);
    }

    public void deleteTodo(long id){
        repo.deleteById(id);
    }

    public void updateTodo(String toDo) throws JSONException {
        JSONObject toUpdate = new JSONObject(toDo);
        repo.save(new ToDo(toUpdate.getLong("id"), toUpdate.getString("name"), toUpdate.getBoolean("status")));
    }
}
