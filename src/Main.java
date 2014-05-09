import me.reckter.NeuralNetwork.InputNode;
import me.reckter.NeuralNetwork.Network;
import me.reckter.NeuralNetwork.OutputNode;
import me.reckter.NeuralNetwork.Trainer;

/**
 * Created by mediacenter on 09.05.14.
 *
 * @author Hannes Güdelhöfer
 */
public class Main {
	static public void main(String[] args) {
		Network net = new Network(new Trainer() {
			@Override
			public void correctOutputs(Network network) {}
		});
		net.addInputNode(new InputNode(0.7) {
			@Override
			public void updateValue() {
				value = 1;
			}
		});
		net.addOuputNode(new OutputNode(0.7) {
			@Override
			public void onOutput(double value) {
				System.out.println(value);
			}
		});
		net.populateHiddenLayers(3,7);
		System.out.println(net);
	}
}
