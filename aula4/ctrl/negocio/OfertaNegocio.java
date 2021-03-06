package br.ufg.inf.aula4.ctrl.negocio;

import java.util.ArrayList;
import java.util.List;

import br.ufg.inf.aula4.ctrl.exception.DisciplinaExection;
import br.ufg.inf.aula4.ctrl.exception.OfertaExcetion;
import br.ufg.inf.aula4.ctrl.exception.ProfessorExcetion;
import br.ufg.inf.aula4.model.dao.OfertaDAO;
import br.ufg.inf.aula4.model.entities.Oferta;

public class OfertaNegocio {


		OfertaDAO dao = new OfertaDAO();
		ProfessorNegocio professorNegocio = new ProfessorNegocio();
		DisciplinaNegocio disciplinaNegocio = new DisciplinaNegocio();
	
		public Oferta inserir(Oferta oferta) throws OfertaExcetion {
			this.validarOferta(oferta);
			dao.inserir(oferta);
			return oferta;
		}
		
		// READ
		public List<Oferta> buscaTodos() throws OfertaExcetion, ProfessorExcetion, DisciplinaExection{
			List<Oferta> ofertas =  new ArrayList<Oferta>();
			for(Oferta o : dao.buscaTodos()) {
				o.setProfessor(professorNegocio.buscaPorId(o.getProfessor().getIdProfessor()));
				o.setDisciplina(disciplinaNegocio.buscaPorId(o.getDisciplina().getIdDisciplina()));
			}
			return ofertas;	
		}
		
		public Oferta buscaPorId(Integer id) throws OfertaExcetion, ProfessorExcetion, DisciplinaExection {
			Oferta oferta = new Oferta();
			oferta.setProfessor(professorNegocio.buscaPorId(oferta.getProfessor().getIdProfessor()));
			oferta.setDisciplina(disciplinaNegocio.buscaPorId(oferta.getDisciplina().getIdDisciplina()));
			return oferta;
		}
		
		
		// UPDATE
		
		public Oferta alterar(Oferta oferta) throws OfertaExcetion {		
			this.validarOferta(oferta);
			return dao.alterar(oferta);
		}
		
		// DELETE
		
		public void excluir(Integer id) throws OfertaExcetion {
			dao.excluir(id);
		}
		
		private void validarOferta(Oferta oferta) throws OfertaExcetion {
			

		}
}
