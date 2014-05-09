package me.reckter.NeuralNetwork;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 * Created by Hannes on 8.5.2014.
 *
 * @author Hannes Güdelhöfer
 */
public class Network {

	ArrayList<InputNode> inputNodes;
	ArrayList<ArrayList<Node>> hiddenNodes;
	ArrayList<OutputNode> outputNodes;
	Trainer trainer;


	Random random = new Random();

	public Network(Trainer trainer) {
		inputNodes = new ArrayList<InputNode>();
		outputNodes = new ArrayList<OutputNode>();
		hiddenNodes = new ArrayList<ArrayList<Node>>();
		this.trainer = trainer;
	}

	public void updateInputs() {
		for(InputNode node: inputNodes) {
			node.updateValue();
		}
	}

	public void updateOutputs() {
		for(OutputNode node: outputNodes) {
			node.getOutput();
		}
	}

	public void populateHiddenLayers(int layers, int nodesPerLayer) {
		ArrayList<Integer> hiddenlayers = new ArrayList<Integer>();
		for(int i = 0; i < layers; i++) {
			hiddenlayers.add(nodesPerLayer);
		}
		populateHiddenLayers(hiddenlayers);
	}

	public void populateHiddenLayers(ArrayList<Integer> hiddenLayers) {
		int j = 0;
		for(Integer num: hiddenLayers) {
			j++;
			ArrayList<Node> tmp = new ArrayList<Node>();
			for(int i = 0; i < num; i++) {
				Node node = new Node(random.nextDouble());
				node.name = j + ":" + i;
				tmp.add(node); //todo change the value of the max threshold?
			}
			hiddenNodes.add(tmp);
		}
		for(int i = 0; i < hiddenNodes.size() - 1; i++) {
			for(Node nodeA: hiddenNodes.get(i)) {
				for(Node nodeB: hiddenNodes.get(i + 1)) {
					Connection con = new Connection(nodeA, nodeB, random.nextDouble());
					nodeA.addOutput(con);
					nodeB.addInput(con);
				}
			}
		}

		for(InputNode inputNode: inputNodes) {
			for(Node node: hiddenNodes.get(0)) {
				Connection con = new Connection(inputNode, node, random.nextDouble());
				inputNode.addOutput(con);
				node.addInput(con);
			}
		}
		for(OutputNode outputNode: outputNodes) {
			for(Node node: hiddenNodes.get(hiddenNodes.size() - 1)) {
				Connection con = new Connection(node, outputNode, random.nextDouble());
				node.addOutput(con);
				outputNode.addInput(con);
			}
		}
	}

	public void addInputNode(InputNode inputNode) {
		inputNodes.add(inputNode);
		if(hiddenNodes.size() > 0) {
			for(Node node: hiddenNodes.get(0)) {
				Connection con = new Connection(inputNode, node, random.nextDouble());
				inputNode.addOutput(con);
				node.addInput(con);
			}
		}
	}


	public void addOuputNode(OutputNode outputNode) {
		outputNodes.add(outputNode);
		if(hiddenNodes.size() > 0) {
			for(Node node: hiddenNodes.get(hiddenNodes.size() - 1)) {
				Connection con = new Connection(node, outputNode, random.nextDouble());
				node.addOutput(con);
				outputNode.addInput(con);
			}
		}
	}

	public void update() {
		updateInputs();
		updateOutputs();
		trainer.train(this);
	}

	@Override
	public String toString() {
		StringBuilder ret = new StringBuilder("digraph {\n");
		StringBuilder retNodes = new StringBuilder();
		ArrayList<Node> nodes = new ArrayList<Node>();
		ArrayList<Connection> connections = new ArrayList<Connection>();

		nodes.addAll(inputNodes);
		nodes.addAll(outputNodes);
		for(ArrayList<Node> layer: hiddenNodes) {
			nodes.addAll(layer);
		}
		for(Node node: nodes) {
			connections.addAll(node.outputs);
			retNodes.append(node.name).append(" [label=\"").append(node.inputs.get(0).weight).append("\"];\n");
		}

		for(Connection con: connections) {
			if(con.input != con.output) {
				ret.append(con.input.name).append(" -> ").append(con.output.name).append(" [label=\"").append(con.weight).append("\"];\n");
			}
		}

		ret.append(retNodes).append("}");
		return ret.toString();
	}
}
