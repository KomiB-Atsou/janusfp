/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c353.bicomat.services;

import com.c353.bicomat.entities.Operation;
import com.c353.bicomat.entities.en.TypeOperationEnum;
import com.c353.bicomat.repository.OperationRepository;
import com.c353.bicomat.services.common.impl.DefaultService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author k.atsou
 */
public class OperationService extends DefaultService<Operation, Long> implements IOperationService {

    @Autowired
    private OperationRepository operationRepository;

    @Override
    public JpaRepository<Operation, Long> getDao() {
        return operationRepository;
    }

    @Override
    public Operation ajouter(Operation op) {
        super.ajouter(op);
        mettreAJourSoldes(op);
        return op;
    }

    // Méthode à revoir, réétudier et recoder
    private void validerOperationsEchelonnees(Operation op) {
        if (op.getPeriode().isEnCours()) {
            List<Operation> ops = this.lister();
            for (Operation op2 : ops) {
                if(op2.getNombreMoisEchelonnement()!=0){
                    this.mettreAJourSoldes(op2);
                }
            }
        }

    }

    private void mettreAJourSoldes(Operation op) {
        double nouveauSolde = 0;
        if (op.getTypeOperation() == TypeOperationEnum.DEPENSE) {
            nouveauSolde = op.getCompteSourceTresoreriePhysique().getSoldeCourant() - op.getMontant();
            op.getCompteSourceTresoreriePhysique().setSoldeCourant(nouveauSolde);

            nouveauSolde = op.getCompteSourceTresorerieLogique().getSoldeCourant() - op.getMontant();
            op.getCompteSourceTresorerieLogique().setSoldeCourant(nouveauSolde);

            nouveauSolde = op.getCompteDestinationStandard().getSoldeCourant() + op.getMontant();
            op.getCompteDestinationStandard().setSoldeCourant(nouveauSolde);
        }

        if (op.getTypeOperation() == TypeOperationEnum.ENTREE) {

            nouveauSolde = op.getCompteSourceStandard().getSoldeCourant() + op.getMontant();
            op.getCompteSourceStandard().setSoldeCourant(nouveauSolde);

            nouveauSolde = op.getCompteDestinationTresoreriePhysique().getSoldeCourant() - op.getMontant();
            op.getCompteDestinationTresoreriePhysique().setSoldeCourant(nouveauSolde);

            nouveauSolde = op.getCompteDestinationTresorerieLogique().getSoldeCourant() - op.getMontant();
            op.getCompteDestinationTresorerieLogique().setSoldeCourant(nouveauSolde);
        }

        if (op.getTypeOperation() == TypeOperationEnum.VIREMENT) {
            nouveauSolde = op.getCompteSourceTresoreriePhysique().getSoldeCourant() - op.getMontant();
            op.getCompteSourceTresoreriePhysique().setSoldeCourant(nouveauSolde);

            nouveauSolde = op.getCompteSourceTresorerieLogique().getSoldeCourant() - op.getMontant();
            op.getCompteSourceTresorerieLogique().setSoldeCourant(nouveauSolde);

            nouveauSolde = op.getCompteDestinationTresoreriePhysique().getSoldeCourant() + op.getMontant();
            op.getCompteDestinationTresoreriePhysique().setSoldeCourant(nouveauSolde);

            nouveauSolde = op.getCompteDestinationTresorerieLogique().getSoldeCourant() + op.getMontant();
            op.getCompteDestinationTresorerieLogique().setSoldeCourant(nouveauSolde);
        }
    }

}
