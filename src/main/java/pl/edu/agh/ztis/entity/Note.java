package pl.edu.agh.ztis.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

/**
 * Created by js on 21.03.2016.
 */
@Entity
@Table(name = "note")
public class Note {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "raw")
	private String raw;

	@ApiModelProperty(value = "note ID", required = true)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ApiModelProperty(value = "raw note", required = true)
	public String getRaw() {
		return raw;
	}

	public void setRaw(String raw) {
		this.raw = raw;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Note{");
		sb.append("id=").append(id);
		sb.append(", raw='").append(raw).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
