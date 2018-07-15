package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import dominio.Cobrador;
import dominio.Empresa;
import dominio.Linha;
import dominio.Motorista;
import dominio.Onibus;
import model.OnibusDAO;
 
@ManagedBean
@SessionScoped
public class CadastrarOnibusMBean {
	private Onibus onibus;
	private List<Onibus> listagem;
	 
	public CadastrarOnibusMBean() {
		iniciarValores();
		listagem = new ArrayList<Onibus>();
	}
	private void iniciarValores() {
		onibus = new Onibus();
		onibus.setMotorista(new Motorista());
		onibus.setLinha(new Linha());
		onibus.setEmpresa(new Empresa());
		onibus.setCobrador(new Cobrador());
	}
	public String listar() {
		return "list_onibus.jsf";
	}
	public String cadastrar() throws SQLException {
		listagem.add(onibus);
		new OnibusDAO().salvar(onibus);
		onibus = new Onibus();
		iniciarValores();
		FacesMessage msg = new FacesMessage("Ônibus cadastrado com sucesso!");
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage("", msg);
		return "/form_onibus.jsf";
	}
	public Onibus getOnibus() {
		return onibus;
	}
	public void setOnibus(Onibus onibus) {
		this.onibus = onibus;
	}
	public List<Onibus> getListagem() {
		return listagem;
	}
	public void setListagem(List<Onibus> listagem) {
		this.listagem = listagem;
	}
}