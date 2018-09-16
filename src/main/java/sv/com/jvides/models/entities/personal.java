package sv.com.jvides.models.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="personals")
public class personal implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY) //para mysql
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "personals_Seq")
	@SequenceGenerator(name = "personals_Seq", sequenceName = "PERSONALS_SEQ")
	private Long id; 
	
	@Column(name="NOM_PERSONAL")
	@NotEmpty
	private String NOM_PERSONAL;
	
	@Column(name="APE_PERSONAL")
	@NotEmpty
	private String APE_PERSONAL;
	
	@Column(name="DIRECCCION_PERSONAL")
	@NotEmpty
	private String DIRECCION_PERSONAL;
	
	@Column(name="CARGO_PERSONAL")
	@NotEmpty
	private String CARGO_PERSONAL;
		
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNOM_PERSONAL() {
		return NOM_PERSONAL;
	}

	public void setNOM_PERSONAL(String nOM_PERSONAL) {
		NOM_PERSONAL = nOM_PERSONAL;
	}

	public String getAPE_PERSONAL() {
		return APE_PERSONAL;
	}

	public void setAPE_PERSONAL(String aPE_PERSONAL) {
		APE_PERSONAL = aPE_PERSONAL;
	}

	public String getDIRECCION_PERSONAL() {
		return DIRECCION_PERSONAL;
	}

	public void setDIRECCION_PERSONAL(String dIRECCION_PERSONAL) {
		DIRECCION_PERSONAL = dIRECCION_PERSONAL;
	}

	public String getCARGO_PERSONAL() {
		return CARGO_PERSONAL;
	}

	public void setCARGO_PERSONAL(String cARGO_PERSONAL) {
		CARGO_PERSONAL = cARGO_PERSONAL;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}
