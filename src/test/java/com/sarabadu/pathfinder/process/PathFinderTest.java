package com.sarabadu.pathfinder.process;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.sarabadu.pathfinder.domain.Map;
import com.sarabadu.pathfinder.domain.Node;

public class PathFinderTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public final void testResolveMap() throws Exception {

	PathFinder pathfinder6 = new PathFinder(
	                "_E________\n" +
	                "_        _\n" +
	                "_7_ __ _9_\n" +
	                "_     __ _\n" +
	                "_ ___3  I_");

	String result6 = "_.________\n" +
	                "_...     _\n" +
	                "_7_.__ _9_\n" +
	                "_  ...__ _\n" +
	                "_ ___...._";

	assertEquals(result6, pathfinder6.print());

	PathFinder pathfinder2 = new PathFinder("_E_____________\n" +
	                "_             _\n" +
	                "_ ___________9_\n" +
	                "_   ________  _\n" +
	                "_ _ _         _\n" +
	                "_7_ _______ _6_\n" +
	                "_          __ _\n" +
	                "_ ________5   _\n" +
	                "_ ________ __ _\n" +
	                "_          _  _ \n" +
	                "____________I__");

	System.out.println(pathfinder2.print());
    }

    @Test
    public void test_map4() {
	PathFinder pathfinder5 = new PathFinder(
	                "_E_____\n" +
	                "_ 9  9_\n" +
	                "_ 93 I_");

	String result5 = "_._____\n" +
	                "_....9_\n" +
	                "_ 93.._";

	assertEquals(result5, pathfinder5.print());
    }

    @Test
    public void test_map3() {
	PathFinder pathfinder4 = new PathFinder("_E_____\n" +
	                "_ 9  9_\n" +
	                "_ 3  I_");

	String result4 = "_._____\n" +
	                "_.9  9_\n" +
	                "_....._";

	assertEquals(result4, pathfinder4.print());
    }

    @Test
    public void test_map2() {
	PathFinder pathfinder3 = new PathFinder("_E_____\n" +
	                "_3    _\n" +
	                "_____ _\n" +
	                "_____I_");

	String result3 = "_._____\n" +
	                "_....._\n" +
	                "_____._\n" +
	                "_____._";

	assertEquals(result3, pathfinder3.print());
    }

    @Test
    public void test_map1() {
	PathFinder pathfinder = new PathFinder(
	                "_E________\n" +
	                "_        _\n" +
	                "_7_ __ _9_\n" +
	                "_     __ _\n" +
	                "_ ___   I_");

	String result = "_.________\n" +
	                "_...     _\n" +
	                "_7_.__ _9_\n" +
	                "_  ...__ _\n" +
	                "_ ___...._";

	assertEquals(result, pathfinder.print());
    }

    @Test
    public final void test_node_path_cost() throws Exception {
	PathFinder pathfinder = new PathFinder(
	                "I\n" +
	                                " \n" +
	                                "E");

	Map result = pathfinder.resolve();

	Node[][] nodeMap = result.getNodeMap();

	assertEquals(Integer.valueOf(2), nodeMap[0][0].getCurrentPathCost());
	assertEquals(Integer.valueOf(2), nodeMap[1][0].getCurrentPathCost());
	assertEquals(Integer.valueOf(2), nodeMap[2][0].getCurrentPathCost());

    }

    @Test
    public final void test_node_path_cost_whit_trap() throws Exception {
	PathFinder pathfinder = new PathFinder(
	                "I\n" +
	                                "2\n" +
	                                "E");

	Map result = pathfinder.resolve();

	Node[][] nodeMap = result.getNodeMap();

	assertEquals(Integer.valueOf(2), nodeMap[0][0].getCurrentPathCost());
	assertEquals(Integer.valueOf(4), nodeMap[1][0].getCurrentPathCost());
	assertEquals(Integer.valueOf(4), nodeMap[2][0].getCurrentPathCost());

    }

    @Test
    public final void test_node_path_cost_whit_trap_h() throws Exception {
	PathFinder pathfinder = new PathFinder(
	                "I2E");

	Map result = pathfinder.resolve();

	Node[][] nodeMap = result.getNodeMap();

	assertEquals(Integer.valueOf(2), nodeMap[0][0].getCurrentPathCost());
	assertEquals(Integer.valueOf(4), nodeMap[0][1].getCurrentPathCost());
	assertEquals(Integer.valueOf(4), nodeMap[0][2].getCurrentPathCost());

    }

}
