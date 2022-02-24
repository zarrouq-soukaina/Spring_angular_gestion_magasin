package com.crud.repository;

import org.springframework.data.repository.CrudRepository;
import com.crud.model.CommandeProduit;


public interface CommandeProduitCrud extends CrudRepository<CommandeProduit, String> {

}
