package carros;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import domain.Carro;
import domain.CarroDTO;
import domain.CarrosService;
import domain.ObjectNotFoundException;

//Testes unitários Service
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

		CarroDTO c = service.insert(carro);

		assertNotNull(c);

		Long id = c.getId();
		assertNotNull(id);

		// Buscar o objeto
		c = service.getCarroById(id);
		assertNotNull(c);

		assertEquals("Porshe", c.getNome());
		assertEquals("esportivos", c.getTipo());

		// Deletar o objeto
		service.delete(id);

		// Verificar se deletou
		try {
			service.getCarroById(id);
			fail("O carro não foi excluído");
		} catch (ObjectNotFoundException e) {
			// OK
		}
	}

//	
	@Test
	public void testListar() {

		List<CarroDTO> carros = service.getCarros();
		assertEquals(30, carros.size());
	}

}
