package main;
import info.AttackerInfo;
import info.DetectorInfo;
import info.InfoCollector;

import java.util.List;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import output.EfficiencyMap;
import output.ResultPrinter;


public class MainDetector {

	public static void main(String args[]){
		
        System.out.println("--------------------- Torpedos Detector----------------------");
        
        
        Options options = new Options();
        options.addOption("detector", true, "[fileName] Input File which will provide area to detect. Default: DetectorOutput.blf");
        options.addOption("attacker", true, "[fileName] Input File which will provide torpedoes. Default: ProtonTorpedo.blf");
       
        CommandLineParser parser = new BasicParser();
        CommandLine cmd;
        try{
            cmd = parser.parse(options, args);
        }catch (ParseException pe){
            usage(options);
            return;
        }
        
        DetectorInfo oDetector = new DetectorInfo(cmd.getOptionValue("detector"));
        AttackerInfo oAttacker = new AttackerInfo(cmd.getOptionValue("attacker"));
        TorpedosFinder finder = new TorpedosFinder(oDetector,oAttacker);
        EfficiencyMap effMap = finder.execute();
        effMap.generateBestCoOrdinates(oDetector, oAttacker);
        System.out.println("\n-----------------------------------------------------------");
        System.out.println("      ---------------------Results----------------------");
        System.out.println("-------------------------------------------------------------");
        System.out.println("Attacker Name        : "+oAttacker.getName());
        System.out.println("Attacker Location    : X : "+effMap.getBestX() +" Y : "+effMap.getBestY() );
        System.out.println("Degree Of Confidence : "+effMap.getHighestEff());
        System.out.println("Pattern              : ");
        ResultPrinter.printBestMatch(oDetector,oAttacker,effMap.getBestX(),effMap.getBestY());
	}




	   /**
     * Display command line options available
     *
     * @param options the options
     */
    private static void usage(Options options){
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp( "java -jar torpedoDetector.jar", options );
    }
}
