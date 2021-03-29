package br.ufg.inf.aula4.ctrl;

import java.util.List;

import br.ufg.inf.aula4.ctrl.exception.DisciplinaExection;
import br.ufg.inf.aula4.ctrl.exception.OfertaExcetion;
import br.ufg.inf.aula4.ctrl.exception.ProfessorExcetion;
import br.ufg.inf.aula4.ctrl.negocio.OfertaNegocio;
import br.ufg.inf.aula4.model.entities.Oferta;

public class OfertaCtrl {

	OfertaNegocio negocio = new OfertaNegocio();

	public Oferta inserir(Oferta oferta) {
		try {
			oferta = negocio.inserir(oferta);
			System.out.println("Oferta cadastrada com sucesso: " + oferta);
		} catch (OfertaExcetion e) {
			System.out.println("Erro ao tentar cadastrar oferta.");
			System.out.println(e.getMessage());
		}
		return oferta;
	}

	public List<Oferta> buscaTodos() {
		List<Oferta> ofertas = null;
		try {
			ofertas = negocio.buscaTodos();
		} catch (OfertaExcetion e) {
			System.out.println("Erro tentar buscar as ofertas cadastrados.");
			System.out.println(e.getMessage());
		} catch (DisciplinaExection e) {
			System.out.println("Erro tentar buscar as ofertas cadastrados.");
			System.out.println(e.getMessage());
		} catch (ProfessorExcetion e) {
			System.out.println("Erro tentar buscar as ofertas cadastrados.");
			System.out.println(e.getMessage());
		}
		return ofertas;
	}

	public Oferta buscaPorId(Integer id) {
		Oferta oferta = null;
		try {
			oferta = negocio.buscaPorId(id);
		} catch (OfertaExcetion e) {
			System.out.println("Erro tentar buscar oferta do ID: " + id + ".");
			System.out.println(e.getMessage());
		} catch (DisciplinaExection e) {
			System.out.println("Erro tentar buscar oferta do ID: " + id + ".");
			System.out.println(e.getMessage());
		} catch (ProfessorExcetion e) {
			System.out.println("Erro tentar buscar oferta do ID: " + id + ".");
			System.out.println(e.getMessage());
		}
		return oferta;
	}

	public Oferta alterar(Oferta oferta) {
		try {
			oferta = negocio.alterar(oferta);
			System.out.println("Oferta alterado com sucesso: " + oferta);
		} catch (OfertaExcetion e) {
			System.out.println("Erro ao tentar alterar oferta com ID: " + oferta.getIdOferta() + ".");
			System.out.println(e.getMessage());
		}
		return oferta;
	}

	public void excluir(Integer id) {
		try {
			negocio.excluir(id);
			System.out.println("Oferta excluída com sucesso.");
		} catch (OfertaExcetion e) {
			System.out.println("Erro ao tentar excluir a oferta");
			System.out.println(e.getMessage());
		}
	}
}
