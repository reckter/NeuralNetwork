package me.reckter.NeuralNetwork;

/**
 * Created by Hannes on 7.5.2014.
 *
 * @author Hannes Güdelhöfer
 */
public class Connection {

	public Node input;
	public Node output;
	public double weight;


	public Connection(Node input, Node output, double weight) {
		this.input = input;
		this.output = output;
		this.weight = weight;
	}

	public double weight() {
		return input.getOutput() * weight;
	}

}
