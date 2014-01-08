package info;

import java.util.List;

public class DetectorInfo {

	public DetectorInfo(String strFileName) {
		detector  = InfoCollector.convertFileTo2DObject(strFileName,defaultFileName);
		width = InfoCollector.getMinWidth(detector);
		height = detector.size();
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public List<List<Character>> getMatrix() {
		return detector;
	}
	
	private String defaultFileName = "DetectorOutput.blf";
	private List<List<Character>> detector; 
	private int width,height;
}
