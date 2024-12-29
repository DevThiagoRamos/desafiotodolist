package br.com.thigas.desafiotodolist.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.thigas.desafiotodolist.entities.toDo;
import org.springframework.data.domain.Sort;
import br.com.thigas.desafiotodolist.repository.toDoRespository;

@Service
public class toDoService {

    private toDoRespository respository;
    
    public toDoService(toDoRespository respository) {
        this.respository = respository;
    }
    public List<toDo> create(toDo todo){
        respository.save(todo);
        return list();
    }
    public List<toDo> list(){
        Sort sort = Sort.by("priority").descending().and(
            Sort.by("name").ascending());
        return respository.findAll(sort);
    }
    public List<toDo> update(toDo todo){
        respository.save(todo);
        return list();

    }
    public List<toDo> delete(Long Id){
        respository.deleteById(Id);
        return list();

    }
}
