package model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Character implements Serializable {
	
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
	public void addTechnique(String name, String factor) throws RepetidoException
    {
		if(searchTech(name)==null) {
	        Technique nuevo = new Technique( name, factor);
	        if( firstTech == null )
	            firstTech = nuevo;
	        else if( firstTech.compareByName(nuevo)>0)
	        {
	            firstTech.changeNext(firstTech);
	            firstTech = nuevo;
	        }
	        else
	        {
	            Technique TechniqueTemp0 = null;
	            Technique TechniqueTemp1 = firstTech;
	            while( TechniqueTemp1 != null && TechniqueTemp1.compareByName(nuevo)<0)
	            {
	                TechniqueTemp0 = TechniqueTemp1;
	                TechniqueTemp1 = TechniqueTemp1.getNext();
	            }
	            TechniqueTemp0.addAfter( nuevo );
	        }
	        numTech++;
		}else
			throw new RepetidoException("esta tecnica ya existe");
    }
	
	private Technique searchTech(String name2) {
		for( Technique p = firstTech; p != null; p = p.getNext())
        {
            if( p.getName().equalsIgnoreCase(name2))
                return p;
        }
        return null;
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
	public Technique findBefore(Technique toFind) {
		Technique before = null;
		Technique actual = firstTech;
		
		while(actual!=null && !actual.getName().contentEquals(toFind.getName())) {
			before=actual;
			actual=actual.getNext();
			}
		return actual!=null? before:null;
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
	public void deleteNode(String name) throws NullNode{
		if(firstTech != null) {
			if(firstTech.getName().equalsIgnoreCase(name)) {
				firstTech = firstTech.getNext();
			}else {
				Technique x = search(name);
				Technique before = findBefore(x);
				if(before==null || x ==null) {
					throw new NullNode("No existe una tecnica con ese nombre");
				}else
					before.deleteNext();
			}
			numTech--;
		}else {
			throw new NullNode("No existe una tecnica con ese nombre");
		}
	}
	public Technique search(String x){
        for( Technique p = firstTech; p != null; p = p.getNext())
        {
            if( p.getName().equalsIgnoreCase(x))
                return p;
        }
        return null;
    }
	public void saveTechnique(String h){		
		File file = new File(h);
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			Technique actual = firstTech;
			while(actual!=null) {
				oos.writeObject(actual);
				actual = actual.getNext();
			}
			oos.close();
			}catch (IOException e) {
				e.printStackTrace();
		}
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
	
}
