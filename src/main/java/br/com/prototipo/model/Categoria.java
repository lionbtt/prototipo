package br.com.prototipo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.hateoas.ResourceSupport;

import lombok.Getter;
import lombok.Setter;


@Entity
@SequenceGenerator(name = "sequencia_categoria", sequenceName = "seq_categoria", allocationSize = 1)
public class Categoria extends ResourceSupport implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequencia_categoria")
	@Getter @Setter
	@Column(nullable=false, updatable=false)
	private long categoriaId;
	
	@Getter @Setter
	@Column(nullable=false, unique=true)
	private String descricao;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dataCadastro", nullable=false, updatable = false)
	@Getter
	private Date dataCadastro;
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dataAlteracao", nullable=false)
	@Getter
	private Date dataAlteracao;

}
