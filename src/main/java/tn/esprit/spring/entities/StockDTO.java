package tn.esprit.spring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StockDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idStock;
	private String libelleStock;
	private Integer qte;
	private Integer qteMin;
	@OneToMany(mappedBy = "stock")
	@JsonIgnore
	private Set<Produit> produits;
	public StockDTO(String libelleStock, Integer qte, Integer qteMin) {
		super();
		this.libelleStock = libelleStock;
		this.qte = qte;
		this.qteMin = qteMin;
	}

	public StockDTO(Long idStock, String libelleStock, Integer qte, Integer qteMin) {
		this.idStock = idStock;
		this.libelleStock = libelleStock;
		this.qte = qte;
		this.qteMin = qteMin;
	}
}

