package br.com.brewer.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.brewer.model.Cerveja;
import br.com.brewer.model.Origem;
import br.com.brewer.model.Sabor;
import br.com.brewer.repository.Estilos;
import br.com.brewer.service.CadastroCervejaService;

@Controller
public class CervejasController {
	
	private static final Logger logger = LoggerFactory.getLogger(CervejasController.class);

	@Autowired
	private CadastroCervejaService cadastroCervejaService; 
	
	@Autowired
	private Estilos estilos;
	
	@RequestMapping("/cervejas/novo")
	public ModelAndView novo(Cerveja cerveja) {
		ModelAndView mv = new ModelAndView("cerveja/CadastroCerveja");
		mv.addObject("sabores", Sabor.values());
		mv.addObject("estilos", estilos.findAll());
		mv.addObject("origens", Origem.values());
		return mv;
	}
	
	@RequestMapping(value = "/cervejas/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(cerveja);
		}
		
		cadastroCervejaService.salvar(cerveja);
		attributes.addFlashAttribute("mensagem", "Cerveja salva com sucesso!");
		return new ModelAndView("redirect:/cervejas/novo");
}
	
	@RequestMapping("/cervejas/cadastro")
	public String cadastro(){
		return "cerveja/cadastro-produto";
	}
	
	@RequestMapping("/teste/cliente")
	public String cliente(){
		return "cliente/CadastroCliente";
	}
	@RequestMapping("/teste/usuario")
	public String usuario(){
		logger.info("Log de INFO");
		logger.error("Log de ERROR");
		
		return "usuario/CadastroUsuario";
	}
}
