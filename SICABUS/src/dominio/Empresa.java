package dominio;
public class Empresa {
	private String nomeEmpresa;  
	private Integer cnpj;
	private int telefone;
	private String email;
	private int cep;
	private String endereco;
	
	public String getNomeEmpresa() { 
		return nomeEmpresa; 
	}   
	public void setNomeEmpresa(String nomeEmpresa) { 
		this.nomeEmpresa = nomeEmpresa; 
	} 
	public Integer getCnpj() {
		return cnpj;
	}
	public void setCnpj(Integer cnpj) {
		this.cnpj = cnpj;
	}
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getCep() {
		return cep;
	}
	public void setCep(int cep) {
		this.cep = cep;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	@Override 
	public String toString() { 
		return nomeEmpresa; 
	}  
}