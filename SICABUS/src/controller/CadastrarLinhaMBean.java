package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import dominio.Linha;
import model.LinhaDAO;

@ManagedBean
@SessionScoped
public class CadastrarLinhaMBean {
	private Linha linha; 
	private List<Linha> linhas;
	 
	public CadastrarLinhaMBean() {
		linha = new Linha();
		linhas = new ArrayList<Linha>();
	}
	public String cadastrar() throws SQLException {
		linhas.add(linha);
		new LinhaDAO().salvar(linha);
		linha = new Linha();	
		FacesMessage msg = new FacesMessage("Linha cadastrada com sucesso!");
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage("", msg);
		return "/form_linha.jsf";
	} 
	public Linha getLinha() {
		return linha;
	} 
	public void setLinha(Linha linha) {
		this.linha = linha;
	} 
	public List<Linha> getLinhas() {
		return linhas;
	} 
	public void setLinhas(List<Linha> linhas) {
		this.linhas = linhas;
	}
}