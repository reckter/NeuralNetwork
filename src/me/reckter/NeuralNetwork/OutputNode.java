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

	public double output;
	public double outputShouldBe;

	public abstract void onOutput(double value);

	@Override
	public double getOutput() {
		output = super.getOutput();
		onOutput(output);
		return output;
	}
}
