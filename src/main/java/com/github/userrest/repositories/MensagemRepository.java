package com.github.userrest.repositories;

import com.github.userrest.domain.entities.Mensagem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MensagemRepository extends CrudRepository<Mensagem, Long> {


    List<Mensagem> findAll();
}
