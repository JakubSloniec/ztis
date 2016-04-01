package pl.edu.agh.ztis.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by js on 21.03.2016.
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Note {

	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(name = "language", length = 5, nullable = false)
	private Language language;

	@Column(name = "country", length = 5, nullable = false)
	private String country;

	@Enumerated(EnumType.STRING)
	@Column(name = "magazine", length = 10, nullable = false)
	private Magazine magazine;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "time", length = 10, nullable = false)
    private Date time;

	@Lob
	@Column(name = "title", nullable = false)
	private String title;

	@Lob
	@Column(name = "content", nullable = false)
	private String content;

    @Column(name = "mentionedcity", length = 30)
    private String mentionedCity;

	@ApiModelProperty(value = "note ID", required = true)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Magazine getMagazine() {
		return magazine;
	}

	public void setMagazine(Magazine magazine) {
		this.magazine = magazine;
	}

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

    public String getMentionedCity() {
        return mentionedCity;
    }

    public void setMentionedCity(String mentionedCity) {
        this.mentionedCity = mentionedCity;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", language=" + language +
                ", country='" + country + '\'' +
                ", magazine=" + magazine +
                ", time=" + time +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", mentionedCity='" + mentionedCity + '\'' +
                '}';
    }

    @Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Note note = (Note) o;

		return !(id != null ? !id.equals(note.id) : note.id != null);

	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}
}
