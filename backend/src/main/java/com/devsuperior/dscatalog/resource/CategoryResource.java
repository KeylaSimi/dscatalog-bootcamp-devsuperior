package com.devsuperior.dscatalog.resource;

import java.net.URI;
import java.util.List;
/** no java List é uma interface. Interface não pode ser instanciada. Deve se instanciar uma classe que implementa uma interface.**/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devsuperior.dscatalog.dto.CategoryDTO;
import com.devsuperior.dscatalog.services.CategoryService;
 
/**  
 * Annotation: Essa anotação é usada para fazer uma classe como um controlador da web, 
 * que pode lidar com as solicitações do cliente e enviar uma resposta de volta ao cliente. 
 * Esta é uma anotação em nível de classe, que é colocada no topo de sua classe de controlador.
 */
@RestController
/**  
 * Annotation: É uma anotação de nível de método que é especificada em um método de manipulador.
 *  Ele fornece o mapeamento entre o caminho da solicitação e o método do manipulador. 
 *  Ele também oferece suporte a algumas opções avançadas que podem ser usadas para especificar 
 *métodos de tratamento separados para diferentes tipos de solicitação no mesmo URI.
 */
@RequestMapping(value="/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService service;

	@GetMapping
	public ResponseEntity<List<CategoryDTO>> findAll() {
		List<CategoryDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<CategoryDTO> findById(@PathVariable Long id) {
		CategoryDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping
	public ResponseEntity<CategoryDTO> insert(@RequestBody CategoryDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<CategoryDTO> update(@PathVariable Long id, @RequestBody CategoryDTO dto) {
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}	
}
