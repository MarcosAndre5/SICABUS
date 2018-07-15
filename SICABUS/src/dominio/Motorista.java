package dominio;
public class Motorista extends Cobrador {
	private String registroCnh; 
	private String categoriaCnh;
	 
	public String getRegistroCnh() {
		return registroCnh;
	}
	public void setRegistroCnh(String registroCnh) {
		this.registroCnh = registroCnh;
	}
	public String getCategoriaCnh() {
		return categoriaCnh;
	}
	public void setCategoriaCnh(String categoriaCnh) {
		this.categoriaCnh = categoriaCnh;
	}
}