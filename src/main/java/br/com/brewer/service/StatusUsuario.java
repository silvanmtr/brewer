/**
 * 
 */
package br.com.brewer.service;

import br.com.brewer.repository.Usuarios;

/**
 * @author Silvan de Jesus
 *
 */
public enum StatusUsuario {
	ATIVAR {
		@Override
		public void executar(Long[] codigos, Usuarios usuarios) {
			usuarios.findByCodigoIn(codigos).forEach(u -> u.setAtivo(true));
		}
	},

	DESATIVAR {
		@Override
		public void executar(Long[] codigos, Usuarios usuarios) {
			usuarios.findByCodigoIn(codigos).forEach(u -> u.setAtivo(false));
		}
	};

	public abstract void executar(Long[] codigos, Usuarios usuarios);

}
