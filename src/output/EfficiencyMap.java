package output;

import info.AttackerInfo;
import info.DetectorInfo;
import info.InfoCollector;

import java.util.ArrayList;
import java.util.List;

public class EfficiencyMap {
	private List<List<Double>> effMap;
	
	private int bestX;
	private int bestY;
	
	private double highestEff=Integer.MIN_VALUE;
	
	
	public int getBestX() {
		return bestX;
	}


	public int getBestY() {
		return bestY;
	}

	public double getHighestEff() {
		return highestEff;
	}
	public  List<List<Double>> getMap(){
		if(effMap == null)
			effMap = new ArrayList<List<Double>>();
		return effMap;
	}
	
	
	public void generateBestCoOrdinates(DetectorInfo oDetector, AttackerInfo oAttacker){
		
		for(int row=0;row<oDetector.getHeight()- oAttacker.getHeight() -1;row++){
			for(int col=0;col<oDetector.getWidth()- oAttacker.getWidth() -1;col++){
				if(effMap.get(row).get(col) > highestEff){
					highestEff = effMap.get(row).get(col);
					bestX = row;
					bestY = col;
				}
			}
		}		
	}
	
	
	
}
