package Main;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import CargoTrain.Train;
import Util.Station;
import Util.Cargo;

public class Main{
	public static void main(String[] args) throws FileNotFoundException{
		File inputFile = new File(args[0]);
		File outputFile = new File(args[1]);
		Scanner scannerIn = new Scanner(inputFile);
		PrintStream printStream = new PrintStream(outputFile);
		readAndInitialize(scannerIn, printStream);
	}
	
	public static void readAndInitialize(Scanner scannerIn, PrintStream printStream) {
		int carNumber = 0;
		int capacity = 0;
		int nofStation = 0;
		if(scannerIn.hasNext()) {
			carNumber = scannerIn.nextInt();
			capacity = scannerIn.nextInt();
			nofStation = scannerIn.nextInt();
		}
		Train train = new Train(carNumber, capacity);
		ArrayList<Station> stations = new ArrayList<Station>();
		for(int i = 0; i < nofStation; i++) {
			stations.add(new Station(i));
		}
		while(scannerIn.hasNext()) {//Arraylist yap
			int cargoId = scannerIn.nextInt();
			int stationId = scannerIn.nextInt();
			int targetId = scannerIn.nextInt();
			int cargoSize = scannerIn.nextInt();
			if(stations.size() > targetId && stations.size() > stationId) {
				Station target = stations.get(targetId);
				Station loading = stations.get(stationId);
				if(targetId >= stationId && cargoSize > 0 && target != null && loading != null) {
					Cargo cargo = new Cargo(cargoId, cargoSize, target, loading);
					loading.getCargoQueue().add(cargo);
				}
			}
		}
		execute(train, nofStation, stations, printStream);
	}

	public static void execute(Train train, int nofStation, ArrayList<Station> stations, PrintStream printStream) {
		for(int i = 0; i < nofStation; i++) {
			Station station = stations.get(i);
			Station.printStream = printStream;
			station.process(train);
			if(train.getHead() == null)
				train.removeAll();
			printStream.print(i + " " + train.getLength() + "\n");
		}
	}
}