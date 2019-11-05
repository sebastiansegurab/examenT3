package examen.demo.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "plato")
public class Plato {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pla")
	private Integer id_pla;

	@Column(name = "nom_pla", length = 30)
	private String nom_pla;
	
	@Column(name = "pre_pla")
	private float pre_pla;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo")
	private Tipo tipo;

	@OneToMany(mappedBy = "plato", fetch = FetchType.LAZY)
	private List<Pedido> pedidos;

	public Plato() {
		pedidos = new ArrayList<>();
	}

	public Integer getId_pla() {
		return id_pla;
	}

	public void setId_pla(Integer id_pla) {
		this.id_pla = id_pla;
	}

	public String getNom_pla() {
		return nom_pla;
	}

	public void setNom_pla(String nom_pla) {
		this.nom_pla = nom_pla;
	}

	public float getPre_pla() {
		return pre_pla;
	}

	public void setPre_pla(float pre_pla) {
		this.pre_pla = pre_pla;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	


	

}
