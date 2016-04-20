package pl.edu.agh.ztis.serializer.ibmalchemy.taxonomy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by kkicinger on 19/04/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Taxonomy {

    private String label;
    private double score;

    public Taxonomy() {
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

}
