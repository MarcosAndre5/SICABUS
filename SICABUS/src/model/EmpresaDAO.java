package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import conexao.ConexaoFactory;
import java.util.logging.Logger;
import java.util.logging.Level;
import dominio.Empresa;

public class EmpresaDAO {
	public void salvar(Empresa empresa) throws SQLException {
		if (empresa.getCnpj() == null) {
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO empresa ");
			sql.append("(nome, cnpj, telefone, email, cep, endereco) ");
			sql.append("VALUES (?, ?, ?, ?, ?, ?) ");
			Connection conexao = ConexaoFactory.conectar();
			PreparedStatement comando = conexao.prepareStatement(sql.toString());
			comando.setString(1, empresa.getNomeEmpresa());
			comando.setInt(2, empresa.getCnpj());
			comando.setInt(3, empresa.getTelefone());
			comando.setString(4, empresa.getEmail());
			comando.setInt(5, empresa.getCep());
			comando.setString(6, empresa.getEndereco());
			comando.executeUpdate();
		} else {
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE empresa SET ");
			sql.append("nome=?, cnpj=?, telefone=?, email=?, cep=?, endereco=? WHERE cnpj=? ");
			Connection conexao = ConexaoFactory.conectar();
			PreparedStatement comando = conexao.prepareStatement(sql.toString());
			comando.setString(1, empresa.getNomeEmpresa());
			comando.setInt(2, empresa.getCnpj());
			comando.setInt(3, empresa.getTelefone());
			comando.setString(4, empresa.getEmail());
			comando.setInt(5, empresa.getCep());
			comando.setString(6, empresa.getEndereco());
			comando.setInt(7, empresa.getCnpj());
			comando.executeUpdate();
		}
	}
	public List<Empresa> buscar(){
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM empresa ");
			Connection conexao = ConexaoFactory.conectar();
			PreparedStatement comando = conexao.prepareStatement(sql.toString());		
	        ResultSet resultSet = comando.executeQuery();
	        List<Empresa> empresas = new ArrayList<>();
	        while(resultSet.next()){
	            Empresa empresa = new Empresa();
	            empresa.setNomeEmpresa(resultSet.getString("nome"));
	            empresa.setEmail(resultSet.getString("email"));
	            empresa.setCnpj(resultSet.getInt("cnpj"));
	            empresa.setCep(resultSet.getInt("cep"));
	            empresa.setTelefone(resultSet.getInt("telefone"));
	            empresa.setEndereco(resultSet.getString("endereco"));
	            empresas.add(empresa);
	        }
	        return empresas;
	    } catch (SQLException ex) {
	        Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
	        return null;
	    }
	}
	public void deletar(Integer Cnpj) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM empresa ");
		sql.append("WHERE cnpj = ?");
		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setInt(1, Cnpj);
		comando.execute();
	}
}