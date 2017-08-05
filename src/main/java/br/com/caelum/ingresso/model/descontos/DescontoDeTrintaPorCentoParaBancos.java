package br.com.caelum.ingresso.model.descontos;

import java.math.BigDecimal;

public class DescontoDeTrintaPorCentoParaBancos implements Desconto {
	
	private BigDecimal percentualDeDesconto = new BigDecimal("0.3");
	
	public BigDecimal aplicarDescontoSobre (BigDecimal precoOriginal) {
		return precoOriginal.subtract(trintaPorCentoSobre(precoOriginal));
	}
	
	public BigDecimal trintaPorCentoSobre(BigDecimal precoOriginal) {
		return precoOriginal.multiply(percentualDeDesconto);
	}
}
