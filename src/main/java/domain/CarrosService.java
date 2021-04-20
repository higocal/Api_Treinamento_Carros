package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import domain.Carro;
import domain.CarroDTO;
import domain.CarrosRepository;

@Service
public class CarrosService {
	@Autowired
	private CarrosRepository rep;

	public List<CarroDTO> getCarros() {
		List<Carro> carros  = rep.findAll();
		List<CarroDTO> list  = new ArrayList();		
		
		for(Carro c : carros) {
			list.add(new CarroDTO(c));
		}
		return list;
	}
	
	public Optional<Carro> getCarrosbyId(Long id) {
		return rep.findById(id);
		
	}
	
	public List<CarroDTO> getCarrosbyTipo(String tipo) {
		List<Carro> carros  = rep.findByTipo(tipo);
		List<CarroDTO> list  = new ArrayList();		
		
		for(Carro c : carros) {
			list.add(new CarroDTO(c));
		}
		return list;		
	}
	
	public Carro insert(Carro carro) {
		Assert.isNull((carro.getId()), "Não foi possivel inserir o registro");
		return rep.save(carro);
		
	}	
	
	public Carro update(Carro carro, Long id) {
		Assert.notNull(id, "Não foi possivel atualizar o registro");
		
		//Busca Carro no banco de dados
		Optional <Carro> optional = getCarrosbyId(id);
		if (optional.isPresent()) {
		//Copiar as propriedades
		Carro db = optional.get();
		db.setNome(carro.getNome());
		db.setTipo(carro.getTipo());
		System.out.println("Carro id:" + db.getId());
		
		//Atualizar o carro
		rep.save(db);
		
		return db;
		}else{
		 throw new RuntimeException("Não foi possivel  atualizar o registro");
		}
	}	
	
	public boolean delete(Long id) {
		Optional <Carro> carro = getCarrosbyId(id);
		if(carro.isPresent()) {
	      rep.deleteById(id);
		  return true;
		}
		  return false;
	}
	
//   public List<Carro> getCarrosFake() {
//		List<Carro> carros = new ArrayList<>();
//		
//		carros.add(new Carro(1L, "Fusca", "esportivo"));
//		carros.add(new Carro(2L, "Gol", "esportivo"));
//		carros.add(new Carro(3L, "Brasilia", "esportivo"));
//
//		return carros;
//   }
}
