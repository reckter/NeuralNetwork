package me.reckter.NeuralNetwork;

/**
 * Created by Hannes on 8.5.2014.
 *
 * @author Hannes Güdelhöfer
 */
public abstract class InputNode extends Node{

	public double value;
	public InputNode(double threshold) {
		super(threshold);
	}

	/**
	 * gets called to update the value of this input node
	 */
	public abstract void updateValue();

	@Override
	public double getOutput() {
		return value;
	}
}
