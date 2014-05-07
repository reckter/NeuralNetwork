package me.reckter.NeuralNetwork;

import java.util.ArrayList;

/**
 * Created by Hannes on 7.5.2014.
 *
 * @author Hannes Güdelhöfer
 */
public class Node {

	ArrayList<Connection> inputs;
	ArrayList<Connection> outputs;

	public Node(double threshold) {
		inputs = new ArrayList<Connection>();
		outputs = new ArrayList<Connection>();
		inputs.add(new ThresholdConnection(this, threshold));
	}

	public double getWeightedSum() {
		double ret = 0;
		for(Connection con: inputs) {
			ret += con.weight();
		}
		return ret;
	}

	public double getOutput(){
		return outputFunction(getWeightedSum());
	}

	public double outputFunction(double in){
		return in;
	}

	public void addInput(Connection con) {
		inputs.add(con);
	}

	public void addOutput(Connection con) {
		inputs.add(con);
	}
}
