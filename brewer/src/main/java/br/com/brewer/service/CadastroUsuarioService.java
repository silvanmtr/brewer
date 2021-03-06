package br.com.brewer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import br.com.brewer.model.Usuario;
import br.com.brewer.repository.Usuarios;
import br.com.brewer.service.exception.EmailUsuarioJaCadastradaException;
import br.com.brewer.service.exception.SenhaObrigatóriaUsuarioException;


@Service
public class CadastroUsuarioService {

	@Autowired
	private Usuarios usuarios;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Transactional
	public void salvar(Usuario usuario){
		Optional<Usuario> clienteExistente = usuarios.findByEmail(usuario.getEmail());
		
		if (clienteExistente.isPresent()) {
			throw new EmailUsuarioJaCadastradaException("Email já cadastrado");
		}
		
		if(usuario.isNovo() && StringUtils.isEmpty(usuario.getSenha())){
			throw new SenhaObrigatóriaUsuarioException("Senha obrigatória para novo usuário");
		}
		
		if(usuario.isNovo()){
			usuario.setSenha(this.passwordEncoder.encode(usuario.getSenha()));
			usuario.setConfirmacaoSenha(usuario.getSenha());
		}

		usuarios.save(usuario);
	}
}

