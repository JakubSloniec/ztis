package pl.edu.agh.ztis.serializer.ibmalchemy.concepts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by kkicinger on 20/04/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Concept {

    private String text;
    private double relevance;
    private String website;
    private String geo;
    private String dbpedia;
    private String yago;
    private String opencyc;
    private String freebase;
    private String ciaFactbook;
    private String census;
    private String geonames;
    private String musicBrainz;
    private String crunchbase;

    public Concept() {
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

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getGeo() {
        return geo;
    }

    public void setGeo(String geo) {
        this.geo = geo;
    }

    public String getDbpedia() {
        return dbpedia;
    }

    public void setDbpedia(String dbpedia) {
        this.dbpedia = dbpedia;
    }

    public String getYago() {
        return yago;
    }

    public void setYago(String yago) {
        this.yago = yago;
    }

    public String getOpencyc() {
        return opencyc;
    }

    public void setOpencyc(String opencyc) {
        this.opencyc = opencyc;
    }

    public String getFreebase() {
        return freebase;
    }

    public void setFreebase(String freebase) {
        this.freebase = freebase;
    }

    public String getCiaFactbook() {
        return ciaFactbook;
    }

    public void setCiaFactbook(String ciaFactbook) {
        this.ciaFactbook = ciaFactbook;
    }

    public String getCensus() {
        return census;
    }

    public void setCensus(String census) {
        this.census = census;
    }

    public String getGeonames() {
        return geonames;
    }

    public void setGeonames(String geonames) {
        this.geonames = geonames;
    }

    public String getMusicBrainz() {
        return musicBrainz;
    }

    public void setMusicBrainz(String musicBrainz) {
        this.musicBrainz = musicBrainz;
    }

    public String getCrunchbase() {
        return crunchbase;
    }

    public void setCrunchbase(String crunchbase) {
        this.crunchbase = crunchbase;
    }
}
