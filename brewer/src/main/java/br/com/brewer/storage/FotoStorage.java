/**
 * 
 */
package br.com.brewer.storage;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Silvan de Jesus
 *
 */
public interface FotoStorage {

	public String salvarTemporariamente(MultipartFile[] files);
	public byte[] recuperarFotoTemporaria(String nome);
}
