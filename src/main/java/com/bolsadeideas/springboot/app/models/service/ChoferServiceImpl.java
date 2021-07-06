package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.app.models.dao.IChoferDao;
import com.bolsadeideas.springboot.app.models.entity.Chofer;

@Service
public class ChoferServiceImpl implements IChoferService {

	@Autowired
	private IChoferDao choferDao;

	@Override
	@Transactional(readOnly = true)
	public List<Chofer> findAll() {
		return (List<Chofer>) choferDao.findAll();
	}

	@Override
	@Transactional
	public void save(Chofer chofer) {
		choferDao.save(chofer);
	}

	@Override
	@Transactional(readOnly = true)
	public Chofer findOne(Long id) {
		return choferDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		choferDao.deleteById(id);
	}

}
