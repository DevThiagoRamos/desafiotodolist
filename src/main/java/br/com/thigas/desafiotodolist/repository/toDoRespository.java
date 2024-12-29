package br.com.thigas.desafiotodolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.thigas.desafiotodolist.entities.toDo;

public interface toDoRespository extends JpaRepository<toDo, Long> {
    
}
