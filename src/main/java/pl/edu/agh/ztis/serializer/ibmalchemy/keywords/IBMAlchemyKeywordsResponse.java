package pl.edu.agh.ztis.serializer.ibmalchemy.keywords;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by kkicinger on 19/04/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class IBMAlchemyKeywordsResponse {

    private List<Keyword> keywords;

    public IBMAlchemyKeywordsResponse() {
    }

    public List<Keyword> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<Keyword> keywords) {
        this.keywords = keywords;
    }

}
