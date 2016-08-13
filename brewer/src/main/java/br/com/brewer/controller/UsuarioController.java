/**
 * 
 */
package br.com.brewer.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.brewer.model.Usuario;
import br.com.brewer.repository.Grupos;
import br.com.brewer.service.CadastroUsuarioService;
import br.com.brewer.service.exception.EmailUsuarioJaCadastradaException;
import br.com.brewer.service.exception.SenhaObrigatóriaUsuarioException;

/**
 * @author Silvan de Jesus
 *
 */

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private CadastroUsuarioService cadastroUsuarioService;

	@Autowired
	private Grupos grupos;

	@RequestMapping("/novo")
	public ModelAndView novo(Usuario usuario) {
		ModelAndView mv = new ModelAndView("usuario/CadastroUsuario");
		mv.addObject("grupos", grupos.findAll());
		return mv;
	}

	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Usuario usuario, BindingResult result, Model model,
			RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(usuario);
		}

		try {
			cadastroUsuarioService.salvar(usuario);
		} catch (EmailUsuarioJaCadastradaException e) {
			result.rejectValue("email", e.getMessage(), e.getMessage());
			return novo(usuario);
		} catch (SenhaObrigatóriaUsuarioException e) {
			result.rejectValue("senha", e.getMessage(), e.getMessage());
			return novo(usuario);
		}

		attributes.addFlashAttribute("mensagem", "Usuário salvo com sucesso");
		return new ModelAndView("redirect:/usuarios/novo");
	}
}
