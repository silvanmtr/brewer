/**
 * 
 */
package br.com.brewer.controller.validator;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.brewer.model.Venda;

/**
 * @author Silvan de Jesus
 *
 */

@Component
public class VendaValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Venda.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "cliente.codigo", "", "Selecione um cliente");
		
		Venda venda = (Venda) target;
		
		validarSeInformouApenasHorarioEntrega(errors, venda);
		
		validarSeAdicionouItens(errors, venda);
		
		validarValorTotalNegativo(errors, venda);
	}

	private void validarValorTotalNegativo(Errors errors, Venda venda) {
		if(venda.getValorTotal().compareTo(BigDecimal.ZERO) < 0){
			errors.reject("","Valor Total não pode ser negativo");
		}
	}

	private void validarSeAdicionouItens(Errors errors, Venda venda) {
		if(venda.getItens().isEmpty()){
			errors.reject("", "Adicione ao menos uma cerveja na compra");
		}
	}

	private void validarSeInformouApenasHorarioEntrega(Errors errors, Venda venda) {
		if(venda.getHorarioEntrega() != null && venda.getDataEntrega() == null){
			errors.rejectValue("dataEntrega", "", "Informe uma data da entrega para a venda");
		}
	}

}
