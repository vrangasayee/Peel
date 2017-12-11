package model;

import java.util.ArrayList;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Preroll {

	private String name;
	private ArrayList<Video> videos = new ArrayList<Video>();
	
	public ArrayList<Video> getVideos() {
		return videos;
	}
	
	public void setVideos(ArrayList<Video> videos) {
		this.videos = videos;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("name : " + name);
		sb.append("\n");
		sb.append("videos:");
		sb.append("\n");
		for (Video v : videos) {
			sb.append(v);
		}
		return sb.toString();
	}
	
	public Map<String, Video> getVideoMap() {
		return videos.stream().collect(Collectors.toMap(Video::getName, 
				Function.identity()));
	}
}
