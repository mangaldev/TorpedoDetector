package info;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InfoCollector {


	@SuppressWarnings("resource")
	public static List<List<Character>> convertFileTo2DObject(String fileName,String defaultFileName){
		List<List<Character>> input  = new ArrayList<List<Character>>();
		File file = null;
		Scanner sc = null;
		try{
			if(fileName!=null && !"".equalsIgnoreCase(fileName)){
				file = new File(fileName);		
				sc = new Scanner(file);
			}
			else
				sc = new Scanner(ClassLoader.getSystemResourceAsStream(defaultFileName));
		}
		catch(Exception e){
//			e.printStackTrace();
			System.out.printf("\nFile %s doesnt exist, defaulting to %s \n", fileName,defaultFileName);
			sc = new Scanner(ClassLoader.getSystemResourceAsStream(defaultFileName));
		}

		int height = -1,width =0 ;
		String line;
		while(sc.hasNextLine()){
			height++;
			line = sc.nextLine();
			width = line.length();
			if(width>0)
				input.add(new ArrayList<Character>());
			for(int i =0;i<width;i++){
				input.get(height).add(line.charAt(i));
			}
		}
		return input;
	}


	public  static void print2DArray(List<List<Double>> input){
		for (int i = 0; i < input.size(); i++) {
			System.out.println();
			List list = input.get(i);
			for (int j = 0; j < list.size(); j++) {
				System.out.print(list.get(j));
			}
		}
	}
	


	public static int getMinWidth(List<List<Character>> matrix) {
		int width = Integer.MAX_VALUE;
		for(int i = 0;i<matrix.size();i++)
		{
			if(matrix.get(i).size() < width)
				width = matrix.get(i).size();
		}
		return width;
	}

}
