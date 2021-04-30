package domain;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import domain.CarrosService;

@RestController
@RequestMapping("/api/v1/carros")
public class CarrosController {	
	
	@Autowired
	private CarrosService service;
	
	
	@GetMapping()
	public ResponseEntity<List<CarroDTO>> get() {
		return ResponseEntity.ok(service.getCarros());
	//	return new ResponseEntity<>(service.getCarros(), HttpStatus.OK);
	}

	@GetMapping("/id/{id}")	
	public ResponseEntity get(@PathVariable("id") Long id) {
		Optional<Carro> carro = service.getCarrosbyId(id);
		
		if(carro.isPresent()) {
			return ResponseEntity.ok(carro.get());
		}else{
			return ResponseEntity.notFound().build();

		}
				
	}
	
	@GetMapping("/tipo/{tipo}")	
	public ResponseEntity<List<CarroDTO>> getCarrosbyTipo(@PathVariable("tipo") String tipo) {
		List<CarroDTO> carros = service.getCarrosbyTipo(tipo);

		if(carros.isEmpty()) {
			return ResponseEntity.noContent().build();
		}else{
			return ResponseEntity.ok(carros);

		}
	}
	
	@PostMapping
	public ResponseEntity post(@RequestBody Carro carro) {
		
		try {
			Carro c =  service.insert(carro);			
//			URI location = getUri(c.getId());
			return ResponseEntity.created(null).build();
		} catch (Exception ex) {
			return ResponseEntity.badRequest().build();
		}
}
	

//	private URI getUri(Long id) {
//		return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//				.buildAndExpand(id).toUri();
//	}

	@PutMapping("/{id}")
	public ResponseEntity put(@PathVariable("id") Long id, @RequestBody Carro carro) {
		
		try {
			Carro c =  service.update(carro, id);			
//			URL location = getUrl(c.getId());
			return ResponseEntity.ok(c);

		} catch (Exception ex) {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable("id") Long id) {
		boolean ok = service.delete(id); 
		
		if (ok) {	
			return ResponseEntity.ok().build();

		}else{
			return ResponseEntity.notFound().build();
		}
	}
		
	
}