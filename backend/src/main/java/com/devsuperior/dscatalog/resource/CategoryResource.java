package com.devsuperior.dscatalog.resource;

import java.util.ArrayList;
import java.util.List;
/** no java List é uma interface. Interface não pode ser instanciada. Deve se instanciar uma classe que implementa uma interface.**/

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dscatalog.entities.Category;
 
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

	@GetMapping
	public ResponseEntity<List<Category>> findAll() {
		List<Category> list = new ArrayList<>();
		list.add(new Category(1L, "Books"));
		list.add(new Category(2L, "Electronics"));
		return ResponseEntity.ok().body(list);
	}
}
