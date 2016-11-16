/**
 * 
 */
package br.com.brewer.service.exception;

/**
 * @author Silvan de Jesus
 *
 */
public class ImpossivelExcluirEntidadeException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ImpossivelExcluirEntidadeException(String msg){
		super(msg);
	}

}
