package com.crud.repository;

import org.springframework.data.repository.CrudRepository;


import com.crud.model.Fournisseur;
public interface FournisseurCrud extends CrudRepository<Fournisseur, String>{

}