package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import dominio.Motorista;
import model.MotoristaDAO;

@ManagedBean
@SessionScoped
public class CadastrarMotoristaMBean {
	private Motorista motorista; 
	private List<Motorista> motoristas;
	 
	public CadastrarMotoristaMBean() {
		motorista = new Motorista();
		motoristas = new ArrayList<Motorista>();
	}
	public String cadastrar() throws SQLException {
		motoristas.add(motorista);
		new MotoristaDAO().salvar(motorista);
		motorista = new Motorista();	
		FacesMessage msg = new FacesMessage("Motorista cadastrado com sucesso!");
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage("", msg);
		return "/form_motorista.jsf";
	} 
	public Motorista getMotorista() {
		return motorista;
	} 
	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}
	public List<Motorista> getMotoristas() {
		return motoristas;
	} 
	public void setMotoristas(List<Motorista> motoristas) {
		this.motoristas = motoristas;
	}
}