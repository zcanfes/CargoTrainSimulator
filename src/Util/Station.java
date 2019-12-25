package Util;

import java.io.PrintStream;
import java.util.Queue;
import CargoTrain.Train;
import java.util.LinkedList;

public class Station{
	private int id;
	private Queue<Cargo> cargoQueue;
	public static PrintStream printStream;

	
	public Station(int id) {
		this.id = id;
		cargoQueue = new LinkedList<Cargo>();
	}
	public void process(Train train) {
		if(this.id != 0)
			train.unload(cargoQueue);
		for(Cargo cargo : cargoQueue) {
			if(cargo.getTargetStation().getId() == this.id) {
				cargo.setCorrectStation(true);
				printStream.print(cargo + "\n");//cargoqueue'yu düzeltt
			}
			else {
				cargo.setCorrectStation(false);
			}
		}
		train.load(cargoQueue);
	}
	public int getId() {
		return id;
	}
	public Queue<Cargo> getCargoQueue() {
		return cargoQueue;
	}
	public void setCargoQueue(Queue<Cargo> cargoQueue) {
		this.cargoQueue = cargoQueue;
	}
}