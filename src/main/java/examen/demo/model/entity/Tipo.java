package examen.demo.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tipo")
public class Tipo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipo")
	private Integer id_tipo;

	@Column(name = "nom_tipo", length = 30)
	private String nom_tipo;

	@OneToMany(mappedBy = "tipo", fetch = FetchType.LAZY)
	private List<Plato> platos;

	public Tipo() {
		platos = new ArrayList<>();
	}

	public void addPaciente(Plato plato) {
		plato.setTipo(this);
		this.platos.add(plato);
	}

	public Integer getId_tipo() {
		return id_tipo;
	}

	public void setId_tipo(Integer id_tipo) {
		this.id_tipo = id_tipo;
	}

	public String getNom_tipo() {
		return nom_tipo;
	}

	public void setNom_tipo(String nom_tipo) {
		this.nom_tipo = nom_tipo;
	}

	public List<Plato> getPlatos() {
		return platos;
	}

	public void setPlatos(List<Plato> platos) {
		this.platos = platos;
	}

}
