package CargoTrain;

import java.util.Queue;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import Util.Cargo;

public class Train{
	private int carCapacity;
	private int length;
	Carriage head = null;
	Carriage tail = null;

	public int getCarCapacity() {
		return carCapacity;
	}
	public Carriage getHead() {
		return head;
	}
	public Carriage getTail() {
		return tail;
	}
	public int getLength() {
		return this.length;
	}
	
	public Train(int length, int carCapacity) {
		this.carCapacity = carCapacity;
		for(int i = 0; i < length; i++) {
			this.add(new Carriage(carCapacity));
		}
		this.length = length;
	}

	public void load(Queue <Cargo> cargos) {
		this.removeAll();
		for(Cargo cargo : cargos) {
			Carriage current = head;
			boolean value = false;
			if(cargo.getCorrectStation() == false) {
				for(int i = 0; i < this.calculateLength(); i++) {
					if(current.getEmptySlot() >= cargo.getSize()) {
						current.push(cargo);
						current.setEmptySlot(cargo);
						value = true;
						break;
					}
					else {
						current = current.getNext();
					}
				}
				if(!value) {
					Carriage car = new Carriage(carCapacity);
					car.push(cargo);
					car.setEmptySlot(cargo);
					this.add(car);
				}
			}
		}
		int size = cargos.size();
		for(int i = 0; i < size; i++) {
			Cargo cargo = cargos.poll();
			if(!cargo.getCorrectStation()) {
				cargos.remove(cargo);
			}
			else
				cargos.add(cargo);
		}
		this.calculateLength();
	}
	public void unload(Queue<Cargo> cargos) {
		while(this.calculateLength() != 0) {
			while(head.getEmptySlot() != carCapacity) {
				Cargo cargo = head.pop();
				cargos.add(cargo);
				head.unloadSlot(cargo.getSize());
			}
			head = head.getNext();
		}
		this.removeAll();		
	}
	public int calculateLength() {
		if(head == null)
			return 0;
		else {
			int count = 1;
			Carriage current = head;
			for(int i = 0; i < length; i++) {
				try {
					if(current.getNext().getEmptySlot() != carCapacity) {
						count++;
					}
					current = current.getNext();
				} catch(Exception e){
					this.length = count;
					return count;
				}
			}
			this.length = count;
			return count;
		}
	}
	public void add(Carriage car) {
		if(head == null) {
			head = tail = car;
		}
		else {
			Carriage current = head;
			while(current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(car);
			car.setPrev(current);
			tail = car;
		}
		this.length = this.calculateLength() + 1;
	}
	public void removeAll() {
		head = tail = null;
		this.length = 0;
	}
	public String toString() {
		String s = "";
		if(head != null) {
			Carriage current = head;
			s += head;
			while(current.getNext() != null) {
				current = current.getNext();
				s += current;
			}
		}
		return "{" + s + "}";
	}
}