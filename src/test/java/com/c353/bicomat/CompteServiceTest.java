/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.c353.bicomat;

import com.c353.bicomat.entities.Compte;
import com.c353.bicomat.services.CompteService;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author k.atsou
 */

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {CompteService.class})
@SpringApplicationConfiguration(classes = BicomatApplication.class)
public class CompteServiceTest {
    
    @Autowired
    private CompteService compteService;
    
    public CompteServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void test(){
        System.out.println("Hello!");
        compteService.hello();
        compteService.ajouter(new Compte());
    }
    
}
