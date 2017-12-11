package model;

import java.util.List;

public class Video {
	
	private String name;
	private VideoAttributes attributes;
	
	public VideoAttributes getAttributes() {
		return attributes;
	}
	
	public void setAttributes(VideoAttributes attributes) {
		this.attributes = attributes;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("name : " + name);
		sb.append("\n");
		sb.append("attributes : " + attributes);
		sb.append("\n");
		return sb.toString();
	}
	
	public boolean equals(Video other) {
		return attributes.equals(other.attributes);
	}


	public List<String> getCountries() {
		// TODO Auto-generated method stub
		return attributes.getCountries();
	}
}
