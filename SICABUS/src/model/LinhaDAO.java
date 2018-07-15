package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import conexao.ConexaoFactory;
import dominio.Linha;

public class LinhaDAO {
	public void salvar(Linha linha) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO linha ");
		sql.append("(numero, origem, destino) ");
		sql.append("VALUES (?, ?, ?) ");
		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setInt(1, linha.getNumLinha());
		comando.setString(2, linha.getOrigem());
		comando.setString(3, linha.getDestino());
		comando.executeUpdate();
	}
}