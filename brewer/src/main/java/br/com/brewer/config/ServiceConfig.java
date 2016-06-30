	/**
 * 
 */
package br.com.brewer.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.brewer.service.CadastroCervejaService;

/**
 * @author Silvan de Jesus
 *
 */
@Configuration
@ComponentScan(basePackageClasses = CadastroCervejaService.class)
public class ServiceConfig {

}
