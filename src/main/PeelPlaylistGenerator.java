package main;

import java.io.EOFException;
import java.io.IOException;
import java.util.Scanner;

import model.InputData;
import parser.GsonParser;

public class PeelPlaylistGenerator {
	private static final String THANKYOU = "Thank you for using playlist generator";
	private static final String LOOKUP_PROMPT = "Enter Lookup value: (Enter 'quit' to quit)";
	private static final String ERRORSTRING = "Error parsing JSON file";;
	private String contentName = "";
	private String country = "" ;
	
	private InputData input = null;
	
	public PeelPlaylistGenerator(String filename) throws IOException {
		GsonParser gson = new GsonParser();
		input = gson.parseFromFile(filename);
	}
	
	private void getUserInput() throws EOFException {
		Scanner in = new Scanner(System.in);
		System.out.println(LOOKUP_PROMPT);
		String lookupValue = in.nextLine();
		if ("quit".equalsIgnoreCase(lookupValue)) {
			throw new EOFException();
		}
		String[] lookupList = lookupValue.split(",");
		contentName = lookupList[0].trim();
		if (lookupList.length == 2) {
			country = lookupList[1].trim();
		}
	}
	
	private String lookup() {
		return input.lookup(contentName, country);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length != 1) {
			System.out.println("Usage: PeelPlaylistGenerator <filename>\n"
					+ "filename - fullpath of the input file");
			System.exit(-1);
		}
		
		try {
			PeelPlaylistGenerator ppgObj = new PeelPlaylistGenerator(args[0]);
			while(true) {
				ppgObj.getUserInput();
				System.out.println(ppgObj.lookup());
			}
			
		} catch (EOFException ee) {
			System.out.println(THANKYOU);
		} catch (Exception e) {
			System.out.println(ERRORSTRING);
		}
		
		
       
	}	
}