package CargoTrain;

import java.util.Stack;
import Util.Cargo;

public class Carriage{
	private int emptySlot;
	private Stack<Cargo> cargos;
	private Carriage next;
	private Carriage prev;
	
	public Carriage(int capacity) {
		this.emptySlot = capacity;
		this.cargos = new Stack<Cargo>();
		this.next = null;
		this.prev = null;
	}
	public boolean isFull() {
		if(this.emptySlot == 0)
			return true;
		else return false;
	}
	public void push(Cargo cargo) {
		this.cargos.push(cargo);
	}
	public Cargo pop() {
		return cargos.pop();
	}
	public Cargo peek() {
		return cargos.peek();
	}
	public Stack<Cargo> getCargos() {
		return cargos;
	}
	public Carriage getNext() {
		return next;
	}
	public void setNext(Carriage next) {
		this.next = next;
	}
	public Carriage getPrev() {
		return prev;
	}
	public void setPrev(Carriage prev) {
		this.prev = prev;
	}
	public int getEmptySlot() {
		return emptySlot;
	}
	public void setEmptySlot(Cargo cargo) {
		emptySlot = emptySlot - cargo.getSize();
	}
	public String toString() {
		return cargos.toString();
	}
	public void unloadSlot(int size) {
		emptySlot = emptySlot + size;
	}
	public boolean isEmpty() {
		if(this.cargos.isEmpty())
			return true;
		else return false;
	}
}