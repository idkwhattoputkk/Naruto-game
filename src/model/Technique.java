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
	
}
