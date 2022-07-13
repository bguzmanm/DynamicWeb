package model.entity;

public class Film {

	private int film_id;
	private String title;
	private String description;
	private int release_year;
	private String rating;
	private String special_features;
	public Film() {
		super();
	}
	public Film(int film_id, String title, String description, int release_year, String rating,
			String special_features) {
		super();
		this.film_id = film_id;
		this.title = title;
		this.description = description;
		this.release_year = release_year;
		this.rating = rating;
		this.special_features = special_features;
	}
	public int getFilm_id() {
		return film_id;
	}
	public void setFilm_id(int film_id) {
		this.film_id = film_id;
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
	public int getRelease_year() {
		return release_year;
	}
	public void setRelease_year(int release_year) {
		this.release_year = release_year;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getSpecial_features() {
		return special_features;
	}
	public void setSpecial_features(String special_features) {
		this.special_features = special_features;
	}
	
	
	@Override
	public String toString() {
		return "Film [film_id=" + film_id + ", title=" + title + ", description=" + description + ", release_year="
				+ release_year + ", rating=" + rating + ", special_features=" + special_features + "]";
	}
	
}
