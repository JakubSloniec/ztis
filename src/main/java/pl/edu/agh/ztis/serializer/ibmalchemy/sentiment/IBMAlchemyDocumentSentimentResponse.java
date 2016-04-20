package pl.edu.agh.ztis.serializer.ibmalchemy.sentiment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import pl.edu.agh.ztis.serializer.ibmalchemy.IBMAlchemyResponse;
import pl.edu.agh.ztis.serializer.ibmalchemy.Sentiment;

/**
 * Created by kkicinger on 20/04/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class IBMAlchemyDocumentSentimentResponse extends IBMAlchemyResponse {

    private Sentiment docSentiment;

    public IBMAlchemyDocumentSentimentResponse() {
    }

    public Sentiment getDocSentiment() {
        return docSentiment;
    }

    public void setDocSentiment(Sentiment docSentiment) {
        this.docSentiment = docSentiment;
    }

}
