package com.crud.repository;
import org.springframework.data.repository.CrudRepository;


import com.crud.model.Client;

public interface ClientCrud extends CrudRepository<Client, String> {

}
