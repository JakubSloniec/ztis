package pl.edu.agh.ztis.serializer.ibmalchemy.keywords;

import pl.edu.agh.ztis.serializer.ibmalchemy.Sentiment;

/**
 * Created by kkicinger on 19/04/16.
 */
public class Keyword {

    private String text;
    private double relevance;
    private Sentiment sentiment;

    public Keyword() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public double getRelevance() {
        return relevance;
    }

    public void setRelevance(double relevance) {
        this.relevance = relevance;
    }

    public Sentiment getSentiment() {
        return sentiment;
    }

    public void setSentiment(Sentiment sentiment) {
        this.sentiment = sentiment;
    }
}
