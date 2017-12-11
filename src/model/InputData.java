package model;

import java.util.ArrayList;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class InputData {
	private static final String MISSING_CONTENT = "Cannot find content with name ";
	private static final String EMPTY_MESSAGE = "No legal playlist possible because the Pre-Roll Video isn't\n" + 
			"compatible with the aspect ratio of the Content Video for ";
	private ArrayList<Content> content;
	private ArrayList<Preroll> preroll;
	
	
	public ArrayList<Content> getContents() {
		return content;
	}
	
	public void setContents(ArrayList<Content> contents) {
		this.content = contents;
	}
	
	public ArrayList<Preroll> getPreroll() {
		return preroll;
	}
	
	public void setPreroll(ArrayList<Preroll> preroll) {
		this.preroll = preroll;
	}
	
	private Map<String, Content> getContentsMap() {
		return content.stream().collect(Collectors.toMap(Content::getName, 
				Function.identity()));
	}
	
	private Map<String, Preroll> getPrerollMap() {
		return preroll.stream().collect(Collectors.toMap(Preroll::getName, 
				Function.identity()));
	}

	public String lookup(String contentName, String country) {
		Map<String, Content> contentMap = getContentsMap();
		Map<String, Preroll> prerollMap = getPrerollMap();
		String result = "";
		if (contentMap.containsKey(contentName)) {
			Content contentObj = contentMap.get(contentName);
			result += contentObj.getMatchingPreroll(prerollMap, country);
		} else {
			result = MISSING_CONTENT + contentName;
		}
		
		return "".equals(result) ? EMPTY_MESSAGE + country : result;
		
	}
}
