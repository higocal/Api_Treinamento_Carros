package domain;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {
	
	@GetMapping
	public String hello() {
		return "Hello  Spring boot";
	}

	@GetMapping("/teste")
	public String teste() {
		return "Teste Hello Spring boot";
	}
	

	@PostMapping()
	public String post() {
		return "Post Hello Spring boot";
	}
	
	@PutMapping()
	public String put() {
		return "Put Hello Spring boot";
	}
	
	@DeleteMapping()
	public String delete() {
		return "Delete Hello Spring boot";
	}

	@GetMapping("/login")
	//parametro na url, Ler parametros via @request Param
	public String login(@RequestParam("login") String login, @RequestParam("senha") String senha) {
		return "Login:" +login + " Senha:" + senha;
	}
	
	@GetMapping("/login/{login}/senha/{senha}")
	//Ler parametros via @path
	public String login1(@PathVariable("login") String login, @PathVariable("senha") String senha) {
		return "Login:" +login + " Senha:" + senha;
	}
	
	@GetMapping("/carros/{id}")
	public String getCarrosById(@PathVariable("id") Long id) {
		return "Carros via Id:" + id;
	}
	
	@GetMapping("/carros/tipo/{tipo}")
	public String getCarrosByTipo(@PathVariable("tipo") String tipo) {
		return "Carros via tipo:" + tipo;
	}
	
	@PostMapping("/login2")
	//post = no body da requisição
	public String login2(@RequestParam("login") String login, @RequestParam("senha") String senha) {
		return "Login:" +login + "  Senha:" + senha;
	}
}
