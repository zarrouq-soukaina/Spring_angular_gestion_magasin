package com.crud.repository;

import org.springframework.data.repository.CrudRepository;
import com.crud.model.Commande;


public interface CommandeCrud extends CrudRepository<Commande, String> {

}
