package pl.edu.agh.ztis.serializer.ibmalchemy.taxonomy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import pl.edu.agh.ztis.serializer.ibmalchemy.IBMAlchemyResponse;

import java.util.List;

/**
 * Created by kkicinger on 19/04/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class IBMAlchemyTaxonomyResponse extends IBMAlchemyResponse {

    private List<Taxonomy> taxonomy;

    public IBMAlchemyTaxonomyResponse() {
    }

    public List<Taxonomy> getTaxonomy() {
        return taxonomy;
    }

    public void setTaxonomy(List<Taxonomy> taxonomy) {
        this.taxonomy = taxonomy;
    }

}
