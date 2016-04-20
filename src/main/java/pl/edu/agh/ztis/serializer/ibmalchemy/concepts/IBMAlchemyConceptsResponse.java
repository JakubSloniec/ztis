package pl.edu.agh.ztis.serializer.ibmalchemy.concepts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by kkicinger on 20/04/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class IBMAlchemyConceptsResponse {

    private List<Concept> concepts;

    public IBMAlchemyConceptsResponse() {
    }

    public List<Concept> getConcepts() {
        return concepts;
    }

    public void setConcepts(List<Concept> concepts) {
        this.concepts = concepts;
    }
}
