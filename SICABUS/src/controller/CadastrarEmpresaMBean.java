package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List; 
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import dominio.Empresa;
import model.EmpresaDAO;

@ManagedBean
@SessionScoped
public class CadastrarEmpresaMBean {
	private Empresa empresa;
    private List<Empresa> empresas;
    private EmpresaDAO empresaDAO = new EmpresaDAO();
	     
	public CadastrarEmpresaMBean() {
		empresa = new Empresa();
		empresas = new ArrayList<Empresa>();
 	}
	public String cadastrar() throws SQLException {
		empresas.add(empresa);
		empresaDAO.salvar(empresa);
		empresa = new Empresa();	
		FacesMessage msg = new FacesMessage("Empresa cadastrada com sucesso!");
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage("", msg);
		return "/form_empresa.jsf";
	}
	public void listar() {
        empresas = empresaDAO.buscar();
    } 
	public void editar(Empresa emp) {
		empresa = emp;
	}
	public void deletar(Empresa emp) {
		try {
			empresaDAO.deletar(emp.getCnpj());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Empresa getEmpresa() {
		return empresa;
	}    
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}    
	public List<Empresa> getEmpresas() {
		return empresas;
	}   
	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}
}