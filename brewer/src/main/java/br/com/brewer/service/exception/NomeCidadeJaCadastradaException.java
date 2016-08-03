/**
 * 
 */
package br.com.brewer.service.exception;

/**
 * @author Silvan de Jesus
 *
 */

public class NomeCidadeJaCadastradaException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public NomeCidadeJaCadastradaException(String message) {
		super(message);
	}

}
