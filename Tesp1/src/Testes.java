import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import br.unibh.entidades.Aluno;
import br.unibh.entidades.Professor;
import br.unibh.persistencia.AlunoDAO;
import br.unibh.persistencia.ProfessorDAO;

public class Testes {
	
	@Test
	@Ignore
	public void findAluno() {
		AlunoDAO dao = new AlunoDAO();
		Aluno a = dao.find(200L);
		Assert.assertEquals(a.getNome(), "Jameson Sharpe");
	}
	
	@Test
	@Ignore
	public void insertAluno() {
		AlunoDAO dao = new AlunoDAO();
		Aluno a = new Aluno(null, "Peter P", "22699678951", "12311115", new Date());
		dao.insert(a);
		Aluno b = dao.find("Peter P");
		Assert.assertNotNull(b);
		dao.delete(b);
	}
	
	@Test
	@Ignore
	public void excluirAluno() {
		AlunoDAO dao = new AlunoDAO();
		Aluno a = dao.find(299L);
		dao.delete(a);
		List<Aluno> lista = dao.findAll();
		Assert.assertEquals(lista.size(), 99);
	}

	@Test
	@Ignore
	public void listarAlunos() {
		AlunoDAO dao = new AlunoDAO();
		List<Aluno> lista = dao.findAll();
		Assert.assertEquals(lista.size(), 100);
	}

	@Test
	@Ignore
	public void alterarAluno() {
		AlunoDAO dao = new AlunoDAO();
		Aluno a = dao.find(298L);
		a.setNome("Evaristo Costa");
		dao.update(a);
		Aluno a2 = dao.find(298L);
		Assert.assertEquals(a2.getNome(), "Evaristo Costa");

	}
	
	@Test
	@Ignore
	public void findAlunoByName(){
		AlunoDAO dao = new AlunoDAO();
		Aluno a = dao.find("Jameson Sharpe");
		Assert.assertNotNull(a);
	}

	// TESTES DA CLASSE PROFESSOR

	@Test
	@Ignore
	public void findProfessor() {
		ProfessorDAO daoProf = new ProfessorDAO();
		Professor p = daoProf.find(103L);
		Assert.assertEquals(p.getNome(), "Clementine V. Ryan");
	}

	@Test
	@Ignore
	public void alteraProfessor() {
		ProfessorDAO daoProf = new ProfessorDAO();
		Professor p = daoProf.find(201L);
		p.setNome("Silvio Santos");
		daoProf.update(p);
		Professor p1 = daoProf.find(201L);
		Assert.assertEquals(p1.getNome(), "Silvio Santos");

	}

	@Test
	@Ignore
	public void excluirProfessor() {
		ProfessorDAO daoProf = new ProfessorDAO();
		Professor p = daoProf.find(202L);
		daoProf.delete(p);
		List<Professor> listaprof = daoProf.findAll();
		Assert.assertEquals(listaprof.size(), 99);
	}

	@Test
	@Ignore
	public void findAllProfessor() {
		ProfessorDAO daoProf = new ProfessorDAO();
		List<Professor> listaprof = daoProf.findAll();
		Assert.assertEquals(listaprof.size(), 100);
	}

	@Test
	@Ignore
	public void insereProfessor() {
		ProfessorDAO daoProf = new ProfessorDAO();
		Professor p = new Professor(null, "Magno A", "33389878787", new BigDecimal("30000"));
		daoProf.insert(p);
		Professor p1 = daoProf.find("Magno A");
		Assert.assertNotNull(p1);
		daoProf.delete(p1);
	}
	
	
	@Test
	@Ignore
	public void findProfessorByName(){
		ProfessorDAO daoProf = new ProfessorDAO();
		Professor p = daoProf.find("Ezekiel Cantrell");
		Assert.assertNotNull(p);
	}
	

	
	

}
