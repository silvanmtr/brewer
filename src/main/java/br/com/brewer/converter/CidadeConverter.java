/**
 * 
 */
package br.com.brewer.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import br.com.brewer.model.Cidade;

/**
 * @author Silvan de Jesus
 *
 */
public class CidadeConverter implements Converter<String, Cidade> {

	@Override
	public Cidade convert(String codigo) {
		if (!StringUtils.isEmpty(codigo)) {
			Cidade cidade = new Cidade();
			cidade.setCodigo(Long.valueOf(codigo));
			return cidade;
		}
		
		return null;
	}

}