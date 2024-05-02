package com.sip.demoMVC.entities;

import jakarta.persistence.*;

public class Etudiant {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id; 

    @Column(length = 64, unique = true, nullable = false) 
    private String nom; 

    private Integer age; 
    
    public Etudiant(String string, int i)
    {
    	
    }
    

	public Integer getId() { 	
		return id; 
	} 
	
	public void setId(Integer id) { 
		this.id = id; 
	} 
	
	public String getNom() { 
		return nom; 
	} 
	
	public void setNom(String nom) { 
		this.nom = nom; 
	} 
	
	public Integer getAge() { 
		return age; 
	} 
	
	public void setAge(Integer age) { 
		this.age = age; 
	}
	
}
