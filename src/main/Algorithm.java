package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;



public class Algorithm {
	
	private int size;
	private int popTime;
	private double crossing;
	private double mutation;
	private int time;

	
	private double fmin; 
	private double fmax;
	private int interspace; 
	private int number;
	private int canalNumber;
	
	private List<Chromosome> population;
	private Chromosome elite;
	

	public Algorithm(int size, int popTime, double crossing, double mutation, int time) {
		this.size=size;
		this.popTime=popTime;
		this.crossing=crossing;
		this.mutation=mutation;
		this.time=time;
	}

	public String start(double fmin, double fmax, int interspace, int number) {
		
		this.fmin=fmin;
		//System.out.println(fmin);
		this.fmax=fmax;
		//System.out.println(fmax);
		this.interspace=interspace;
		this.number=number;
		canalNumber = (int) ((fmax-fmin)/interspace)+1;
		
		population = createPopulation();
		if(population.size()<1) {
			String s = "Problem z wygenerowaniem populacji pierwotnej.";
			return s;
		}
		sort();
		
		int count = 0;
		
		long end = System.currentTimeMillis() + time*1000;
		/*for(Chromosome c : population)
		{
			System.out.println(c.toString());
		}*/
		
		while(System.currentTimeMillis()<end) {
			
			//System.out.println("ITERACJA "+v);
			cross();
			mute();
			sort();
			count++;
			/*for(Chromosome c : population)
			{
				System.out.println(c.toString());
			}*/
			
		}
		
		String info = "Przeprowazono "+count+" iteracji. Najlepszy wynik: "+population.get(0).toString();
		
		return info;
		
		
		
	}

	private void mute() {
		Random rand = new Random();
		Integer size = population.size();
	    	       	        
	       for(int i=0; i<size; i++)
	       {
	            double x = rand.nextDouble();
	            if(x>mutation)
	            {
	                continue;
	            }
	            
	            int numbermutations = rand.nextInt(number-1)+1;
	            for(int j=0; j<numbermutations; j++) {
	            	population.get(i).changePoint(rand.nextInt(number), (rand.nextInt(canalNumber)*interspace)+fmin);
	            }
	            
	            
	        }
		
	}

	private void cross() {
		Random rand = new Random();
		Integer size = population.size();
	    Integer NumberOfPair=size/2;
	       	        
	       for(int i=0; i<NumberOfPair; i++)
	       {
	            double x = rand.nextDouble();
	            if(x>crossing)
	            {
	                continue;
	            }
	            Integer Index1 = rand.nextInt(NumberOfPair);
	            Integer Index2 = rand.nextInt(NumberOfPair);
	            
	            List<Chromosome> Children = new ArrayList();
	            Children=crossThisPair(population.get(Index1), population.get(Index2));
	            population.addAll(Children);
	        }
	        
		
	}

	private List<main.Chromosome> crossThisPair(main.Chromosome chromosome1, main.Chromosome chromosome2) {
		
		Random random = new Random();
		List<Double> points1 = copy(chromosome1.getPoints());
		List<Double> points2 = copy(chromosome2.getPoints());
		
		int numberchange = random.nextInt(points1.size()-1)+1;
		
		for(int i=0; i<numberchange;i++) {
			int index1 = random.nextInt(points1.size());
			int index2 = random.nextInt(points2.size());
			double tmp = points1.get(index1);
			points1.set(index1, points2.get(index2));
			points2.set(index2, tmp);
		}
		
		List<Chromosome> list = new ArrayList();
		list.add(new Chromosome(points1));
		list.add(new Chromosome(points2));
		
		return list;
	}

	private List<Double> copy(List<Double> points) {
		ArrayList<Double> list = new ArrayList();
		for(Double d : points)
		{
			list.add(d);
		}
		return list;
	}

	private void sort() {
	
		
		for(int i=0; i<population.size(); i++)
		{
			if(!population.get(i).checkGolomb()) {population.remove(i); i--;};
		}
		
		for(Chromosome c : population) {
			c.countCost();
			
		}
		
		if(elite!=null)
		population.add(elite);
		
		Collections.sort(population);
		
		if(population.get(0)!=null)
			elite = population.get(0);
		
		if(checkEqual(population.get(0), population.get(1))) {
			population.remove(0);
		}
				
		for(int i = size; i<population.size(); i++) {
			population.remove(i);
			i--;
		}			
		
	}

	private boolean checkEqual(Chromosome chromosome, Chromosome chromosome2) {
		ArrayList<Double> list1 = (ArrayList<Double>) chromosome.getPoints();
		Collections.sort(list1);
		ArrayList<Double> list2 = (ArrayList<Double>) chromosome.getPoints();
		Collections.sort(list2);
		
		for(int i=0; i<chromosome.getPoints().size(); i++) {
			if(list1.get(i)!=list2.get(i))
				return false;
			
		}
		return true;
	}

	private List<Chromosome> createPopulation() {
		
		ArrayList<Chromosome> list = new ArrayList<Chromosome>();
		int n = 0;
		boolean flag = true; 
		long end = System.currentTimeMillis() + popTime*1000;
		
		while (n<size && flag)
		{
			
			Chromosome chrom = makeChromosome();	
			if(chrom.checkGolomb()) {
				list.add(makeChromosome());
				//System.out.println(chrom.toString());
				n++;
			}
			
			if(System.currentTimeMillis()>end) {flag=false;};
			
			
		}
		
		return list;
		
	
	}

	private Chromosome makeChromosome() {
		
		ArrayList<Double> points = new ArrayList<Double>();
		Random random = new Random();
		int[] tab = new int[canalNumber];
		for(int i =0; i<canalNumber; i++)
		{
			tab[i]=i;
		}
		
		int NewCanalNumber = canalNumber;
		
		for(int j=0; j<number; j++)
			{				
				int rand = random.nextInt(NewCanalNumber);
				if(rand<0) {rand=rand*(-1);};
				
				Double point = (tab[rand]*interspace)+fmin;
				points.add(point);
				
				int tmp = tab[NewCanalNumber-1];
				tab[NewCanalNumber-1] = tab[rand];
				tab[rand] = tmp;
				
				NewCanalNumber--;
	
			}
				
		Chromosome chrom = new Chromosome(points);
		
		return chrom;
	}

	

}
