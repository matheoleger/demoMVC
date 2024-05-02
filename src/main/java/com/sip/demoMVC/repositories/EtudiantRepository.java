package com.sip.demoMVC.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sip.demoMVC.entities.Etudiant;

public interface EtudiantRepository extends CrudRepository<Etudiant,Integer>  {
	public Etudiant findByNom(String nom);
}
