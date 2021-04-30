package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

//Serviço
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
	
	  public CarroDTO getCarroById(Long id) {
	    Optional<Carro> carro = rep.findById(id);
        return carro.map(CarroDTO::create).orElseThrow(() -> new domain.ObjectNotFoundException("Carro não encontrado"));
	}
	

	public List<CarroDTO> getCarrosbyTipo(String tipo) {
		List<Carro> carros  = rep.findByTipo(tipo);
		List<CarroDTO> list  = new ArrayList();		
		
		for(Carro c : carros) {
			list.add(new CarroDTO(c));
		}
		return list;		
	}
	
	public CarroDTO insert(Carro carro) {
		Assert.isNull((carro.getId()), "Não foi possivel inserir o registro");
		return CarroDTO.create(rep.save(carro));
		
	}	
	
	public CarroDTO update(Carro carro, Long id) {
		Assert.notNull(id, "Não foi possivel atualizar o registro");
		
		//Busca Carro no banco de dados
		Optional <Carro> optional = rep.findById(id);
		if (optional.isPresent()) {
		//Copiar as propriedades
		Carro db = optional.get();
		db.setNome(carro.getNome());
		db.setTipo(carro.getTipo());
		System.out.println("Carro id:" + db.getId());
		
		//Atualizar o carro
		rep.save(db);
		
		return CarroDTO.create(db);
		}else{
		
		 throw new RuntimeException("Não foi possivel  atualizar o registro");
		}
	}	
	
	public void delete(Long id) {
	      rep.deleteById(id);
	}
}
