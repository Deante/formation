package villages.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ville {

	@Id
	private Long id;
	private String code;
	private String libelle;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Ville() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ville(String code, String libelle) {
		super();
		this.code = code;
		this.libelle = libelle;
	}
	
	
}
