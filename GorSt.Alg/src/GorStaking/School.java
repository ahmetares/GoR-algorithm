package GorStaking;

public class School {
	

	 private static int week=0;
	
	Linkedlist ability = new Linkedlist();
	String first,last,middle1,middle2;
	
	
	public School() {
		
	}
	
	
	
	
	public School(String first,String last,String middle1,String middle2) {
	
		this.first=first; this.last=last; this.middle1=middle1; this.middle2=middle2;
		
		
		
	ability.add(last, 0);
	ability.add(middle2, 0);         //        first
	ability.add(middle1, 0);        //    mid1       mid2
	ability.add(first, 0); 		//		      last			

	}
	
	
	public void leveling(String skill) {
		setWeek(getWeek() + 1);
		
//		System.out.println("You are in the week: "+ getWeek() + " for: " + getClass().getName());
		
	
		
		//-------     ilk 2 hafta  zorunlu 1. kategori  ---------------
		
		if(getWeek()==1 || getWeek()==2) {
			if(skill.equals(getAbility().find(first))) {   //if skill.equals('hunt') da olur gibi
			
			Node develop= getAbility().findNode(skill);  
			int level = develop.getCount();
			level++;
			develop.setCount(level);
			
			}
		}
		
		//-------     eğer 4. kategori 2 olmuşsa devamı serbest    ---------------

		
		else if(ability.findNode(last).getCount()>=2) {
			
			Node develop= getAbility().findNode(skill);  
			int level = develop.getCount();
			level++;
			develop.setCount(level);
		}
		
		
		
		
		//-------     ilk 2 hafta 1.kategori seviye 2 sonrası ve 4. kategori 2 seviye olana kadar aradaki kısım    ---------------
		
		

		else if(getWeek() >= 3 ) {  
			
			//------------- 1. kategori --------------

			
			if(skill.equals(getAbility().find(first))) {  
			
				if(ability.findNode(middle1).getCount()<2 && ability.findNode(middle2).getCount()<2) {  //eğer 3 ve sonrası haftada ilk kat geliştirceksen (hunt) 2. ve 3. 2 degilse max 5e kadar yapabilirsin
				if(ability.findNode(first).getCount()<5) {
					
					Node develop= getAbility().findNode(skill);  
					int level = develop.getCount();
					level++;
					develop.setCount(level);
				}
			}
				
				
				else if(ability.findNode(middle1).getCount()==2 && ability.findNode(middle2).getCount()==2 && ability.findNode(first).getCount()<=7) { // eğer 3 ve sonrası ilk katı geliştirceksen (hunt) 2. ve 3. 2 ise max 7 ye kadar yapabilirsin  //alttaki fonk ile karıştığı için && sea.findNode("hunt").getCount()==7 eklendi
				 if(ability.findNode("hunt").getCount()<7) {
						
						Node develop= getAbility().findNode(skill);  
						int level = develop.getCount();
						level++;
						develop.setCount(level);
					}
				}
				
				 if(ability.findNode(last).getCount()>=1) {
				 if(ability.findNode(first).getCount()<10) {
							
							Node develop= getAbility().findNode(skill);  
							int level = develop.getCount();
							level++;
							develop.setCount(level);
						}
				}
				
		}
			
			
			//------------- 2. kategori --------------
			
			if(skill.equals(getAbility().find(middle1))) {
				
				 if(ability.findNode(last).getCount()==0) {   //eğer 2. kategoriyi (trade) geliştirmek istersen, eğer 4. kategori daha 0 sa (açılmamış/geliştirilmemiş) ise 2.yi max 2 seviyeye ye kadar geliştirebilirsin
					 if(ability.findNode(middle1).getCount()<2) {
						
						 Node develop= getAbility().findNode(skill);  
							int level = develop.getCount();
							level++;
							develop.setCount(level);
					 }
				 }
				 
				 else if(ability.findNode(last).getCount()>=1) { //eğer 2. kategoriyi (trade) geliştirmek istersen, eğer 4. kategori 1 ise max 3 seviyeye e kadar geliştirme yapabilirsin
					 if(ability.findNode(middle1).getCount()<3 ) {
						 Node develop= getAbility().findNode(skill);  
							int level = develop.getCount();
							level++;
							develop.setCount(level);
					 }
				 }
			
			}
			
			// ----------- 3. kategori ------------
			
			
			if(skill.equals(getAbility().find(middle2))) {
				
				 if(ability.findNode(last).getCount()==0) {   //eğer 3. kategoriyi (war) geliştirmek istersen, eğer 4. kategori daha 0 sa (açılmamış/geliştirilmemiş) ise 2.yi max 2 seviyeye ye kadar geliştirebilirsin
					 if(ability.findNode(middle2).getCount()<2 ) {
						
						 Node develop= getAbility().findNode(skill);  
							int level = develop.getCount();
							level++;
							develop.setCount(level);
					 }
				 }
				 
				 else if(ability.findNode(last).getCount()>=1) { //eğer 3. kategoriyi (war) geliştirmek istersen, eğer 4. kategori 1 ise max 3 seviyeye e kadar geliştirme yapabilirsin
					 if(ability.findNode(middle2).getCount()<3) {
						 Node develop= getAbility().findNode(skill);  
							int level = develop.getCount();
							level++;
							develop.setCount(level);
					 }
				 }
			
			}
			
			//--------------- 4. kategori --------------
			
			if(skill.equals(getAbility().find(last))) {
				
				if(ability.findNode(middle1).getCount()==2 && ability.findNode(middle2).getCount()==2) { //eğer 4. kategoriyi (magic) geliştirmek istersen 2. ve 3. kategori 2 seviye olmalı
				 if(ability.findNode(last).getCount()<1) {
					Node develop= getAbility().findNode(skill);  
						int level = develop.getCount();
						level++;
						develop.setCount(level);
				}
			}
				
				if ((ability.findNode(middle1).getCount()==3 && ability.findNode(middle2).getCount()==3) || ability.findNode(first).getCount()==10) {
					if(ability.findNode(last).getCount()<2) {
					Node develop= getAbility().findNode(skill);  
					int level = develop.getCount();
					level++;
					develop.setCount(level);
				  }
				}	
			}
		}
		
				
//		showlevels();
		System.out.println("------");

		
	}
	
	
	
	
	public void show() {
		System.out.println(getWeek());
	}
	
	
	public void showlevels() {
		ability.outputTheList();
	}

	
	public Linkedlist getAbility() {
		return ability;
	}

	public void setAbility(Linkedlist ability) {
		this.ability = ability;
	}


	public String getFirst() {
		return first;
	}


	public void setFirst(String first) {
		this.first = first;
	}


	public String getLast() {
		return last;
	}


	public void setLast(String last) {
		this.last = last;
	}


	public String getMiddle1() {
		return middle1;
	}


	public void setMiddle1(String middle1) {
		this.middle1 = middle1;
	}


	public String getMiddle2() {
		return middle2;
	}


	public void setMiddle2(String middle2) {
		this.middle2 = middle2;
	}




	public static int getWeek() {
		return week;
	}




	public static void setWeek(int week) {
		School.week = week;
	}
	
	

}
