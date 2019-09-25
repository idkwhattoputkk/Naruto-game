package model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Clan implements Serializable  {
	//attributes
	private String name;
	private int numNinjas;
	private Character firstC;
	private Clan next;
	private Clan prev;
	//methods
	public Clan(String name) {
		this.name = name;
		this.numNinjas=0;
		next = null;
		prev =null;
	}
	public void addTechnique(String n, String name, String factor) throws RepetidoException {
		Character x = search(n);
		x.addTechnique(name, factor);
	}
	public void addOrderedNinja(String name, String personality, String date, int power) throws RepetidoException {
		if(checkName(name)){
        Character nuevo = new Character( name, personality, date, power );
        if(firstC == null )
            firstC = nuevo;
        else if( firstC.getPower() > power)
        {
            firstC.addBefore( nuevo );
            firstC = nuevo;
        }
        else
        {
            Character CharacterTemp0 = null;
            Character CharacterTemp1 = firstC;
            while( CharacterTemp1 != null && CharacterTemp1.getPower()< power )
            {
                CharacterTemp0 = CharacterTemp1;
                CharacterTemp1 = CharacterTemp1.getNext();
            }
            CharacterTemp0.addAfter( nuevo );
        }
        numNinjas++;
		}
		else {
			throw new RepetidoException("este ninja ya esxiste");
		}
	}
	private boolean checkName(String name2) {
		Character ninja = firstC;
		boolean flag=false;
		while(ninja!=null&&!flag) {
			if(ninja.getName().equalsIgnoreCase(name2)){
				flag=true;
			}
			else {
				ninja = ninja.getNext();
			}
		}
		return flag;
	}
	public int listSize(){
		Character actual = firstC;
		int size=0;
		while(actual!=null) {
			size++;
			actual = actual.getNext();
		}
		return size;
	}
//	selection
	public void orderNinjas(){
		if(listSize()>1) {
		}
	}
	public void deleteNode(String name) throws NullNode{
		if(firstC != null) {
			if(firstC.getName().equalsIgnoreCase(name)) {
				firstC = firstC.getNext();
			}else {
				Character x = search(name);
				if(x==null) {
					throw new NullNode("No existe un ninja con ese nombre");
				}
				x.setPrev(x.getNext().getNext());
			}
			numNinjas--;
		}else {
			throw new NullNode("No existe un ninja con ese nombre");
		}
	}
	public void saveCharacter(String h){		
		File file = new File(h);
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			Character actual = firstC;
			while(actual!=null) {
				oos.writeObject(actual);
				actual = actual.getNext();
			}
			oos.close();
			}catch (IOException e) {
				e.printStackTrace();
		}
	}
	public void addBefore(Clan nuevo) {	
		if( prev != null )
            prev.next = nuevo;
		
        nuevo.prev = prev;
        nuevo.next = this;
        prev = nuevo;
	}
	public void addAfter(Clan nuevo) {
		 nuevo.next = next;
	        if( next != null )
	            next.prev = nuevo;
	        
	        nuevo.prev = this;
	        next = nuevo;
	}
	public String toString() {
		return name;
		
	}
	public Character search(String x){
        for( Character p = firstC; p != null; p = p.getNext())
        {
            if( p.getName().equalsIgnoreCase(x))
                return p;
        }
        return null;
    }
	public void saveTechnique(String pathTechniques) {
		Character actual = firstC;
		while(actual!=null) {
			actual.saveTechnique(pathTechniques);
			actual=actual.getNext();
		}
		
	}
	public void orderTechniques() {
		Character actual = firstC;
		while(actual!=null) {
			actual.orderingTechniques();
			actual=actual.getNext();
		}		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumNinjas() {
		return numNinjas;
	}
	public void setNumNinjas(int numNinjas) {
		this.numNinjas = numNinjas;
	}
	public Character getFirstC() {
		return firstC;
	}
	public void setFirstC(Character firstC) {
		this.firstC = firstC;
	}
	public Clan getNext() {
		return next;
	}
	public void setNext(Clan next) {
		this.next = next;
	}
	public int compareByName(Clan toIterate) {
		int valueToComparate = name.compareToIgnoreCase(toIterate.name);
		if (valueToComparate < 0) {
			valueToComparate = -1;
		} else if (valueToComparate == 0) {
			valueToComparate = 0;
		} else {
			valueToComparate = 1;
		}
		return valueToComparate;
	}
	
}
