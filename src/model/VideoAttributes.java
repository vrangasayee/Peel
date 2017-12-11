package model;

import java.util.ArrayList;
import java.util.List;

public class VideoAttributes {
	private ArrayList<String> countries;
	private String language;
	private String aspect;
	public String getAspect() {
		return aspect;
	}
	public void setAspect(String aspect) {
		this.aspect = aspect;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public List<String> getCountries() {
		return countries;
	}
	public void setCountries(ArrayList<String> countries) {
		this.countries = countries;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("language : " + language);
		sb.append("\n");
		sb.append("aspect : " + aspect);
		sb.append("\n");
		sb.append("countries: ");
		sb.append("\n");
		for (String c : countries) {
			sb.append(c);
		}
		sb.append("\n");
		
		return sb.toString();
	}
	
	public boolean equals(VideoAttributes other) {
		boolean result = true;
		int countryMatch = 0;
		ArrayList<String> countries = other.countries;
		for (String country : countries) {
			if (this.countries.contains(country))
					countryMatch = 1;
		}
		if (countryMatch == 0) {
			result = false;
		}
		if (!this.language.equals(other.language)) {
			result = false;
		}
		if (!this.aspect.equals(other.aspect)) {
			result = false;
		}
		return result;
	}

}
