/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Chromosome implements Comparable<Chromosome>, Serializable{
    
    private List<Double> points;
    private double cost = -1;
    
    public double getCost()
    {
    	return cost;
    }
    
    public List<Double> getPoints(){
    	return points;
    }
    
    public void changePoint(int index, double value) {
    	points.set(index, value);
    }
    
    public Chromosome(List<Double> points)
    {
       this.points=points;
    
    }
    
    public void countCost(){
    	
    	Collections.sort(points);
    	try {
    		cost = points.get(points.size()-1)-points.get(0);
    	} catch(Exception e) {
    		cost = -1;
    	}
    	
    	
    }   
       
    @Override
    public String toString() {
    	
    	Collections.sort(points);
    	String s = "";
    	for(int i=0; i<points.size(); i++)
    	{
    		s+=points.get(i)+" ";
    	}
    	
    	return s;
    	
    }

    
    @Override
    public int compareTo(Chromosome o) {
        if(cost<o.cost)
        {
            return -1;
        } else if(cost==o.cost)
        {
            return 0;
        } else
        {
            return 1;
        }
    }

	public boolean checkGolomb() {
		
				
		ArrayList<Double> distances = new ArrayList<Double>();
		int index = 1;
		
		for(int i=1; i<points.size(); i++)
		{
			for(int j=0; j<index; j++) {
				
				//System.out.println(points.get(i) + " "+ points.get(j));
				double distance = points.get(i)-points.get(j);
				if(distance<0) {distance*=(-1);};
				//System.out.println(distance);
				if(distances.contains(distance)) {
					//System.out.println("false");
					return false;
				} else {
					distances.add(distance);
				}				
			}
			index++;
				
		}
		
		//System.out.println("true");
		return true;
	}
    
}
