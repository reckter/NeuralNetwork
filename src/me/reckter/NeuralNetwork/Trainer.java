package me.reckter.NeuralNetwork;

/**
 * Created by mediacenter on 09.05.14.
 *
 * @author Hannes Güdelhöfer
 */
public abstract class Trainer {

	/**
	 * Sets the outputShouldBe values in the output Nodes of the Network
	 * @param network
	 */
	public abstract void correctOutputs(Network network);


	/**
	 * trains the network
	 * @param network
	 */
	public void train(Network network) {
		//TODO implement real training!
	}
}
