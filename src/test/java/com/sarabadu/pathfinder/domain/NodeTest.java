package com.sarabadu.pathfinder.domain;



import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class NodeTest {

    @Before
    public void setUp() throws Exception {
    }
    
    @Test
    public void tes_Node_constructor() {
	Node node = new Node(1,2, 'E');
	
	assertEquals('E',node.getCharacter());
	assertEquals(Integer.valueOf(1),node.getY());
	assertEquals(Integer.valueOf(2),node.getX());
	//assertEquals(TypeEnum.END,node.getType());
	
	node = new Node(1,2, 'I');
	
	assertEquals('I',node.getCharacter());
	assertEquals(Integer.valueOf(1),node.getY());
	assertEquals(Integer.valueOf(2),node.getX());
	//assertEquals(TypeEnum.START,node.getType());
	
	node = new Node(1,2, '_');
	
	assertEquals('_',node.getCharacter());
	assertEquals(Integer.valueOf(1),node.getY());
	assertEquals(Integer.valueOf(2),node.getX());
	//assertEquals(TypeEnum.WALL,node.getType());
	
	node = new Node(1,2, '1');
	
	assertEquals('1',node.getCharacter());
	assertEquals(Integer.valueOf(1),node.getY());
	assertEquals(Integer.valueOf(2),node.getX());
	//assertEquals(TypeEnum.TRAP,node.getType());
	
    }

}
