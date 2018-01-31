package villages.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Departement {

	@Id
	private Long id;
	private String code;
	private String libelle;

	public Departement(Long id, String code, String libelle) {
		super();
		this.id = id;
		this.code = code;
		this.libelle = libelle;
	}

	public Departement() {
		super();
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

}
