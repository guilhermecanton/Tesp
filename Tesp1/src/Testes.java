import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.unibh.entidades.Aluno;
import br.unibh.entidades.Professor;
import br.unibh.persistencia.AlunoDAO;
import br.unibh.persistencia.ProfessorDAO;

public class Testes {

	@Test
	public void findAluno() {
		AlunoDAO dao = new AlunoDAO();
		Aluno a = dao.find(2L);
		Assert.assertEquals(a.getNome(), "José Pereira");
	}
	
	@Test
	public void insertAluno() {
		AlunoDAO dao = new AlunoDAO();
		Aluno a = new Aluno(null, "Peter P", "22699678951", "12311115", new Date());
		dao.insert(a);
		Aluno b = dao.find("Peter P");
		Assert.assertNotNull(b);
		dao.delete(b);
	}
	
	@Test
	public void excluirAluno() {
		AlunoDAO dao = new AlunoDAO();
		Aluno a = dao.find(8L);
		dao.delete(a);
		List<Aluno> lista = dao.findAll();
		Assert.assertEquals(lista.size(), 102);
	}

	@Test
	public void listarAlunos() {
		AlunoDAO dao = new AlunoDAO();
		List<Aluno> lista = dao.findAll();
		Assert.assertEquals(lista.size(), 103);
	}

	@Test
	public void alterarAluno() {
		AlunoDAO dao = new AlunoDAO();
		Aluno a = dao.find(8L);
		a.setNome("Evaristo Costa");
		dao.update(a);
		Aluno a2 = dao.find(8L);
		Assert.assertEquals(a2.getNome(), "Evaristo Costa");

	}

	// TESTES DA CLASSE PROFESSOR

	@Test
	public void findProfessor() {
		ProfessorDAO daoProf = new ProfessorDAO();
		Professor p = daoProf.find(3L);
		Assert.assertEquals(p.getNome(), "Carlos Tavares");
	}

	@Test
	public void alteraProfessor() {
		ProfessorDAO daoProf = new ProfessorDAO();
		Professor p = daoProf.find(2L);
		p.setNome("Silvio Santos");
		daoProf.update(p);
		Professor p1 = daoProf.find(2L);
		Assert.assertEquals(p1.getNome(), "Silvio Santos");

	}

	@Test
	public void excluirProfessor() {
		ProfessorDAO daoProf = new ProfessorDAO();
		Professor p = daoProf.find(4L);
		daoProf.delete(p);
		List<Professor> listaprof = daoProf.findAll();
		Assert.assertEquals(listaprof.size(), 103);
	}

	@Test
	public void findAllProfessor() {
		ProfessorDAO daoProf = new ProfessorDAO();
		List<Professor> listaprof = daoProf.findAll();
		Assert.assertEquals(listaprof.size(), 104);
	}

	@Test
	public void insereProfessor() {
		ProfessorDAO daoProf = new ProfessorDAO();
		Professor p = new Professor(null, "Magno A", "33389878787", new BigDecimal("30000"));
		daoProf.insert(p);
		Professor p1 = daoProf.find("Magno A");
		Assert.assertNotNull(p1);
		daoProf.delete(p1);
	}
	
	
	

}
