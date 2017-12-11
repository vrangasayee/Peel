package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Content {
	
	private String name;
	private Preroll[] preroll;
	private ArrayList<Video> videos;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Preroll[] getPreroll() {
		return preroll;
	}
	
	public void setPreroll(Preroll[] preroll) {
		this.preroll = preroll;
	}
	
	public ArrayList<Video> getVideos() {
		return videos;
	}
	
	public void setVideos(ArrayList<Video> videos) {
		this.videos = videos;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("name : " + name);
		sb.append("\n");
		sb.append("prerolls: ");
		sb.append("\n");
		for (Preroll p : preroll) {
			sb.append(p);
		}
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

	public String getMatchingPreroll(Map<String, Preroll> prerollMap, String country) {
		StringBuilder sb = new StringBuilder();
		int i = 1;
		if (this.preroll != null) {
			for (Preroll p : this.preroll) {
				// If the required Preroll exists
				if (prerollMap.containsKey(p.getName())) {
					ArrayList<Video> prerollVideos = prerollMap.get(p.getName()).getVideos();
					for (Video v1 : videos) {
						for (Video v2 : prerollVideos) {
							List<String> countries = v2.getCountries();
							if (v1.equals(v2) && ("".equals(country) || countries.contains(country))) {
								sb.append("Playlist" + i + ":\n");
								i++;
								sb.append("(" + v2.getName() + "," + v1.getName() + ")\n");
							}
						}
					}
				} 
			}
		}
		return sb.toString();
	}
}
