package me.reckter.NeuralNetwork;

/**
 * Created by Hannes on 8.5.2014.
 *
 * @author Hannes Güdelhöfer
 */
public abstract class OutputNode extends Node {
	public OutputNode(double threshold) {
		super(threshold);
	}

	public abstract void onOutput(double value);

	@Override
	public double getOutput() {
		double ret = super.getOutput();
		onOutput(ret);
		return ret;
	}
}
