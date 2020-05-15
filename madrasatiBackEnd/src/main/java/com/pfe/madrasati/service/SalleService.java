package com.pfe.madrasati.service;

import java.util.ArrayList;
import java.util.List;

import com.pfe.madrasati.dao.IDao;
import com.pfe.madrasati.model.Salle;

public class SalleService implements IDao<Salle> {
	private List<Salle> salles;

	public SalleService() {
		salles = new ArrayList<Salle>();
	}

	@Override
	public boolean create(Salle o) {
		// TODO Auto-generated method stub
		return salles.add(o);
	}

	@Override
	public boolean delete(Salle o) {
		// TODO Auto-generated method stub
		return salles.remove(o);
	}

	@Override
	public boolean update(Salle o) {
		for (Salle s : salles) {
			if ((s.getId()) == (o.getId())) {
				return true;
			}
		}
		return false;

	}

	@Override
	public Salle findById(int id) {
		for (Salle s : salles) {
			if (s.getId() == id) {
			}
			return s;
		}
		return null;
	}

	@Override
	public List<Salle> findAll() {
		// TODO Auto-generated method stub
		return salles;
	}

}
