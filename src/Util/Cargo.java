package Util;
public class Cargo{
	private int id;
	private int size;
	private Station targetStation;
	private Station loadingStation;
	private boolean correctStation;
	
	public Cargo(int id, int size, Station targetStation, Station loadingStation) {
		this.id = id;
		this.size = size;
		this.targetStation = targetStation;
		this.loadingStation = loadingStation;
	}
	public String toString() {
		return id + " " + loadingStation.getId() + " " + targetStation.getId()
		+ " " + size;
	}

	public boolean getCorrectStation() {
		return correctStation;
	}
	public void setCorrectStation(boolean value) {
		this.correctStation = value;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	public Station getTargetStation() {
		return targetStation;
	}
	public void setTargetStation(Station targetStation) {
		this.targetStation = targetStation;
	}
	public Station getLoadingStation() {
		return loadingStation;
	}
	public void setLoadingStation(Station loadingStation) {
		this.loadingStation = loadingStation;
	}
}