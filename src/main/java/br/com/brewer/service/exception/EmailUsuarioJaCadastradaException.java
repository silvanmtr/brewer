/**
 * 
 */
package br.com.brewer.service.exception;

/**
 * @author Silvan de Jesus
 *
 */

public class EmailUsuarioJaCadastradaException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public EmailUsuarioJaCadastradaException(String message) {
		super(message);
	}

}
