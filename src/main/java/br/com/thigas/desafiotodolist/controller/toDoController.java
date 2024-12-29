package br.com.thigas.desafiotodolist.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.thigas.desafiotodolist.entities.toDo;
import br.com.thigas.desafiotodolist.service.toDoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/toDos")
public class toDoController {

    private toDoService service;
    
     public toDoController(toDoService service) {
        this.service = service;
    }
    @PostMapping
    List<toDo> create(@RequestBody @Valid toDo todo){
        return service.create(todo);
    }
    @GetMapping
     List<toDo> list(){
        return service.list();
   
    }
    @PutMapping("{id}")
     List<toDo> update(@RequestBody toDo todo){
        return service.update(todo);

    }
    @DeleteMapping("{id}")
     List<toDo> delete(@PathVariable("id") Long Id){
        return service.delete(Id);

   }
}

