package pl.edu.agh.ztis.serializer.ibmalchemy.emotions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by kkicinger on 20/04/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Emotions {

    private double anger;
    private double disgust;
    private double fear;
    private double joy;
    private double sadness;

    public Emotions() {
    }

    public double getAnger() {
        return anger;
    }

    public void setAnger(double anger) {
        this.anger = anger;
    }

    public double getDisgust() {
        return disgust;
    }

    public void setDisgust(double disgust) {
        this.disgust = disgust;
    }

    public double getFear() {
        return fear;
    }

    public void setFear(double fear) {
        this.fear = fear;
    }

    public double getJoy() {
        return joy;
    }

    public void setJoy(double joy) {
        this.joy = joy;
    }

    public double getSadness() {
        return sadness;
    }

    public void setSadness(double sadness) {
        this.sadness = sadness;
    }
}
