package pl.edu.agh.ztis.serializer.ibmalchemy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by kkicinger on 19/04/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class IBMAlchemyResponse {

    private Status status;
    private String language;
    private String text;

    public IBMAlchemyResponse() {
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
