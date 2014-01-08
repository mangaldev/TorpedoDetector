package main;

import java.util.ArrayList;

import output.EfficiencyMap;
import info.AttackerInfo;
import info.DetectorInfo;

public class TorpedosFinder {

	private AttackerInfo oAttacker;
	private DetectorInfo oDetector;
	private EfficiencyMap effMap ;

	public TorpedosFinder(DetectorInfo oDetector, AttackerInfo oAttacker) {
		this.oAttacker = oAttacker;
		this.oDetector = oDetector;
	}

	public EfficiencyMap execute(){
		effMap = new EfficiencyMap();
		for(int row=0;row<oDetector.getHeight() - oAttacker.getHeight() -1;row++){
			effMap.getMap().add(new ArrayList<Double>());
			for(int col=0;col<oDetector.getWidth() - oAttacker.getWidth() -1;col++){
				int count = 0;
				for(int i=row;i<row + oAttacker.getHeight();i++){
					for(int j=col;j<col+ oAttacker.getWidth();j++){
						if((oDetector.getMatrix().get(i).get(j)== ' ') &&  (oAttacker.getMatrix().get(i-row).get(j-col)) == ' ')
							count++;
						else if((oDetector.getMatrix().get(i).get(j)== '+') &&  (oAttacker.getMatrix().get(i-row).get(j-col)) == '+')
							count++;
					}
				}
				double prob = (count*100.0)/(oAttacker.getWidth() * oAttacker.getHeight() * 1.0);
				effMap.getMap().get(row).add(prob);

			}
		}
		return effMap;
	}	
}
