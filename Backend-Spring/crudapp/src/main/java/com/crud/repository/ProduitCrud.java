package com.crud.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.crud.model.Produit;


public interface ProduitCrud extends CrudRepository<Produit, String> {

}
