package com.bolsadeideas.springboot.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.bolsadeideas.springboot.app.models.entity.Chofer;

public interface IChoferDao extends CrudRepository<Chofer, Long> {

}
