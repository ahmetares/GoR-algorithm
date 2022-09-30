package GorStaking;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
	
		
		PowerRates pw = new PowerRates();

		
		War war = new War();
		
		war.leveling("trade");
		war.leveling("trade");
		war.leveling("sea");
		war.leveling("magic");
		war.leveling("sea");
		war.leveling("magic");
		war.leveling("hunt");
		war.leveling("sea");
		war.leveling("magic");
		war.leveling("hunt");
		
	

		Magic magic = new Magic();

		magic.leveling("sea");
		magic.leveling("sea");
		magic.leveling("war");
		magic.leveling("war");
		magic.leveling("hunt");
		magic.leveling("hunt");
		magic.leveling("trade");
		magic.leveling("war");
		magic.leveling("hunt");
		magic.leveling("trade");
		
	

		pw.battle(war, magic);
	
		

		}
		
		
		
		
	}
	
	


