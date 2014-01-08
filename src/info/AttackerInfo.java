package info;

import java.util.List;

import output.EfficiencyMap;

public class AttackerInfo {

	public AttackerInfo(String strFileName) {
		attacker  = InfoCollector.convertFileTo2DObject(strFileName,defaultFileName);
		width = InfoCollector.getMinWidth(attacker);
		height = attacker.size();
		setName(strFileName);
	}
	
	private void setName(String strFileName) {
		if(strFileName!=null && !"".equalsIgnoreCase(strFileName)){
			fileName = strFileName;
		}
		else
			fileName = defaultFileName;
		int index = fileName.lastIndexOf(".");
		fileName = fileName.substring(0,index);
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	public String getName(){
		return fileName;
	}

	public List<List<Character>> getMatrix() {
		return attacker;
	}
	
	private String defaultFileName = "Ravager.blf";
	private String fileName;
	private List<List<Character>> attacker; 
	private int width,height;
}
