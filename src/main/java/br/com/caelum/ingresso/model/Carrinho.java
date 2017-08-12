package br.com.caelum.ingresso.model;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
@Component
public class Carrinho {

	private Set<Ingresso> ingressos = new HashSet<Ingresso>();
	
	public void adicionaIngresso(Ingresso ingresso) {
		ingressos.add(ingresso);
	}

	public Set<Ingresso> getIngressos() {
		return ingressos;
	}

	public void setIngressos(Set<Ingresso> ingressos) {
		this.ingressos = ingressos;
	}
	
	public boolean isSelecionado(Lugar lugar) {
		return ingressos.stream().map(Ingresso::getLugar).anyMatch(lugar::equals);
	}
	
}
