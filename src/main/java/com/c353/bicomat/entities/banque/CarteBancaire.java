package com.c353.bicomat.entities.banque;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author KAHANAM Essodjolo
 *
 */
@Entity
public class CarteBancaire {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCarteBancaire;

    @Column
    private String numeroCB;

    @Column
    private String typeCarte;

    @Column
    private Date echeance;

    @Column
    private String codeCrypto;

    @OneToOne
    @JoinColumn(name = "id_client")
    private Client client;

    public Long getIdCarteBancaire() {
        return idCarteBancaire;
    }

    public void setIdCarteBancaire(Long idCarteBancaire) {
        this.idCarteBancaire = idCarteBancaire;
    }

    public String getNumeroCB() {
        return numeroCB;
    }

    public void setNumeroCB(String numeroCB) {
        this.numeroCB = numeroCB;
    }

    public String getTypeCarte() {
        return typeCarte;
    }

    public void setTypeCarte(String typeCarte) {
        this.typeCarte = typeCarte;
    }

    public Date getEcheance() {
        return echeance;
    }

    public void setEcheance(Date echeance) {
        this.echeance = echeance;
    }

    public String getCodeCrypto() {
        return codeCrypto;
    }

    public void setCodeCrypto(String codeCrypto) {
        this.codeCrypto = codeCrypto;
    }

    public CarteBancaire(Long idCarteBancaire, String numeroCB, String typeCarte, Date echeance, String codeCrypto) {
        super();
        this.idCarteBancaire = idCarteBancaire;
        this.numeroCB = numeroCB;
        this.typeCarte = typeCarte;
        this.echeance = echeance;
        this.codeCrypto = codeCrypto;
    }

    public CarteBancaire() {
        super();
    }

}
