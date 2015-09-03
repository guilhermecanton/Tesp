import java.math.BigDecimal;

import br.unibh.entidades.Professor;
import br.unibh.persistencia.ProfessorDAO;

public class Main {

	public static void main(String[] args) {

		ProfessorDAO dao = new ProfessorDAO();
		Professor p = new Professor(null, "qr", "11111112221", new BigDecimal("30000"));
		dao.insert(p);
		System.out.println("foi");

	}

}
