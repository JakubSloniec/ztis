package pl.edu.agh.ztis.serializer.ibmalchemy.emotions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import pl.edu.agh.ztis.serializer.ibmalchemy.IBMAlchemyResponse;

/**
 * Created by kkicinger on 20/04/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class IBMAlchemyEmotionsResponse extends IBMAlchemyResponse {

    private Emotions docEmotions;

    public IBMAlchemyEmotionsResponse() {
    }

    public Emotions getDocEmotions() {
        return docEmotions;
    }

    public void setDocEmotions(Emotions docEmotions) {
        this.docEmotions = docEmotions;
    }
}
