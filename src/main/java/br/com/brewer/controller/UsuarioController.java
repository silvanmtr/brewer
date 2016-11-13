/**
 * 
 */
package br.com.brewer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.brewer.controller.page.PageWrapper;
import br.com.brewer.model.Usuario;
import br.com.brewer.repository.Grupos;
import br.com.brewer.repository.Usuarios;
import br.com.brewer.repository.filter.UsuarioFilter;
import br.com.brewer.service.CadastroUsuarioService;
import br.com.brewer.service.StatusUsuario;
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
	
	@Autowired
	private Usuarios usuarios;
	
	@RequestMapping("/novo")
	public ModelAndView novo(Usuario usuario) {
		ModelAndView mv = new ModelAndView("usuario/CadastroUsuario");
		mv.addObject("grupos", grupos.findAll());
		return mv;
	}
	
	@PostMapping( {"/novo", "{\\+d}"} )
	public ModelAndView salvar(@Valid Usuario usuario, BindingResult result, RedirectAttributes attributes) {
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
	
	@GetMapping
	public ModelAndView pesquisar(UsuarioFilter usuarioFilter , BindingResult result
			, @PageableDefault(size = 2) Pageable pageable, HttpServletRequest httpServletRequest) {
		ModelAndView mv = new ModelAndView("/usuario/PesquisaUsuarios");
		mv.addObject("grupos", grupos.findAll());

		PageWrapper<Usuario> paginaWrapper = new PageWrapper<>(usuarios.filtrar(usuarioFilter, pageable)
				, httpServletRequest);
		mv.addObject("pagina", paginaWrapper);
	
		return mv;
	}
	
	@PutMapping("/status")
	@ResponseStatus(HttpStatus.OK)
	public void atualizarStatus(@RequestParam("codigos[]") Long[] codigos, @RequestParam("status") StatusUsuario statusUsuario) {
		cadastroUsuarioService.alterarStatus(codigos, statusUsuario);
	}
	
	@GetMapping("/{codigo}")
	public ModelAndView editar(@PathVariable() Long codigo){
		
		Usuario usuario = usuarios.buscarComGrupos(codigo);
		
		ModelAndView mv = novo(usuario);
		mv.addObject(usuario);
		
		return mv;
	}
	
}
