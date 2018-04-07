package com.skilldistillery.filmquery.entities;

import java.util.List;

public class Film {
	private int id;
	private String title;
	private String description;
	private int year;
	private int langId;
	private int rentalDur;
	private double rentalRate;
	private int length;
	private double replaceCost;
	private String rating;
	private String specFeatures;
	private List<Actor> cast;
	
	
	
	public Film(List<Actor> cast) {
		super();
		this.cast = cast;
	}
	
	public List<Actor> getCast() {
		return cast;
	}
	public void setCast(List<Actor> cast) {
		this.cast = cast;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getLangId() {
		return langId;
	}
	public void setLangId(int langId) {
		this.langId = langId;
	}
	public int getRentalDur() {
		return rentalDur;
	}
	public void setRentalDur(int rentalDur) {
		this.rentalDur = rentalDur;
	}
	public double getRentalRate() {
		return rentalRate;
	}
	public void setRentalRate(double rentalRate) {
		this.rentalRate = rentalRate;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public double getReplaceCost() {
		return replaceCost;
	}
	public void setReplaceCost(double replaceCost) {
		this.replaceCost = replaceCost;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getSpecFeatures() {
		return specFeatures;
	}
	public void setSpecFeatures(String specFeatures) {
		this.specFeatures = specFeatures;
	}
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + langId;
		result = prime * result + length;
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + rentalDur;
		long temp;
		temp = Double.doubleToLongBits(rentalRate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(replaceCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((specFeatures == null) ? 0 : specFeatures.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + year;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (langId != other.langId)
			return false;
		if (length != other.length)
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (rentalDur != other.rentalDur)
			return false;
		if (Double.doubleToLongBits(rentalRate) != Double.doubleToLongBits(other.rentalRate))
			return false;
		if (Double.doubleToLongBits(replaceCost) != Double.doubleToLongBits(other.replaceCost))
			return false;
		if (specFeatures == null) {
			if (other.specFeatures != null)
				return false;
		} else if (!specFeatures.equals(other.specFeatures))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (year != other.year)
			return false;
		return true;
	}
	
	
	@Override
	public String toString() {
		return "Film [id = " + id + ", title = " + title + ", description = " + description + ", year = " + year + ", language = "
				+ langId + ", rental duration = " + rentalDur + ", rental rate = " + rentalRate + ", length = " + length
				+ ", replacement cost = " + replaceCost + ", rating = " + rating + ", special features = " + specFeatures
				+ ", cast = " + cast + "]";
	}
	public Film(int id, String title, String description, int year, int langId, int rentalDur, double rentalRate,
			int length, double replaceCost, String rating, String specFeatures) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.year = year;
		this.langId = langId;
		this.rentalDur = rentalDur;
		this.rentalRate = rentalRate;
		this.length = length;
		this.replaceCost = replaceCost;
		this.rating = rating;
		this.specFeatures = specFeatures;
		
	}
	
	public Film(String title, String description, int year, String rating) {
		super();
		this.title = title;
		this.description = description;
		this.year = year;
		this.rating = rating;
	}

	
}
