/**
 * 
 */
package br.com.brewer.service.exception;

/**
 * @author Silvan de Jesus
 *
 */
public class NomeEstiloJaCadastradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public NomeEstiloJaCadastradoException(String message){
		super(message);
	}

}
