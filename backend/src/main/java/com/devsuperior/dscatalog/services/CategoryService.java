package com.devsuperior.dscatalog.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dscatalog.dto.CategoryDTO;
import com.devsuperior.dscatalog.entities.Category;
import com.devsuperior.dscatalog.repositories.CategoryRepository;
import com.devsuperior.dscatalog.services.exceptions.EntityNotFoundException;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	@Transactional (readOnly = true)
	public List<CategoryDTO> findAll() {
		List<Category> list = repository.findAll();
		
		return list.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());
		// map: aplica uma função a cada elemento da coleção original, retornando uma nova coleção.
		// filter: retorna uma nova coleção contendo apenas aqueles elementos da coleção que satisfazem um dado predicado.
		// reduce: aplica cumulativamente uma função aos elementos de uma coleção, retornando o resultado final.
		//         pode-se informar, opcionalmente, um valor inicial como parâmetro (necessário para uma coleção vazia).
		// sort: ordena a coleção conforme a função de comparação informada como parâmetro.		
				
		
//		List<CategoryDTO> listDto = new ArrayList<>();
//		for (Category cat : list) {
//			listDto.add(new CategoryDTO(cat));
//		}
		
//		return listDto;
	}

	@Transactional (readOnly = true)	
	public CategoryDTO findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		//Category entity = obj.get(); = sem tratar erro
		Category entity = obj.orElseThrow(() -> new EntityNotFoundException("Entity Not Found")); 
		return new CategoryDTO(entity);
	}

	@Transactional
	public CategoryDTO insert(CategoryDTO dto) {
		Category entity = new Category();
		entity.setName(dto.getName());
		entity = repository.save(entity);
		return new CategoryDTO(entity);
	}
	
}
