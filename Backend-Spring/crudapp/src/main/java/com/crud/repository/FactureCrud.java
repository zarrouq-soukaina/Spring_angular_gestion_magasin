package com.crud.repository;
import org.springframework.data.repository.CrudRepository;


import com.crud.model.Facture;
public interface FactureCrud extends CrudRepository<Facture, String>{

}
