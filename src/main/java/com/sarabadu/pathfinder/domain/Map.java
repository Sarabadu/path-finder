package com.sarabadu.pathfinder.domain;

import java.util.ArrayList;
import java.util.List;

public class Map {

    private Node[][] nodeMap;
    private Integer  maxLineIndex;
    private Integer  maxColsIndex;
    private Node     startNode;
    private Node     endNode;

    public Map(String stringMap) {
	String[] lines = stringMap.split("\n");
	char[] chars = lines[0].toCharArray();

	this.maxLineIndex = lines.length - 1;
	this.maxColsIndex = chars.length - 1;

	Node[][] matrix = new Node[lines.length][chars.length];

	for (int i = 0; i < matrix.length; i++) {
	    char[] charsTemp = lines[i].toCharArray();
	    for (int j = 0; j < matrix[i].length; j++) {
		matrix[i][j] = new Node(i, j, charsTemp[j]);
	    }
	}

	this.nodeMap   = matrix;
	this.endNode   = getFirstNodeWhitCharacter('E');
	this.startNode = getFirstNodeWhitCharacter('I');

    }

    public Node[][] getNodeMap() {
	return nodeMap;
    }

    public void setNodeMap(Node[][] nodeMap) {
	this.nodeMap = nodeMap;
    }

    public Node getStartNode() {
	return startNode;

    }

    public Node getEndNode() {
	return endNode;
    }

    private Node getFirstNodeWhitCharacter(char character) {

	for (int i = 0; i < nodeMap.length; i++) {
	    for (int j = 0; j < nodeMap[i].length; j++) {
		if (nodeMap[i][j].getCharacter() == character) {
		    return nodeMap[i][j];
		}
	    }
	}

	return null;
    }

    public Integer distance(Node node1, Node node2) {
	return Math.abs(node1.getX() - node2.getX()) +
	                Math.abs(node1.getY() - node2.getY());
    }

    public List<Node> getPosibleSteps(Node current) {
	List<Node> posibleSteps = new ArrayList<>();

	if (getNorth(current) != null)
	    posibleSteps.add(getNorth(current));
	if (getSouth(current) != null)
	    posibleSteps.add(getSouth(current));
	if (getEast(current) != null)
	    posibleSteps.add(getEast(current));
	if (getWest(current) != null)
	    posibleSteps.add(getWest(current));

	return posibleSteps;
    }

    private Node getWest(Node current) {
	Integer x = Math.max(0, current.getX() - 1);
	Integer y = current.getY();
	Node westNode = nodeMap[y][x];

	if (westNode.equals(current) || !westNode.isPassable()) {
	    return null;
	}
	return westNode;
    }

    private Node getEast(Node current) {
	Integer x = Math.min(maxColsIndex, current.getX() + 1);
	Integer y = current.getY();
	Node eastNode = nodeMap[y][x];

	if (eastNode.equals(current) || !eastNode.isPassable()) {
	    return null;
	}
	return eastNode;
    }

    private Node getSouth(Node current) {
	Integer x = current.getX();
	Integer y = Math.min(maxLineIndex, current.getY() + 1);
	Node southNode = nodeMap[y][x];

	if (southNode.equals(current) || !southNode.isPassable()) {
	    return null;
	}
	return southNode;
    }

    private Node getNorth(Node current) {
	Integer x = current.getX();
	Integer y = Math.max(0, current.getY() - 1);
	Node northNode = nodeMap[y][x];

	if (northNode.equals(current) || !northNode.isPassable()) {
	    return null;
	}
	return northNode;
    }

    public void tracePath() {
	Node current = this.getEndNode();

	while (current.getParent() != null) {

	    current.setCharacter('.');
	    current = current.getParent();
	}
	current.setCharacter('.');
    }

    @Override
    public String toString() {
	String result = "";
	for (int i = 0; i < nodeMap.length; i++) {
	    for (int j = 0; j < nodeMap[i].length; j++) {
		result = result.concat(Character.toString(nodeMap[i][j].getCharacter()));
	    }
	    if (i != nodeMap.length - 1) {

		result = result.concat("\n");
	    }
	}
	return result;

    }

}
