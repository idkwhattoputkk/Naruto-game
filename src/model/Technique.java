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
	
}
