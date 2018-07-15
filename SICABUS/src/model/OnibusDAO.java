package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import conexao.ConexaoFactory;
import dominio.Onibus;

public class OnibusDAO {
	public void salvar(Onibus onibus) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO onibus ");
		sql.append("(marca, ano, modelo, passageiros, placa, chassi) ");
		sql.append("VALUES (?, ?, ?, ?, ?, ?) ");
		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, onibus.getMarca());
		comando.setInt(2, onibus.getAno());
		comando.setString(3, onibus.getModelo());
		comando.setInt(4, onibus.getQtdPassageiros());
		comando.setString(5, onibus.getPlaca());
		comando.setString(6, onibus.getChassi());
		comando.executeUpdate();
	}
}