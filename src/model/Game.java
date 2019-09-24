package model;

public class Game {
	private String name;
	private Clan firstClan;
	
	public Game() {
		this.name="naruto's shippuden";
		firstClan = null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Clan getfirstClanlan() {
		return firstClan;
	}

	public void setfirstClanlan(Clan firstClan) {
		this.firstClan = firstClan;
	}
	public void addOrderedClan(String name) {

        Clan nuevo = new Clan( name);
        if(firstClan == null )
            firstClan = nuevo;
        else if( firstClan.compareByName(nuevo)>0)
        {
            firstClan.addBefore( nuevo );
            firstClan = nuevo;
        }
        else
        {
            Clan ClanTemp0 = null;
            Clan ClanTemp1 = firstClan;
            while( ClanTemp1 != null && ClanTemp1.compareByName(nuevo)<0 )
            {
                ClanTemp0 = ClanTemp1;
                ClanTemp1 = ClanTemp1.getNext();
            }
            ClanTemp0.addAfter( nuevo );
        }
	}
//	public void orderclans() {
//		Clan actual = firstClan;
//		while(actual !=null) {
//			actual.orderactuals();
//			actual= actual.getNext();
//		}
//	}
	public void addClanOrdered(String name) throws RepetidoException {
		if(checkName(name)){
	        Clan nuevo = new Clan(name);
	        if(firstClan == null )
	            firstClan = nuevo;
	        else if( firstClan.compareByName(nuevo)>0)
	        {
	            firstClan.addBefore( nuevo );
	            firstClan = nuevo;
	        }
	        else
	        {
	            Clan clanTemp0 = null;
	            Clan clanTemp1 = firstClan;
	            while( clanTemp1 != null && clanTemp1.compareByName(clanTemp0)<0 )
	            {
	                clanTemp0 = clanTemp1;
	                clanTemp1 = clanTemp1.getNext();
	            }
	            clanTemp0.addAfter( nuevo );
	        }
			}
			else {
				throw new RepetidoException(name);
			}
	}

	private boolean checkName(String name2){
        for( Clan p = firstClan; p != null; p = p.getNext())
        {
            if( p.getName().equalsIgnoreCase(name2))
                return true;
        }
        return false;
    }
	public String search(String x){
        for( Clan p = firstClan; p != null; p = p.getNext())
        {
            if( p.getName().equalsIgnoreCase(x))
                return p.toString();
        }
        return "No encontrado";
    }
}
