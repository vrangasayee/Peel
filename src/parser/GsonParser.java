package parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.Gson;

import model.InputData;

public class GsonParser {
	public InputData parseFromFile(String filename) throws IOException {
		String inputString = new String(Files.readAllBytes(Paths.get(filename)));
		InputData input = new Gson().fromJson(inputString, InputData.class);
		return input;
	}
}
