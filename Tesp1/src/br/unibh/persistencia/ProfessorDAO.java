package br.unibh.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import br.unibh.entidades.Professor;

public class ProfessorDAO implements DAO<Professor, Long> {

	public Professor find(Long id) {
		try {

			String sql = ("select * from tb_professor where id = ?");
			PreparedStatement comando = JDBCUtil.getConnection().prepareStatement(sql);
			comando.setLong(1, id);
			ResultSet res = comando.executeQuery();
			if (res.next()) {
				return new Professor(res.getLong("id"), res.getString("nome"), res.getString("cpf"),
						res.getBigDecimal("salario"));

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection();
		}

		return null;
	}
	
	public Professor find(String nome) {
		try {

			String sql = ("select * from tb_professor where nome like ?");
			PreparedStatement comando = JDBCUtil.getConnection().prepareStatement(sql);
			comando.setString(1, nome + "%");
			ResultSet res = comando.executeQuery();
			if (res.next()) {
				return new Professor(res.getLong("id"), res.getString("nome"), res.getString("cpf"),
						res.getBigDecimal("salario"));

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection();
		}

		return null;
	}

	public void insert(Professor t) {
		try {
			String sql = ("insert into tb_professor (nome, cpf, salario) values (?,?,?)");
			PreparedStatement comando = JDBCUtil.getConnection().prepareStatement(sql);
			comando.setString(1, t.getNome());
			comando.setString(2, t.getCpf());
			comando.setBigDecimal(3, t.getSalario());
			comando.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection();
		}

	}

	public void update(Professor t) {
		try {
			String sql = ("update tb_professor set " + "nome = ?, cpf = ?, salario = ? " + "where id = ?");
			PreparedStatement comando = JDBCUtil.getConnection().prepareStatement(sql);
			comando.setString(1, t.getNome());
			comando.setString(2, t.getCpf());
			comando.setBigDecimal(3, t.getSalario());
			comando.setLong(4, t.getId());
			comando.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection();
		}

	}

	public void delete(Professor t) {
		try {
			String sql = ("delete from tb_professor where id =?");
			PreparedStatement comando = JDBCUtil.getConnection().prepareStatement(sql);
			comando.setLong(1, t.getId());
			comando.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection();
		}

	}

	public List<Professor> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
