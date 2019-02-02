package com.sarabadu.pathfinder.domain;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class MapTest  {

    @Before
    public void setUp() throws Exception {
    }
    
     @Test
     public void test_constructor_from_string() {
	 
	 Map map = new Map("_E____I\n");
	
//	 Node[][] mapaChar = new Node[1][7];
//	 mapaChar[0][0] =  new Node(0,0,'_');
//	 mapaChar[0][1] =  new Node(0,1,'E');
//	 mapaChar[0][2] =  new Node(0,2,'_');
//	 mapaChar[0][3] =  new Node(0,3,'_');
//	 mapaChar[0][4] =  new Node(0,4,'_');
//	 mapaChar[0][5] =  new Node(0,5,'_');
//	 mapaChar[0][6] =  new Node(0,6,'I');
	
	 assertEquals('_', map.getNodeMap()[0][0].getCharacter());
	assertEquals('E', map.getNodeMap()[0][1].getCharacter());
	assertEquals('_', map.getNodeMap()[0][3].getCharacter());
	assertEquals('I', map.getNodeMap()[0][6].getCharacter());
	
	 map = new Map("_E____I\n"+
			 		   "_9_    ");
	
	
	 assertEquals('_', map.getNodeMap()[1][0].getCharacter());
	assertEquals('9', map.getNodeMap()[1][1].getCharacter());
	assertEquals('_', map.getNodeMap()[0][3].getCharacter());
	assertEquals('I', map.getNodeMap()[0][6].getCharacter());
	

     }
     
     
     @Test
     public void test_get_start_node() {
	 Map map = new Map("_ ____ \n"+
	 		   "_9_I   \n"+
			 "     E ");
	 assertNotNull(map.getStartNode());
	 assertEquals(Integer.valueOf(3),map.getStartNode().getX());
	 assertEquals(Integer.valueOf(1),map.getStartNode().getY());
	 
     }
     
     @Test
     public void test_get_end_node() {
	 Map map = new Map("_ ____ \n"+
	 		   "_9_I   \n"+
			 "     E ");
	 
	 assertNotNull(map.getEndNode());
	 assertEquals(Integer.valueOf(5),map.getEndNode().getX());
	 assertEquals(Integer.valueOf(2),map.getEndNode().getY());
	 
     }
     
     @Test
     public void test_get_posible_steps() {
	 Map map;
	 Node node;
	 List<Node> posibleSteps;
	 
	 map = new Map("123\n"+
	 		   "4I6\n"+
			   "789");
	 
	 node = map.getStartNode();
	 posibleSteps = map.getPosibleSteps(node);
	 assertEquals(4,posibleSteps.size());
	  
	  
	  
	 assertTrue(posibleSteps.contains(new Node(0,1,'2')));
	 assertTrue(posibleSteps.contains(new Node(1,0,'4')));
	 assertTrue(posibleSteps.contains(new Node(1,2,'6')));
	 assertTrue(posibleSteps.contains(new Node(2,1,'8')));
	 
	 map = new Map("123\n"+
	 		   "4I6\n"
			   );
	 
	  node = map.getStartNode();
	 posibleSteps = map.getPosibleSteps(node);
	 assertEquals(3,posibleSteps.size());
	  
	  
	  
	 assertTrue(posibleSteps.contains(new Node(0,1,'2')));
	 assertTrue(posibleSteps.contains(new Node(1,0,'4')));
	 assertTrue(posibleSteps.contains(new Node(1,2,'6')));
	 
	 map = new Map(
	 		   "4I6\n"
			   );
	 
	  node = map.getStartNode();
	 posibleSteps = map.getPosibleSteps(node);
	 assertEquals(2,posibleSteps.size());
	  
	 assertTrue(posibleSteps.contains(new Node(0,0,'4')));
	 assertTrue(posibleSteps.contains(new Node(0,2,'6')));
	
	 map = new Map("23\n"+
	 		   "I6\n"+
			   "89");
	 
	 node = map.getStartNode();
	 posibleSteps = map.getPosibleSteps(node);
	 assertEquals(3,posibleSteps.size());
	  
	  
	  
	 assertTrue(posibleSteps.contains(new Node(0,0,'2')));
	 
	 assertTrue(posibleSteps.contains(new Node(1,1,'6')));
	 assertTrue(posibleSteps.contains(new Node(2,0,'8')));
	
	 
	 map = new Map("12\n"+
	 		   "4I\n"+
			   "78");
	 
	 node = map.getStartNode();
	 posibleSteps = map.getPosibleSteps(node);
	 assertEquals(3,posibleSteps.size());
	  
	  
	  
	 assertTrue(posibleSteps.contains(new Node(0,1,'2')));
	 assertTrue(posibleSteps.contains(new Node(1,0,'4')));
	 assertTrue(posibleSteps.contains(new Node(2,1,'8')));
	
     
     
     
     }

}
