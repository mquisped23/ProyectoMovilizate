/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author andro
 */
public class ReservaDaoTest {
    
    public ReservaDaoTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    

  
    @Test
    public void testValidFechaMenorADos() {
        
        ReservaDao dao = new ReservaDao();
        assertFalse(dao.validFecha("16/12/2022"));
    }
    @Test
    public void testValidFechaMayorADos() {
        
        ReservaDao dao = new ReservaDao();
        assertTrue(dao.validFecha("16/12/2022"));
    }

    @Test
    public void testValidRutIgualABd() {
        ReservaDao dao = new ReservaDao();
        assertFalse(dao.validRut("sadsa2122312"));      
        
    }
    @Test
    public void testValidRutDiferenteABd() {
         ReservaDao dao = new ReservaDao();
        assertTrue(dao.validRut("sadsa2122312"));
    }
    
}
