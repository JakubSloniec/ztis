package pl.edu.agh.ztis.serializer.ibmalchemy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by kkicinger on 19/04/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Sentiment {

    public enum Type {

        positive,
        negative,
        neutral;

    }

    private double score;
    private Type type;

    public Sentiment() {
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

}
