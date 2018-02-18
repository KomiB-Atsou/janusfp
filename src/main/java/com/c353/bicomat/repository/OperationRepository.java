/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c353.bicomat.repository;

import com.c353.bicomat.entities.Operation;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author k.atsou
 */
public interface OperationRepository extends JpaRepository<Operation, Long> {
    
}
