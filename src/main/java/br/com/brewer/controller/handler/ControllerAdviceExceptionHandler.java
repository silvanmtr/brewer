/**
 * 
 */
package br.com.brewer.controller.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.brewer.service.exception.NomeEstiloJaCadastradoException;

/**
 * @author Silvan de Jesus
 *
 */
@ControllerAdvice
public class ControllerAdviceExceptionHandler {
	
	@ExceptionHandler(NomeEstiloJaCadastradoException.class)
	public ResponseEntity<String> handlerNomeEstiloJaCadastradoException(NomeEstiloJaCadastradoException e){
		return ResponseEntity.badRequest().body(e.getMessage());
	}
}
