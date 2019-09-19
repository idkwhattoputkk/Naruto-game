package model;

public class Character {
	//attributtes
	private String name;
	private String personality;
	private String date;
	private int power, numTech;
	private Technique firstTech;
	private Character next;
	private Character prev;
	//methods
	public Character(String name, String personality, String date, int power) {
		this.name = name;
		this.personality = personality;
		this.date = date;
		this.power = power;
		numTech=0;
		firstTech=null;
		next=null;
		prev=null;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPersonality() {
		return personality;
	}
	public void setPersonality(String personality) {
		this.personality = personality;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public Character getNext() {
		return next;
	}
	public void setNext(Character next) {
		this.next = next;
	}
	public Character getPrev() {
		return prev;
	}
	public void setPrev(Character prev) {
		this.prev = prev;
	}
	public void addAfter(Character nuevo) {
		 nuevo.next = next;
	        if( next != null )
	            next.prev = nuevo;
		        nuevo.prev = this;
		        next = nuevo;
	}
	public void addBefore(Character nuevo) {
		if( prev != null )
            prev.next = nuevo;
	        nuevo.prev = prev;
	        nuevo.next = this;
	        prev = nuevo;
	}
	public int listSize(){
		Technique actual = firstTech;
		int size=0;
		while(actual!=null) {
			size++;
			actual = actual.getNext();
		}
		return size;
	}
//	bubble
	public void orderingTechniques(){
		 if ( listSize() > 1) {
	        boolean cambio;
	        do {
	            Technique actual = firstTech;
	            Technique anterior = null;
	            Technique siguiente = firstTech.getNext();
	            cambio = false;
	            while ( siguiente != null ) {
	                if (actual.compareByFactor(actual)>0) {
	                    cambio = true;
	                    if ( anterior != null ) {
	                        Technique sig = siguiente.getNext();
	                        anterior.getNext().setNext(siguiente);
	                        siguiente.getNext().setNext(actual);
	                        actual.getNext().setNext(sig);
	                    } else {
	                        Technique sig = siguiente.getNext();
	                        firstTech = siguiente;
	                        siguiente.getNext().setNext(actual);
	                        actual.getNext().setNext(sig);
	                    }
	                    anterior = siguiente;
	                    siguiente = actual.getNext();
	                } else { 
	                    anterior = actual;
	                    actual = siguiente;
	                    siguiente = siguiente.getNext();
	                }
	            } 
	        } while( cambio );
	    }
	}
	
	
	
}
