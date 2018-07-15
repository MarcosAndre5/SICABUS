package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import conexao.ConexaoFactory;
import dominio.Cobrador;

public class CobradorDAO {
	public void salvar(Cobrador cobrador) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO funcionario ");
		sql.append("(nome, idade, cpf, rg, matricula, endereco) ");
		sql.append("VALUES (?, ?, ?, ?, ?, ?) ");
		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, cobrador.getNome());
		comando.setInt(2, cobrador.getIdade());
		comando.setInt(3, cobrador.getCpf());
		comando.setInt(4, cobrador.getRg());
		comando.setInt(5, cobrador.getMatricula());
		comando.setString(6, cobrador.getEndereco());
		comando.executeUpdate();
	}
}