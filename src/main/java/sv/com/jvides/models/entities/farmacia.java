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
@Table(name="farmacias")
public class farmacia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY) //para mysql
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "farmacias_Seq")
	@SequenceGenerator(name = "farmacias_Seq", sequenceName = "FARMACIAS_SEQ")
	private Long id; 
	
	@Column(name="NOM_MEDICAMENTO")
	@NotEmpty
	private String NOM_MEDICAMENTO;
	
	@Column(name="NOM_LABORATORIO")
	@NotEmpty
	private String NOM_LABORATORIO;
	
	@Column(name="EST_MEDICAMENTO")
	@NotEmpty
	private String EST_MEDICAMENTO;
	
	@Column(name="CANT_MEDICAMENTO")
	@NotEmpty
	private String  CANT_MEDICAMENTO;
	
	
		
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNOM_MEDICAMENTO() {
		return NOM_MEDICAMENTO;
	}

	public void setNOM_MEDICAMENTO(String nOM_MEDICAMENTO) {
		NOM_MEDICAMENTO = nOM_MEDICAMENTO;
	}

	public String getNOM_LABORATORIO() {
		return NOM_LABORATORIO;
	}

	public void setNOM_LABORATORIO(String nOM_LABORATORIO) {
		NOM_LABORATORIO = nOM_LABORATORIO;
	}

	public String getEST_MEDICAMENTO() {
		return EST_MEDICAMENTO;
	}

	public void setEST_MEDICAMENTO(String eST_MEDICAMENTO) {
		EST_MEDICAMENTO = eST_MEDICAMENTO;
	}

	public String getCANT_MEDICAMENTO() {
		return CANT_MEDICAMENTO;
	}

	public void setCANT_MEDICAMENTO(String cANT_MEDICAMENTO) {
		CANT_MEDICAMENTO = cANT_MEDICAMENTO;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

