package GorStaking;

import java.util.ArrayList;
import java.util.Random;

public class PowerRates   {
	
	School [] abilities = new School[2];
	
	double[][] powerRates = {{1,1.6,0.8,1.2,0.4},    //oranlar
							 {0.4,1,1.6,0.8,1.2},
							 {1.2,0.4,1,1.6,0.8},
							 {0.8,1.2,0.4,1,1.6},
							 {1.6,0.8,1.2,0.4,1}};
	
	
	Linkedlist table = new Linkedlist();
	 
	
	public PowerRates() {
	table.add("hunt", 0);
	table.add("war", 1);
	table.add("trade", 2);
	table.add("magic", 3);
	table.add("sea", 4);
   }
	
	
	public void battle(School ability1, School ability2) {
		
		
		System.out.println(ability1.getWeek() +","+ ability2.getWeek());
		
		if(ability1.getWeek() != ability2.getWeek()) {   //leveller aynı degılse battle olmamalı - çalışmadı
			return;
		}
		
		
		else {
		Double ability1Point = 0.0;      //1. kişinin puanı
		Double ability2Point = 0.0; 	 //2. kişinin puanı
		
		Node first1 = ability1.getAbility().findNode(ability1.first);          //       first1        				  first2
		Node middle11 = ability1.getAbility().findNode(ability1.middle1);      //middle11     middle12     VS    middle21   middle22
		Node middle12 = ability1.getAbility().findNode(ability1.middle2);      //        last1						   last2
		Node last1 = ability1.getAbility().findNode(ability1.last);            //   
		
		Node first2 = ability2.getAbility().findNode(ability2.first);
		Node middle21 = ability2.getAbility().findNode(ability2.middle1);
		Node middle22 = ability2.getAbility().findNode(ability2.middle2);
		Node last2 = ability2.getAbility().findNode(ability2.last);
		
       
		//-------------------------------------------
		//2. kişiyle eşleşmeyi random yapma

		Random r = new Random();
		ArrayList  <Node> beforeRandom = new ArrayList();
		ArrayList  <Node> afterRandom = new ArrayList();
        beforeRandom.add(first2); beforeRandom.add(middle21); beforeRandom.add(middle22); beforeRandom.add(last2); 
		
		
		for (int i = 0; i < 4; i++) {
		    int a = r.nextInt(beforeRandom.size());  // 0 -1- 2 3 
			Node mixed = beforeRandom.get(a);   //mixed = middle21   		   
			afterRandom.add(mixed);  //[middle21]
			beforeRandom.remove(a);  // [first1,middle22,last2]
		}
		
		for (int i = 0; i < afterRandom.size(); i++) {
			System.out.print(afterRandom.get(i).getItem() + ",  ");  // syso(afterRandom) = [middle21,last2,middle22,first2]
		}
		//-------------------------------------------
		
		
		
//		//NORMAL
//      ability1Point+=first1.getCount()*powerRates[table.findNode(first1.getItem()).getCount()] [table.findNode(first2.getItem()).getCount()];
//		ability1Point+=middle11.getCount()*powerRates[table.findNode(middle11.getItem()).getCount()] [table.findNode(middle21.getItem()).getCount()];
//		ability1Point+=middle12.getCount()*powerRates [table.findNode(middle12.getItem()).getCount()] [table.findNode(middle22.getItem()).getCount()];
//		ability1Point+=last1.getCount()*powerRates[table.findNode(last1.getItem()).getCount()] [table.findNode(last2.getItem()).getCount()];
//		
//		ability2Point+=first2.getCount()*powerRates[table.findNode(first2.getItem()).getCount()] [table.findNode(first1.getItem()).getCount()];
//		ability2Point+=middle21.getCount()*powerRates[table.findNode(middle21.getItem()).getCount()] [table.findNode(middle11.getItem()).getCount()];
//		ability2Point+=middle22.getCount()*powerRates [table.findNode(middle22.getItem()).getCount()] [table.findNode(middle12.getItem()).getCount()];
//		ability2Point+=last2.getCount()*powerRates[table.findNode(last2.getItem()).getCount()] [table.findNode(last1.getItem()).getCount()];
		
		
		//RANDOM
		ability1Point+=first1.getCount()*powerRates[table.findNode(first1.getItem()).getCount()] [table.findNode(afterRandom.get(0).getItem()).getCount()];
		ability1Point+=middle11.getCount()*powerRates[table.findNode(middle11.getItem()).getCount()] [table.findNode(afterRandom.get(1).getItem()).getCount()];
		ability1Point+=middle12.getCount()*powerRates [table.findNode(middle12.getItem()).getCount()] [table.findNode(afterRandom.get(2).getItem()).getCount()];
		ability1Point+=last1.getCount()*powerRates[table.findNode(last1.getItem()).getCount()] [table.findNode(afterRandom.get(3).getItem()).getCount()];
		
		ability2Point+=first2.getCount()*powerRates[table.findNode(afterRandom.get(0).getItem()).getCount()] [table.findNode(first1.getItem()).getCount()];
		ability2Point+=middle21.getCount()*powerRates[table.findNode(afterRandom.get(1).getItem()).getCount()] [table.findNode(middle11.getItem()).getCount()];
		ability2Point+=middle22.getCount()*powerRates [table.findNode(afterRandom.get(2).getItem()).getCount()] [table.findNode(middle12.getItem()).getCount()];
		ability2Point+=last2.getCount()*powerRates[table.findNode(afterRandom.get(3).getItem()).getCount()] [table.findNode(last1.getItem()).getCount()];

		
		
		System.out.println();
		System.out.println();

	
		 // karşılaştırmaya göre ability1point ve ability2point i int çevirip ikisinin birbirine göre yüzdesini alma
		
		Double x=ability1Point*10;       // 4.498350898940 => 44.9835 => 45
		Integer y = x.intValue();
		
		
		Double xx=ability2Point*10;      // 7.2312312321 => 72.3112 => 72
		Integer yy=xx.intValue();
	
		System.out.println(y);   //45
		System.out.println(yy);   //72 
		
		
		
		System.out.println("\t " + first1.getItem() +  												      				"\t \t \t \t \t \t \t" + first2.getItem() +"\n"+ 
						   "\t  ("+ first1.getCount() +")" 	+											   				"\t \t \t \t \t \t \t" + "("+ first2.getCount() +")" +"\n"+
						   middle11.getItem() +  "\t     \t  "+ middle12.getItem()+ 					   				"\t \t \t \t \t"  +	middle21.getItem() +  "\t  \t  "+ middle22.getItem()+"\n"+ 	
						   "("+middle11.getCount()+")" +  "\t    \t  "+ "("+middle12.getCount()+")"+					"\t \t \t \t \t"  +"("+middle21.getCount()+")" +  "\t  \t  "+ "("+middle22.getCount()+")"  + "\n"+
						   "\t " + last1.getItem() + 																" \t \t \t \t \t \t \t" +last2.getItem() +  "\n"+ 	
						   "\t  ("+ last1.getCount() +")" +																"\t \t \t    \t \t \t \t" + "("+ last2.getCount() +")" + "\n");
					
		
		
		System.out.println("First Win Change: " + y*100/(y+yy));    //45=>%40
		System.out.println("Second Win Change: " + yy*100/(y+yy));  //72=>%60
		}
	}
		
	
	
	
	
	
	
	public  void printTable() {   // güç oranları
		for (int row = 0; row < powerRates.length; row++) {
			for (int column = 0; column < powerRates[row].length; column++) {
				  System.out.print(powerRates[row][column] +"\t");
			}
			System.out.println();
		}
	}
	
	
}
