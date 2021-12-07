import javax.swing.SwingUtilities;
public class Main {

	public static void main(String[] args) {
		
		Environnement env =new Environnement();
		
		env.initialiser(env);
		
		
		String[] memo=new String[10];
	
		for(int i =0;i<10;i++)
		
		{
			memo[i]="0";
		}
		
		Agent[] agent_list= new Agent[20];
		
		Agent agent1= new Agent(1,memo,"0",45,9,null,3);
		agent_list[1]=agent1;
		Agent agent2= new Agent(2,memo,"0",30,0,null,3);
		agent_list[2]=agent2;
		Agent agent3= new Agent(3,memo,"0",24,9,null,3);
		agent_list[3]=agent3;
		Agent agent4= new Agent(4,memo,"0",18,0,null,3);
		agent_list[4]=agent4;
		Agent agent5= new Agent(5,memo,"0",49,7,null,3);
		agent_list[5]=agent5;
		Agent agent6= new Agent(6,memo,"0",8,34,null,3);
		agent_list[6]=agent6;
		Agent agent7= new Agent(7,memo,"0",29,20,null,3);
		agent_list[7]=agent7;
		Agent agent8= new Agent(8,memo,"0",39,6,null,3);
		agent_list[8]=agent8;
		Agent agent9= new Agent(9,memo,"0",32,2,null,3);
		agent_list[9]=agent9;
		Agent agent10= new Agent(10,memo,"0",15,9,null,3);
		agent_list[10]=agent10;
		Agent agent11= new Agent(11,memo,"0",44,9,null,3);
		agent_list[11]=agent11;
		Agent agent12= new Agent(12,memo,"0",37,6,null,3);
		agent_list[12]=agent12;
		Agent agent13= new Agent(13,memo,"0",2,9,null,3);
		agent_list[13]=agent13;
		Agent agent14= new Agent(14,memo,"0",6,0,null,3);
		agent_list[14]=agent14;
		Agent agent15= new Agent(15,memo,"0",10,7,null,3);
		agent_list[15]=agent15;
		Agent agent16= new Agent(16,memo,"0",40,3,null,3);
		agent_list[16]=agent16;
		Agent agent17= new Agent(17,memo,"0",20,20,null,3);
		agent_list[17]=agent17;
		Agent agent18= new Agent(18,memo,"0",19,6,null,3);
		agent_list[18]=agent18;
		Agent agent19= new Agent(19,memo,"0",6,2,null,3);
		agent_list[19]=agent19;
		Agent agent20= new Agent(20,memo,"0",10,9,null,3);
		agent_list[0]=agent20;
		
	
		
		

		 
		 for(int i =1;i<50 ; i++)
		 {
		  
			  
		  agent2.Action(agent2, env,agent_list);
		  System.out.println();
		  
		  agent1.Action(agent1, env,agent_list);
		  System.out.println();
		  
		  agent4.Action(agent4, env,agent_list);
		  System.out.println();
		  
		  agent5.Action(agent5, env,agent_list);
		  System.out.println();
		  
		  agent6.Action(agent6, env,agent_list);
		  System.out.println();
		  
		  agent7.Action(agent7, env,agent_list);
		  System.out.println();
		  
		  agent3.Action(agent3, env,agent_list);
		  System.out.println();
		  
		  agent8.Action(agent8, env,agent_list);
		  System.out.println();
		  
		  agent9.Action(agent9, env,agent_list);
		  System.out.println();
		  
		  agent10.Action(agent10, env,agent_list);
		  System.out.println();
		  
		  agent11.Action(agent11, env,agent_list);
		  System.out.println();
		  
		  agent12.Action(agent12, env,agent_list);
		  System.out.println();
		  
		  agent13.Action(agent13, env,agent_list);
		  System.out.println();
		  
		  agent14.Action(agent14, env,agent_list);
		  System.out.println();
		  
		  agent15.Action(agent15, env,agent_list);
		  System.out.println();
		  
		  agent16.Action(agent16, env,agent_list);
		  System.out.println();
		  
		  agent17.Action(agent17, env,agent_list);
		  System.out.println();
		  
		  agent18.Action(agent18, env,agent_list);
		  System.out.println();
		  
		  agent19.Action(agent19, env,agent_list);
		  System.out.println();
		  
		  agent20.Action(agent20, env,agent_list);
		  System.out.println();
		 
		  
		 }
		
		 
		 
	
	}}
	


