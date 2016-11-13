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

	public void salvar(String foto);

	public byte[] recuperar(String foto);
	
	public byte[] recuperarThumbnail(String fotoCerveja);

	public void excluir(String foto);
	
}
