package userInterface;

import java.util.Scanner;

import model.Game;

public class Main {
	private Game shippuden;
	private Scanner reader;
	
	public Main() {
		reader = new Scanner(System.in);
		shippuden = new Game();
		}
	public static void main(String[] args) {
		Main m = new Main();

}
}
