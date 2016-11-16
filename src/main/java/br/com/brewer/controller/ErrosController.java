/**
 * 
 */
package br.com.brewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Silvan de Jesus
 *
 */
@Controller
public class ErrosController {

	@GetMapping("/404")
	public String paginaNaoEncontrada(){
		return "/404";
	}
	
	@GetMapping("/500")
	public String paginaErroServidor(){
		return "/500";
	}
}
