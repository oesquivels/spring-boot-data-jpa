package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import com.bolsadeideas.springboot.app.models.entity.Chofer;

public interface IChoferService {

	public List<Chofer> findAll();

	public void save(Chofer chofer);

	public Chofer findOne(Long id);

	public void delete(Long id);
	
}
