package output;

import info.AttackerInfo;
import info.DetectorInfo;

public class ResultPrinter {

	public static void printBestMatch(DetectorInfo oDetector,
			AttackerInfo oAttacker,int x , int y) {
		
		
		for(int row=x;row<x+oAttacker.getHeight();row++){
			System.out.println();
			for(int col=y;col<y+oAttacker.getWidth();col++){
				if((oDetector.getMatrix().get(row).get(col)== ' ') &&  (oAttacker.getMatrix().get(row-x).get(col-y)) == ' ')
					System.out.print(' ');
				else if((oDetector.getMatrix().get(row).get(col)=='+') &&  (oAttacker.getMatrix().get(row-x).get(col-y)) == '+')
					System.out.print('+');
				else
					System.out.print(' ') ;

			}
		}
		
	}

	
}
