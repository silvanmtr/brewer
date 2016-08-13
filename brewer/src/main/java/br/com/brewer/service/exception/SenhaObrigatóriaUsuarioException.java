/**
 * 
 */
package br.com.brewer.service.exception;

/**
 * @author Silvan de Jesus
 *
 */
public class SenhaObrigatóriaUsuarioException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public SenhaObrigatóriaUsuarioException(String message){
		super(message);
	}

}
