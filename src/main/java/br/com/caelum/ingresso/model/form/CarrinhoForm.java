package br.com.caelum.ingresso.model.form;

import java.util.Set;
import java.util.stream.Collectors;

import br.com.caelum.ingresso.dao.LugarDao;
import br.com.caelum.ingresso.dao.SessaoDao;
import br.com.caelum.ingresso.model.Ingresso;
import br.com.caelum.ingresso.model.Lugar;
import br.com.caelum.ingresso.model.Sessao;
import br.com.caelum.ingresso.model.descontos.TipoDeIngresso;

public class CarrinhoForm {
	
	private Set<Ingresso> ingressos;
	
	public Set<Ingresso> toIngressos(SessaoDao sessaoDao, LugarDao lugarDao) {
	
		return ingressos.stream().map(ingresso->{
			Sessao sessao =	sessaoDao.findOne(ingresso.getSessao().getId());
			Lugar lugar = lugarDao.findOne(ingresso.getLugar().getId());
			TipoDeIngresso tipo = ingresso.getTipoDeIngresso();
			return new Ingresso(sessao, lugar, tipo);
			}).collect(Collectors.toSet());
	}

	public Set<Ingresso> getIngressos() {
		return ingressos;
	}

	public void setIngressos(Set<Ingresso> ingressos) {
		this.ingressos = ingressos;
	}


}
