package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import conexao.ConexaoFactory;
import dominio.Motorista;

public class MotoristaDAO {
	public void salvar(Motorista motorista) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO funcionario ");
		sql.append("(nome, idade, cpf, rg, matricula, endereco, cnh, tipocnh) ");
		sql.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?) ");
		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, motorista.getNome());
		comando.setInt(2, motorista.getIdade());
		comando.setInt(3, motorista.getCpf());
		comando.setInt(4, motorista.getRg());
		comando.setInt(5, motorista.getMatricula());
		comando.setString(6, motorista.getEndereco());
		comando.setString(7, motorista.getRegistroCnh());
		comando.setString(8, motorista.getCategoriaCnh());
		comando.executeUpdate();
	}
}