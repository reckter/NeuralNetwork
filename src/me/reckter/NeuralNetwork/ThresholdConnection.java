package me.reckter.NeuralNetwork;

/**
 * Created by Hannes on 7.5.2014.
 *
 * @author Hannes Güdelhöfer
 */
public class ThresholdConnection  extends Connection{
	public ThresholdConnection(Node node, double weight) {
		super(node, node, weight);
	}

	@Override
	public double weight() {
		return -1 * weight;
	}
}
