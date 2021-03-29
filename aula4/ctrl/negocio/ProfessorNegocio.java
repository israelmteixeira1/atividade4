package br.ufg.inf.aula4.ctrl.negocio;

import java.util.List;

import br.ufg.inf.aula4.ctrl.exception.ProfessorExcetion;
import br.ufg.inf.aula4.model.dao.ProfessorDAO;
import br.ufg.inf.aula4.model.entities.Professor;

public class ProfessorNegocio {


		ProfessorDAO dao = new ProfessorDAO();
		public Professor inserir(Professor professor) throws ProfessorExcetion {
			this.validarProfessor(professor);
			dao.inserir(professor);
			return professor;
		}
		
		public List<Professor> buscaTodos() throws ProfessorExcetion{
			return dao.buscaTodos();	
		}
		
		public Professor buscaPorId(Integer id) throws ProfessorExcetion {
			
			return dao.buscaPorId(id);
		}
		
		public Professor alterar(Professor professor) throws ProfessorExcetion {		
			this.validarProfessor(professor);
			return dao.alterar(professor);
		}
		
		public void excluir(Integer id) throws ProfessorExcetion {
			dao.excluir(id);
		}
		
		private void validarProfessor(Professor professor) throws ProfessorExcetion {
			if (professor.getPessoa() == null) {
				throw new ProfessorExcetion("É necessário vicular uma pessoa ao professor.");
			}
		}
}
