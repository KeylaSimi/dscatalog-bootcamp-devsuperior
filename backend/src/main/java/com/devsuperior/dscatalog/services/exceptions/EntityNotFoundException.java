package com.devsuperior.dscatalog.services.exceptions;

public class EntityNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	//  super = é usado para repassar o argumento (msg) de um construdor 
	//para o construtor de uma super classe.
	public EntityNotFoundException (String msg) {
		super(msg);
	}

}
