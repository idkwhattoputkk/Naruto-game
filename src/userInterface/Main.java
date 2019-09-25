package userInterface;

import java.util.Scanner;

import model.Game;

public class Main {
	private Game shippuden;
	private Scanner reader;
	
	public Main() {
		reader = new Scanner(System.in);
		shippuden = new Game();
		appManagement();
		}
	private void appManagement() {
		boolean out = false;

		while (!out) {
			
			int valorUsuario = appMenuPrincipal();
			switch(valorUsuario) {
			case 1:
				long t1=System.currentTimeMillis();
				System.out.println("nombre del clan : ");
				String nameClan = reader.nextLine();
				System.out.println("nombre: ");
				String name = reader.nextLine();
				System.out.println("personalidad: ");
				String personality = reader.nextLine();
				System.out.println("fecha nacimiento: ");
				String date = reader.nextLine();
				System.out.println("digite el poder: ");
				int power=Integer.parseInt(reader.nextLine());
				System.out.println(" ");
				shippuden.addCharacter(nameClan, name, personality, date, power);
				long tf=System.currentTimeMillis();
				System.out.println(tf-t1);
				break;
			case 2:
				t1=System.currentTimeMillis();
				System.out.println("nombre del clan : ");
				nameClan = reader.nextLine();
				shippuden.addClan(nameClan);
				tf=System.currentTimeMillis();
				System.out.println(tf-t1);
				break;
			case 3:
				long tx=System.currentTimeMillis();
				System.out.println("nombre del clan : ");
				nameClan = reader.nextLine();
				System.out.println("nombre del ninja: ");
				String name = reader.nextLine();
				System.out.println("Tecnica: ");
				String tech = reader.nextLine();
				System.out.println("factor: ");
				String factor = reader.nextLine();
				shippuden.addTechnique(nameClan,name, tech, factor);
				long ty=System.currentTimeMillis();
				System.out.println(ty-tx);
				break;
			case 4:
				long i=System.currentTimeMillis();
				long f=System.currentTimeMillis();
				System.out.println(f-i);
				break;
			case 5:
				t1=System.currentTimeMillis();
				tf=System.currentTimeMillis();
				System.out.println(tf-t1);
				break;
			case 6:
				t1=System.currentTimeMillis();
				tf=System.currentTimeMillis();
				System.out.println(tf-t1);
				break;
			case 7:
				t1=System.currentTimeMillis();
				tf=System.currentTimeMillis();
				System.out.println(tf-t1);
				break;
			case 8:
				t1=System.currentTimeMillis();
				tf=System.currentTimeMillis();
				System.out.println(tf-t1);
				break;
			case 9:
				t1=System.currentTimeMillis();
				tf=System.currentTimeMillis();
				System.out.println(tf-t1);
				break;
			case 10:
				t1=System.currentTimeMillis();
				tf=System.currentTimeMillis();
				System.out.println(tf-t1);
				break;
			case 11:
				long t2=System.currentTimeMillis();
				long tf2=System.currentTimeMillis();
				System.out.println(tf2-t2);
				break;
			case 12:
				long t3=System.currentTimeMillis();
				long tf3=System.currentTimeMillis();
				System.out.println(tf3-t3);
				break;
			case 13:
				out = true;
				break;
			}
		}
	}
	public int appMenuPrincipal(){
		int valor=0;
		System.out.println("1. añadir un ninja");
		System.out.println("2. añadir un clan");
		System.out.println("3. añadir una tecnica");
		System.out.println("4. ordenar tecnicas");
		System.out.println("5. buscar una tecnica");
		System.out.println("6. buscar un ninja");
		System.out.println("7. buscar un clan");
		System.out.println("8. ordenar listas de ninjas");
		System.out.println("9. eliminar un clan");
		System.out.println("10. eliminar una tecnica");
		System.out.println("11. eliminar un ninja");
		System.out.println("12. guardar las clases");
		System.out.println("13. Salir");
		
		
		valor = Integer.parseInt(reader.nextLine());
		return valor;		
	}
	public static void main(String[] args) {
		Main m = new Main();

}
}
