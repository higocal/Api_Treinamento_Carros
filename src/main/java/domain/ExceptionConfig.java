package domain;

import java.nio.file.AccessDeniedException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javassist.tools.rmi.ObjectNotFoundException;

//Tratamento de erros
@RestControllerAdvice
public class ExceptionConfig {
//extends ResponseEntityExceptionHandler{
	//
	//
	//formartar em json
	//
	//
	//Tratamento de erro quando usuario não encontrar um id para deletar,procurar por exemplo
	@ExceptionHandler({ EmptyResultDataAccessException.class })
	public ResponseEntity errorNotFound(Exception ex) {
		return ResponseEntity.notFound().build();
	}
	//
	//
	//formartar em json
	//
	//
	//Tratamento de erro quando usuario tentar inserir passando um id (Operação nao permitida)
	@ExceptionHandler({ IllegalArgumentException.class })
	public ResponseEntity errorBadRequest(Exception ex) {
		return ResponseEntity.badRequest().build();
	}
	
	//Tratamento de erro quando usuario realizar uma operação nao permitida
	@ExceptionHandler({ HttpRequestMethodNotSupportedException.class })
	public ResponseEntity errorNotAllowed(Exception ex) {
		return new ResponseEntity<> (new Error ("405","Operação nao permitida"), HttpStatus.METHOD_NOT_ALLOWED);
	}
	
	//
	//
	// Entender porque nao esta montando json com a mensagem de erro
	//
	//
	//Tratamento de erro quando usuario sem acesso a uma determinada ação (insert e delete)
	@ExceptionHandler({AccessDeniedException.class})
	public ResponseEntity acessDenied() {
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new Error("403" ,"Acesso negado"));
	}

	//Criar resposta de erro no formato json Error
	class Error {
		public String status;
		public String error;
		
		public Error(String status, String error) {
			this.status = status;
			this.error = error;
		}
	}
	
}
