package model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Game {
	// attributes
	public final static String PATH_CLANS="data"+File.separator+"clans.txt";
	public final static String PATH_NINJAS="data"+File.separator+"ninjas.txt";
	public final static String PATH_TECHNIQUES="data"+File.separator+"techniques.txt";
	private String name;
	private ArrayList<Clan> clans;
	//methods
	public Game() {
		this.name="naruto's shippuden";
		clans = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Clan> getclans() {
		return clans;
	}

	public void setclans(ArrayList<Clan> clans) {
		this.clans = clans;
	}
	public void orderByName() {
		for(int i=1;i<clans.size();i++) {
			Clan toIterate = (Clan) clans.get(i);
			boolean finished =false;
			
			for(int j=i;j>0 && !finished;j--) {
				Clan fromNow=(Clan) clans.get(j-1);
				if(fromNow.compareByName(toIterate)>0) {
					clans.set(j, fromNow);
					clans.set(j-1, toIterate);
				}else {
					finished=true;
				}
			}
		}
	}
	public String addCharacter(String nameClan, String name, String personality, String date, int power) {
		Clan iterative = searchClan(nameClan);
		String toReturn="the ninja has been succesfully added";
		if(iterative != null) {
			try {
				iterative.addOrderedNinja(name, personality, date, power);
			} catch (RepetidoException e) {
				toReturn=e.getMessage();
			}
		}
		return toReturn;
	}

	private Clan searchClan(String name2) {
		Clan toReturn=null;
		boolean ended = false;
		for (int i = 0; i < clans.size()&&!ended; i++) {
			if(clans.get(i).getName().equalsIgnoreCase(name2));
				toReturn=clans.get(i);
				ended = true;
		}
		return toReturn;
	}
	public String addTechnique(String nameClan, String name, String tech, String factor) {
		Clan iterative = searchClan(nameClan);
		String toReturn="the Technique has been succesfully added";
		Character itera= iterative.search(name);
		try {
			itera.addTechnique(tech, factor);
		} catch (RepetidoException e) {
			 toReturn = e.getMessage();
		}
		return toReturn;
	}
	public void orderEveryNinjaList() {
		for (int i = 0; i < clans.size(); i++) {
			clans.get(i).orderNinjas();
		}
	}
	public void saveClans(){
		File data = new File("data");
		if(!data.exists())
			data.mkdir();
		
		File file = new File(PATH_CLANS);
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			for (int i = 0; i < clans.size(); i++) {
				oos.writeObject(clans.get(i));
			}
			oos.close();
			}catch (IOException e) {
				e.printStackTrace();
		}
	}
	public void saveCharacters() {
		File data = new File("data");
		if(!data.exists())
			data.mkdir();
		
		for (int i = 0; i < clans.size(); i++) {
			clans.get(i).saveCharacter(PATH_NINJAS);
		}
	}
	public void saveTechniques() {
		File data = new File("data");
		if(!data.exists())
			data.mkdir();
		
		for (int i = 0; i < clans.size(); i++) {
			clans.get(i).saveTechnique(PATH_TECHNIQUES);
		}
	}
	public void addClan(String name) {
		Clan toAdd=new Clan(name);
		clans.add(toAdd);
	}
	public void orderEveryTechniqueList() {
		for (int i = 0; i < clans.size(); i++) {
			clans.get(i).orderTechniques();
		}
	}
}