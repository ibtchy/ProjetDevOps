package tn.esprit.spring.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class CategorieProduitdto {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategorieProduit;

    @OneToMany(mappedBy = "categorieProduit")
    @JsonIgnore
    private Set<Produit> produits;
}
