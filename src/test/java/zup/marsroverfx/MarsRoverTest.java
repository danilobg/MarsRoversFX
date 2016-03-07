/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zup.marsroverfx;

import zup.marsroverfx.MarsRover;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author danilo
 */
public class MarsRoverTest {
    
    public MarsRoverTest() {
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

    /**
     * Test of setGridSize method, of class MarsRover.
     */
    @Test
    public void testSetGridSize() throws Exception {
        System.out.println("setGridSize");
        String position = "";
        MarsRover instance = new MarsRover();
        try{
            instance.setGridSize("5 5");
        }catch(Exception ex){
            assertFalse(true);
        }
        assertTrue(true);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setPosition method, of class MarsRover.
     */
    @Test
    public void testSetPosition() throws Exception {
        System.out.println("setPosition");
        String position = "";
        MarsRover instance = new MarsRover();
        instance.setGridSize("5 5");
        try{
            instance.setPosition("1 2 N");
        }catch(Exception ex){
            assertFalse(true);
        }
        assertTrue(true);
    }

    /**
     * Test of printPosition method, of class MarsRover.
     */
    @Test
    public void testPrintPosition() throws Exception {
        System.out.println("printPosition");
        MarsRover instance = new MarsRover();
        instance.setGridSize("5 5");
        instance.setPosition("1 2 N");
        instance.command("LMLMLMLMM");
        
        try{
            assertTrue("1 3 N".equals(instance.printPosition()));
        }catch(Exception ex){
            assertFalse(true);
        }
        assertTrue(true);    
        
    }

    /**
     * Test of command method, of class MarsRover.
     */
    @Test
    public void testCommand() throws Exception {
        System.out.println("\n\nTeste de comando válido");
        String command = "LMLMLMLMM";
        MarsRover instance = new MarsRover();
        instance.setGridSize("5 5");
        instance.setPosition("1 2 N");
        try{
            instance.command(command);
        }catch(Exception ex){
            assertFalse(true);
        }
        assertTrue(true);
    }

}
