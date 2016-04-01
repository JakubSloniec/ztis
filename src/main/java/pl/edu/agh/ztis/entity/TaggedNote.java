package pl.edu.agh.ztis.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by kkicinger on 01/04/16.
 */
@Entity
@Table(name = "taggednote")
public class TaggedNote extends Note {

    @Column(name = "countrytag", length = 5)
    private String countryTag;

    @Column(name = "ebolaconnnected")
    private boolean ebolaConnected;

    public String getCountryTag() {
        return countryTag;
    }

    public void setCountryTag(String countryTag) {
        this.countryTag = countryTag;
    }

    public boolean isEbolaConnected() {
        return ebolaConnected;
    }

    public void setEbolaConnected(boolean ebolaConnected) {
        this.ebolaConnected = ebolaConnected;
    }

    @Override
    public String toString() {
        return "TaggedNote{" +
                "countryTag='" + countryTag + '\'' +
                ", ebolaConnected=" + ebolaConnected +
                "} " + super.toString();
    }
}
