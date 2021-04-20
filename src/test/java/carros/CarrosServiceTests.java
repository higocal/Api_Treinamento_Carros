package carros;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import domain.Carro;
import domain.CarroDTO;
import domain.CarrosService;

@RunWith(SpringRunner.class)
@SpringBootTest
@SpringBootConfiguration
public class CarrosServiceTests {
	
	@Mock
	private CarrosService service;
	
	@Test
	public void testInserir() {
	
	Carro carro = new Carro();
	carro.setNome("Ferrari");
	carro.setTipo("Esportivo");
	
	service.insert(carro);
	
//	Carro  c = service.insert(carro);
//	
//	assertNotNull(c);
//	
//	Long id = c.getId();
//	assertNotNull(id);
//
//	
////Buscar Objeto
//	Optional<Carro> op = service.getCarrosbyId(id);
//	assertTrue(op.isPresent());
//	c = op.get();
//	assertEquals("Ferrari", c.getNome());
//	assertEquals("Esportivo", c.getTipo());
//// Deletar
//	service.delete(id);
//	
//	//Verificar se deletou
//
//	assertFalse(service.getCarrosbyId(id).isPresent());
	}
//	
	@Test
	public void testListar() {
		
	List<CarroDTO> carros = service.getCarros();
	assertEquals(30	, carros.size());
	}

}
