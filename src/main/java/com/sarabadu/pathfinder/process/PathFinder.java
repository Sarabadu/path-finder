package com.sarabadu.pathfinder.process;

import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import com.sarabadu.pathfinder.domain.Map;
import com.sarabadu.pathfinder.domain.Node;

public class PathFinder {

    private Map		map;
    private Queue<Node>	openNodes   = new PriorityQueue<>();
    private Set<Node>	closedNodes = new HashSet<>();
    private Node	startNode;
    private Node	endNode;

    public PathFinder(String map) {
	this.map       = new Map(map);
	this.startNode = this.map.getStartNode();
	this.endNode   = this.map.getEndNode();
    }

    public Map resolve() {
	return resolveMap();
    }

    public String print() {
	return resolveMap().toString();
    }

    private Map resolveMap() {

	startNode.setDistanceToEnd(map.distance(startNode, endNode));
	startNode.setCurrentPathCost();

	openNodes.add(startNode);

	boolean noMoreMoves = false;
	boolean pathFinded = false;

	while (!pathFinded && !noMoreMoves) {

	    Node current = openNodes.poll();

	    closedNodes.add(current);

	    pathFinded = current.isEndNode();

	    if (!pathFinded) {
		processPosibleSteps(current);

		noMoreMoves = openNodes.isEmpty();
	    }

	}

	if (pathFinded) {
	    map.tracePath();
	}

	return map;

    }

    private void processPosibleSteps(Node current) {
	List<Node> posibleSteps = map.getPosibleSteps(current);

	for (Node node : posibleSteps) {

	    node.setDistanceToEnd(map.distance(node, endNode));

	    if (isNotAlreadyChecked(node)) {

		Integer cost = node.getWalkCost() + current.getDistanceFromStart();

		if (isCostLowerForNode(cost, node)) {
		    node.setDistanceFromStart(cost);
		    node.setCurrentPathCost();
		    node.setParent(current);
		}

		openNodes.add(node);

	    }
	}

    }

    private boolean isCostLowerForNode(Integer cost, Node node) {
	return cost + node.getDistanceToEnd() < node.getCurrentPathCost();
    }

    private boolean isNotAlreadyChecked(Node node) {

	return !closedNodes.contains(node);
    }

}
