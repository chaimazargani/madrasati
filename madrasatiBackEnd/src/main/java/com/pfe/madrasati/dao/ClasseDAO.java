package com.pfe.madrasati.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pfe.madrasati.model.Classe;
@Repository
public interface ClasseDAO extends JpaRepository<Classe,Integer> {


}
