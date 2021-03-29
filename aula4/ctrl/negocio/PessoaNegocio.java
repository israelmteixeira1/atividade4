package br.ufg.inf.aula4.ctrl.negocio;

import java.util.Calendar;
import java.util.List;

import br.ufg.inf.aula4.ctrl.exception.PessoaExcetion;
import br.ufg.inf.aula4.model.dao.PessoaDAO;
import br.ufg.inf.aula4.model.entities.Pessoa;

public class PessoaNegocio {


		PessoaDAO dao = new PessoaDAO();
	
		public Pessoa inserir(Pessoa pessoa) throws PessoaExcetion {
			this.validarPessoa(pessoa);
			dao.inserir(pessoa);
			return pessoa;
		}
		
		// READ
		public List<Pessoa> buscaTodos() throws PessoaExcetion{
			return dao.buscaTodos();	
		}
		
		public Pessoa buscaPorId(Integer id) throws PessoaExcetion {
			
			return dao.buscaPorId(id);
		}
		
		
		// UPDATE
		
		public Pessoa alterar(Pessoa pessoa) throws PessoaExcetion {		
			this.validarPessoa(pessoa);
			return dao.alterar(pessoa);
		}
		
		// DELETE
		
		public void excluir(Integer id) throws PessoaExcetion {
			dao.excluir(id);
		}
		
		private void validarPessoa(Pessoa pessoa) throws PessoaExcetion {
			
			if (pessoa.getNmPessoa() == null || pessoa.getNmPessoa().length() == 0) {
				throw new PessoaExcetion("Nome da pessoa é obrigatório.");
			}

			if (pessoa.getCpf().toString().length() != 11) {
				throw new PessoaExcetion("CPF deve ter pelo menos 11 algarismos.");
			}
			
			Calendar calHoje = Calendar.getInstance();
			Calendar calNascimento = Calendar.getInstance();
			calNascimento.setTime(pessoa.getDtNascimento());
			
			if (calHoje.after(calNascimento)) {
				throw new PessoaExcetion("Data de Nascimento deve ser maior que hoje.");
			}

		}
}
