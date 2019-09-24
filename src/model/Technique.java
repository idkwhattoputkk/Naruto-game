package model;

public class Technique {
//	attributes
	private String name;
	private String factor;
	private Technique next;
//	methods
	public Technique(String name, String factor) {
		this.name = name;
		this.factor = factor;
		next=null;
	}
	public int compareByFactor(Technique t) {
		int valueToComparate = factor.compareToIgnoreCase(t.factor);
		if (valueToComparate < 0) {
			valueToComparate = -1;
		} else if (valueToComparate == 0) {
			valueToComparate = 0;
		} else {
			valueToComparate = 1;
		}
		return valueToComparate;
	}
	public int compareByName(Technique t) {
		int valueToComparate = name.compareToIgnoreCase(t.name);
		if (valueToComparate < 0) {
			valueToComparate = -1;
		} else if (valueToComparate == 0) {
			valueToComparate = 0;
		} else {
			valueToComparate = 1;
		}
		return valueToComparate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFactor() {
		return factor;
	}
	public void setFactor(String factor) {
		this.factor = factor;
	}
	public Technique getNext() {
		return next;
	}
	public void setNext(Technique next) {
		this.next = next;
	}
	public void addAfter(Technique nuevo) {
		 	nuevo.next=next;
		 	next = nuevo;
		
	}
	public void addBefore(Technique nuevo) {
		Technique before = null;
		
		before.addBefore(nuevo);
					
				
	}
}
