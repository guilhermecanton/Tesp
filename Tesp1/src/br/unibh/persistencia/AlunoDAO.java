package br.unibh.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.unibh.persistencia.JDBCUtil;
import br.unibh.entidades.Aluno;

public class AlunoDAO implements DAO<Aluno, Long> {
	public static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public Aluno find(Long id) {
		try {
			PreparedStatement p = JDBCUtil.getConnection().prepareStatement("select * from tb_aluno where id = ?");
			p.setLong(1, id);
			ResultSet res = p.executeQuery();

			if (res.next()) {
				return new Aluno(res.getLong("id"), res.getString("nome"), res.getString("cpf"),
						res.getString("matricula"),
						res.getString("data_aniversario") == null ? null : df.parse(res.getString("data_aniversario")));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection();
		}
		return null;
	}

	public Aluno find(String nome) {
		try {
			PreparedStatement p = JDBCUtil.getConnection()
					.prepareStatement("select * from tb_aluno where nome like ? + '%'");
			p.setString(1, nome);
			ResultSet res = p.executeQuery();

			if (res.next()) {
				return new Aluno(res.getLong("id"), res.getString("nome"), res.getString("cpf"),
						res.getString("matricula"),
						res.getString("data_aniversario") == null ? null : df.parse(res.getString("data_aniversario")));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection();
		}
		return null;
	}

	@Override
	public void insert(Aluno t) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement p = JDBCUtil.getConnection()
					.prepareStatement("insert into tb_aluno (nome, cpf, matricula, data_aniversario) values (?,?,?,?)");
			p.setString(1, t.getNome());
			p.setString(2, t.getCpf());
			p.setString(3, t.getMatricula());
			p.setString(4, df.format(t.getData_aniversario()));
			p.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection();
		}

	}

	@Override
	public void update(Aluno t) {
		try {

			String sql = ("update tb_aluno set nome = ?, " + "cpf = ?, matricula = ?, data_aniversario = ? "
					+ "where id = ?");
			PreparedStatement comando = JDBCUtil.getConnection().prepareStatement(sql);
			comando.setString(1, t.getNome());
			comando.setString(2, t.getCpf());
			comando.setString(3, t.getMatricula());
			if (t.getData_aniversario() == null) {
				comando.setNull(4, Types.NULL);
			} else {
				comando.setString(4, df.format(t.getData_aniversario()));

			}
			comando.setLong(5, t.getId());
			comando.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection();
		}

	}

	@Override
	public void delete(Aluno t) {
		try {
			String sql = ("delete from tb_aluno where id =?");
			PreparedStatement comando = JDBCUtil.getConnection().prepareStatement(sql);
			comando.setLong(1, t.getId());
			comando.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			JDBCUtil.closeConnection();
		}

	}

	@Override
	public List<Aluno> findAll() {
		ArrayList<Aluno> lista = new ArrayList<Aluno>();
		try {
			ResultSet res = JDBCUtil.getConnection().prepareStatement("select * from tb_aluno").executeQuery();
			while (res.next()) {
				lista.add(new Aluno(res.getLong("id"), res.getString("nome"), res.getString("cpf"),
						res.getString("matricula"), res.getString("data_aniversario") == null ? null
								: df.parse(res.getString("data_aniversario"))));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection();
		}
		return lista;
	}

}
