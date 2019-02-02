package com.sarabadu.pathfinder.domain;

import java.util.Arrays;
import java.util.Objects;

public class Node implements Comparable<Node> {

    private Integer x;
    private Integer y;
    private Integer distanceToEnd;
    private Integer distanceFromStart;
    private Integer currentPathCost;
    private char    character;
    private Node    parent;

    public Node(int y, int x, char character) {
	this.y		       = y;
	this.x		       = x;
	this.character	       = character;
	this.distanceFromStart = 0;
	this.distanceToEnd     = 0;
	this.currentPathCost   = Integer.MAX_VALUE;

    }

    public Integer getX() {
	return x;
    }

    public void setX(Integer x) {
	this.x = x;
    }

    public Integer getY() {
	return y;
    }

    public void setY(Integer y) {
	this.y = y;
    }

    public Integer getDistanceToEnd() {
	return distanceToEnd;
    }

    public void setDistanceToEnd(Integer distanceToEnd) {
	this.distanceToEnd = distanceToEnd;

    }

    public Integer getDistanceFromStart() {
	return distanceFromStart;
    }

    public void setDistanceFromStart(Integer distanceFromStart) {
	this.distanceFromStart = distanceFromStart;
	setCurrentPathCost();

    }

    public Integer getCurrentPathCost() {
	return currentPathCost;
    }

    public void setCurrentPathCost() {

	this.currentPathCost = distanceToEnd + distanceFromStart;
    }

    public char getCharacter() {
	return character;
    }

    public void setCharacter(char character) {
	this.character = character;
    }

    public Node getParent() {
	return parent;
    }

    public void setParent(Node parent) {
	this.parent = parent;
    }

    @Override
    public int compareTo(Node o) {
	return this.currentPathCost - o.currentPathCost;
    }

    @Override
    public int hashCode() {
	return Objects.hash(x, y);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Node other = (Node) obj;
	return Objects.equals(x, other.x) && Objects.equals(y, other.y);
    }

    public boolean isEndNode() {

	return this.character == 'E';
    }

    public Integer getWalkCost() {

	return Character.isDigit(character) ? Character.getNumericValue(character) + 1 : 1;
    }

    public boolean isPassable() {
	return Character.isDigit(character) || Arrays.asList(' ', 'E', 'I').contains(character);
    }

    @Override
    public String toString() {
	return "Node [x=" + x + ", y=" + y + ", distanceToEnd=" + distanceToEnd + ", distanceFromStart="
	                + distanceFromStart + ", currentPathCost=" + currentPathCost + ", character=" + character
	                + ", parent=" + parent + "]";
    }

}
