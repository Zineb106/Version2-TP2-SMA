import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Agent {

	int id;
	String[] memo=new String[10];
	String situation_agt;
	Agent companie;
	int col;
	int row;
	int temps;
	
	
	public
	Map<String, String[] > perception(Agent agent,Environnement env_sys) 
	{
		
		Map<String, String[]> env = new HashMap<String, String[]>();
		env.put("memo", this.memo);
		
		String[] eta_post=new String[1];
		eta_post[0]=env_sys.grille[agent.row][agent.col];
		
		env.put("eta_post", eta_post);
		
		
		return (env);
		
	}
	
	
	Agent(){}
	
	public Agent(int id2, String[] memo2, String situation, int row2, int col2,Agent companie,int T) {
		
		this.id=id2;
		this.memo=memo2;
		this.situation_agt=situation;
		this.col=col2;
		this.row=row2;
		this.companie=companie;
		this.temps=T;
	}

	
	void Action (Agent agent,Environnement env_sys,Agent[] agent_list)
	{
		

		
		
		String[] memo =agent.memo;
	    String[] eta_post=perception(agent,env_sys).get("eta_post");
	    

		if (agent.situation_agt==null) {agent.situation_agt="0";}
		
	    if (eta_post[0] == "0")
	    { 
	      if(agent.situation_agt=="0") 
	      {
	    	    
	    		System.out.println("l'état de poste est : "+eta_post[0]+" et la situation de l'agent est "+agent.situation_agt);
	    		System.out.println("l'agent "+agent.id+" avance d'un pas ");
	    		agent.Avancer (agent);
	    		ajouter_memo(memo,eta_post);
	    		
	       }
	      else 
	      {
	    	if(agent.situation_agt=="A")
	    	{   
	    		System.out.println("l'état de poste est : "+eta_post[0]+" et la situation de l'agent est "+agent.situation_agt);	 
	    		int result=Calcul_Proba("A", agent, env_sys);
		    	if(result==0) 
		    	{  
		    		
		    		System.out.println("l'agent "+agent.id+" dépose l'objet A");
		    		env_sys.grille[agent.row][agent.col]="A";
		    		eta_post[0]=env_sys.grille[agent.row][agent.col];
		    		agent.situation_agt="0";
		    		agent.Avancer(agent);
		    		System.out.println("l'etat de poste devient "+eta_post[0]);
		    	}
		    	else
		    	{
		    		
		    		System.out.println("l'agent "+agent.id+" porte toujours l'objet "+agent.situation_agt);
		    		System.out.println("l'agent "+agent.id+" avance d'un pas");
		    		agent.Avancer (agent);
		    		ajouter_memo(memo,eta_post);
	    		}
	    	} 
	    	else
	    	{
	    	    if(agent.situation_agt=="B") 
	    		{
	    	       System.out.println("l'etat du poste est "+eta_post[0]+" et la situation de l'agent est "+agent.situation_agt);	 
	    	       int result=Calcul_Proba("B", agent, env_sys);
		    	   if(result==0)
		    	   {
			    		
			    		System.out.println("l'agent "+agent.id+" dépose l'objet B");
			    		env_sys.grille[agent.row][agent.col]="B";
			    		eta_post[0]=env_sys.grille[agent.row][agent.col];
			    		agent.situation_agt="0";
			    		agent.Avancer(agent);
			    		System.out.println("l'etat de poste devient "+eta_post[0]);	
		    	   }
		    	   else 
		    	   {
			    		System.out.println("l'agent "+agent.id+" porte toujours l'objet "+agent.situation_agt);
			    		System.out.println("l'agent "+agent.id+" avance d'un pas");
			    		agent.Avancer (agent);
			    		ajouter_memo(memo,eta_post);
		    		}
	           }
	    	   else
	    	   {
	    		   if(agent.situation_agt=="C") 
	    		{
	    		   System.out.println("l'etat du poste est "+eta_post[0]+"et la situation des deux l'agents est "+agent.situation_agt);	   
	    	       int result=Calcul_Proba("C", agent, env_sys);
	    	       int result2=Calcul_Proba("C", agent.companie, env_sys);
		    	   if(result==0 || result2==0)
		    	   {

			    		System.out.println("l'agent "+agent.id+" et l'agent "+agent.companie.id+" déposent l'objet C");
			    		env_sys.grille[agent.row][agent.col]="C";
			    		eta_post[0]=env_sys.grille[agent.row][agent.col];
			    		agent.situation_agt="0";
			    		agent.companie.situation_agt="0";
			    		agent.Avancer(agent);
			    		agent.companie.Avancer(agent.companie);
			    		agent.temps=3;
			    		agent.companie.temps=3;
			    		agent.companie.companie=null;
			    		agent.companie=null;
			    		System.out.println("l'etat de poste devient "+eta_post[0]);	
		    	   }
		    	   else 
		    	   {
			    		System.out.println("l'agent "+agent.id+" et l'agent "+agent.companie.id+" porte toujours l'objet "+agent.situation_agt);
			    		System.out.println("l'agent "+agent.id+" et l'agent "+ agent.companie.id+" avancent d'un pas");
			    		agent.Avancer2 (agent,agent.companie);
			    		ajouter_memo(memo,eta_post);
			    		ajouter_memo(agent.companie.memo,eta_post);
		    		}
	           }
	    		   else System.out.println("erreur !");
	    	  }
	        }
	      }
	    }
	    	
	    else
	    {
	    	if (eta_post[0]== "A") 
	    	{ 
	    		if(agent.situation_agt=="0") 
	    		{   
	    			System.out.println("l'etat du poste est "+eta_post[0]+" et la situation de l'agent est "+agent.situation_agt);
	    			int result=Calcul_Proba("A", agent, env_sys);
	    			if(result==1) 
	    			{   

	    				System.out.println("l'agent "+agent.id+" prend l'objet A");
	    				agent.situation_agt="A";
	    				env_sys.grille[agent.row][agent.col]="0";
	    				eta_post[0]=env_sys.grille[agent.row][agent.col];
	    				agent.Avancer(agent);
			    		System.out.println("etat de poste devient "+eta_post[0]);	
	    				
	                 }
	    			
	    	      else 
	    	         {

			    		System.out.println("l'agent "+agent.id+" ne porte toujours rien");
			    		System.out.println("l'agent "+agent.id+" avance d'un pas");
			    		agent.Avancer (agent);
			    		ajouter_memo(memo,eta_post);
			    		System.out.println("etat de poste devient "+eta_post[0]);
	    		     }
	    		}
	    		else
	    		{
	    			System.out.println("l'etat du poste est "+eta_post[0]+" et la situation de l'agent est "+agent.situation_agt);
		    		System.out.println("l'agent "+agent.id+" ne porte toujours rien");
		    		System.out.println("l'agent "+agent.id+" avance d'un pas");
		    		agent.Avancer (agent);
		    		ajouter_memo(memo,eta_post);
		    		System.out.println("etat de poste devient "+eta_post[0]);
   		        }
	    	}
	    	
	    	 else 
	    	 { 
	    		 if (eta_post[0]== "B") 
	 	    	{ 
	 	    		if(agent.situation_agt=="0") 
	 	    		{ 
	 	    			System.out.println("l'etat du poste est "+eta_post[0]+" et la situation de l'agent est "+agent.situation_agt);
	 	    			int result=Calcul_Proba("B", agent, env_sys);
	 	    			if(result==1) 
	 	    			{   
				    		
		    				System.out.println("l'agent "+agent.id+" prend l'objet B");
		    				agent.situation_agt="B";
		    				env_sys.grille[agent.row][agent.col]="0";
		    				eta_post[0]=env_sys.grille[agent.row][agent.col];
		    				agent.Avancer(agent);
				    		System.out.println("etat de poste devient "+eta_post[0]);	
	 	                 }
	 	    			   
	 	    	         else 
	 	    	         {
				    		
				    		System.out.println("l'agent "+agent.id+" ne porte toujours rien");
				    		System.out.println("l'agent "+agent.id+" avance d'un pas");
				    		agent.Avancer (agent);
				    		ajouter_memo(memo,eta_post);
				    		System.out.println("etat de poste devient "+eta_post[0]);
	 	    		     }
	 	    		}
	    	 
	    		 else {
	    			    
	    			 System.out.println("l'etat du poste est "+eta_post[0]+" et la situation de l'agent est "+agent.situation_agt);
			    		System.out.println("l'agent "+agent.id+" porte toujours l'objet "+agent.situation_agt);
			    		System.out.println("l'agent "+agent.id+" avance d'un pas");
			    		agent.Avancer (agent);
			    		ajouter_memo(memo,eta_post);
			    		System.out.println("l'etat de poste devient " +eta_post[0]);
	    		 
	    		      }
	    	  }
	    	  else 
	    	  {
	    		  if (eta_post[0]== "C") 
	 	    	  { 
	 	    		if(agent.situation_agt=="0") 
	 	    		{   
	 	    			System.out.println("l'etat du poste est "+eta_post[0]+" et la situation de l'agent est "+agent.situation_agt);
	 	    			int result=Calcul_Proba("C", agent, env_sys);
	 	    			if(result==1) 
	 	    			{   
	 	    				int temps=agent.temps;
				    		System.out.println("Nombre d'essaie restant = "+temps);
				    		if(temps > 0)
				    		{
				    			
				    		System.out.println("l'agent "+agent.id+" envoie un signal");
				    		Agent agentF=envoie_signal(agent,agent_list,20,5);
				    		
				    		if (agentF!=null) {
				    		
				    			System.out.println("l'agent "+agentF.id+" a bien recu votre signal ");
				    			agentF.col=agent.col;
				    			agentF.row=agent.col;
				    			System.out.println("l'agent "+agent.id+" et l'agent "+agentF.id+" prennent l'objet C");
				    			agent.situation_agt="C";
				    			agentF.situation_agt="C";
			    				env_sys.grille[agent.row][agent.col]="0";
			    				eta_post[0]=env_sys.grille[agent.row][agent.col];
			    				agentF.companie=agent;
			    				agent.companie=agentF;
			    				Avancer2(agent,agentF);
			    				System.out.println("etat de poste devient "+eta_post[0]);		
				    			
				    		}
				    		else System.out.println("Essayer aprés, Aucun Robot ne recois votre signal");
				    			
				    		}
				    		else {
				    			System.out.println("Temps d'attente écoler, abondonner l'objet et Avancer !");
				    			agent.Avancer(agent);
				    			System.out.println("l'agent "+agent.id+" abondonne l'objet C et avance");
				    			ajouter_memo(memo,eta_post);
				    			
				    		}
	 	                 }
	 	    			   
	 	    	         else 
	 	    	         {
				    		System.out.println("etat de poste "+eta_post[0]);
				    		System.out.println("l'agent "+agent.id+" ne porte toujours rien");
				    		System.out.println("l'agent "+agent.id+" avance d'un pas");
				    		agent.Avancer (agent);
				    		ajouter_memo(memo,eta_post);
				    		System.out.println("etat de poste devient "+eta_post[0]);
	 	    		     }
	 	    		}
	    	 
	    		 else {
			    		System.out.println("etat de poste "+eta_post[0]);
			    		System.out.println("l'agent "+agent.id+"porte deja l'objet"+agent.situation_agt);
			    		System.out.println("l'agent "+agent.id+" avance d'un pas");
			    		agent.Avancer (agent);
			    		ajouter_memo(memo,eta_post);
			    		System.out.println("l'etat de poste devient " +eta_post[0]);
	    		 
	    		      }
	    	  }
	    		  else System.out.println("erreur");
	    	  
  		 
  		      }
	    	 }
	    }
	    }
	    	
	    
	    	
	    
	    	
	    
	    

	

    void Avancer(Agent agent)
    {
		int[] list_row = new int[3];
		list_row[0]=agent.row;
		list_row[1]=(agent.row)+1;
		list_row[2]=(agent.row)-1;
		
		int[] list_col= new int[3];
		list_col[0]=agent.col;
		list_col[1]=(agent.col)+1;
		list_col[2]=(agent.col)-1;
	
		if (agent.row==0) {list_row[2]=(agent.row)+1;}
		if (agent.col==0) {list_col[2]=(agent.col)+1;}
		if (agent.row==49) {list_row[1]=(agent.row)-1;}
		if (agent.col==49) {list_col[1]=(agent.col)-1;}
		
		Random random = new Random();
		int value = random.nextInt(3);
		int value1 = random.nextInt(3);
		
		agent.col=list_col[value];
		agent.row=list_row[value1];
			
    }
    void Avancer2(Agent agent,Agent agent2)
    {
		int[] list_row = new int[3];
		list_row[0]=agent.row;
		list_row[1]=(agent.row)+1;
		list_row[2]=(agent.row)-1;
		
		int[] list_col= new int[3];
		list_col[0]=agent.col;
		list_col[1]=(agent.col)+1;
		list_col[2]=(agent.col)-1;
	
		if (agent.row==0) {list_row[2]=(agent.row)+1;}
		if (agent.col==0) {list_col[2]=(agent.col)+1;}
		if (agent.row==49) {list_row[1]=(agent.row)-1;}
		if (agent.col==49) {list_col[1]=(agent.col)-1;}
		//if (agent2.row==0) {list_row[2]=(agent.col)+1;}
		//if (agent2.col==0) {list_col[2]=(agent.col)+1;}
		//if (agent2.row==49) {list_row[1]=(agent.col)-1;}
		//if (agent2.col==49) {list_col[1]=(agent.col)-1;}
		
		Random random = new Random();
		int value = random.nextInt(3);
		int value1 = random.nextInt(3);
		
		agent.col=list_col[value];
		agent.row=list_row[value1];
		agent2.col=list_col[value];
		agent2.row=list_row[value1];
		System.out.print(agent.row);
		System.out.print(agent.col);
		
		System.out.print(agent2.row);
		System.out.print(agent2.col);
			
    }
    
    void ajouter_memo(String[] memo,String[] eta_post) 
    { 	
    	for(int i=0; i<9; i++)
    	{
    		memo[i]=memo[i+1];
    	}
    	memo[9]=eta_post[0];
    }
    
	int Calcul_Proba (String objet,Agent agent,Environnement env_sys)
	{
	    
		String[] memo = perception(agent,env_sys).get("memo");
	    int t=memo.length;
	    double K_plus= 0.1;
	    double K_moins=0.3;
	    int cont_objet=0;
	    for (int i=0; i<t; i++)
	    {
	      if (memo[i] == objet) { cont_objet = cont_objet+1;}
	     
	    }
	    float F_objet =(float)(cont_objet*0.1);
	    double P_prise=(float) (K_plus /(K_plus+F_objet))*(K_plus /(K_plus+F_objet));
	    double P_depot=(float) (F_objet/(K_moins+F_objet))*(F_objet/(K_moins+F_objet));
	    System.out.println("P_depot = "+P_depot);
	    System.out.println("P_prise = "+P_prise);
	    if (P_prise>P_depot) return 1;
	    else return 0;

	}
	
	Agent  envoie_signal(Agent agent,Agent[] liste,int Intensité, int Ds)
	{
		float taux_propa = 1/Ds;
		int col=this.col;
		int row=this.row;
		Map<String, int[]> Pos =new HashMap<String, int[]>();
		agent.temps=agent.temps-1;
		
		
		
		int[] entourage_ligne= new int[Ds];
		int[] entourage_Col= new int[Ds];
		float[] Propagation_I= new float[Ds];
		
		for (int i=0;i<Ds;i++) {
			
			entourage_ligne[i]=row+i;
			entourage_Col[i]=col+i;
			Propagation_I[i]=Intensité-i*taux_propa;
			
			
		}
		Pos.put("lignes", entourage_ligne);
		Pos.put("colonnes", entourage_Col);
		
		Agent agentF=find_agent(agent,liste,Pos);
		return agentF;	
	}
	
	
	
	Agent find_agent(Agent agentS,Agent[] liste,Map<String, int[]> Pos) 
	{
		int[] entourage_Col= new int[4];
		int[] entourage_ligne= new int[4];
		
		entourage_ligne=Pos.get("lignes");
		entourage_Col=Pos.get("colonnes");
		
		for (int i=0;i<liste.length;i++)
		{
			
		 Agent agent = liste[i];
		 int col=agent.col;
		 int row=agent.row;
			
		 for (int j=0;j<entourage_Col.length;j++) 
		 {    
			if (agentS.col==col && agentS.row==row && agentS.id==agent.id) {}
			else 
			{
				if(col==entourage_Col[j]) 
				{
				  for(int k=0;k<entourage_ligne.length;k++) 
				  {
					if(row==entourage_ligne[k])
					{
						if(agent.situation_agt =="0") return agent;
					}
				  }
				}
			}
		}
	   }
	   return null;
	
	}


	
	
	
}
