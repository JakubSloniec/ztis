package pl.edu.agh.ztis.server.configuration;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

/**
 * Created by kkicinger on 01/04/16.
 */
public class Configuration {

    public static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final Pattern MENTIONED_CITY_PATTERN = Pattern.compile("[A-Z]{3,}[A-Z -]*");
    public static final String DATA_DIRECTORY_REGEX = "[a-z]{2}_[A-Z]{3}_[a-z]{6}_int";
    public static final String HEADER_ID = "ID";
    public static final String HEADER_FEED = "feed";
    public static final String HEADER_TIME = "time";
    public static final String HEADER_TEXT_1 = "text1";
    public static final String HEADER_TEXT_2 = "text2";
    public static final String HEADER_TAG_COUNTRY = "TAG_country";
    public static final String HEADER_TAG_EBOLA = "TAG_ebola";
    public static final String RAW_CSV_FILE_NAME = "rss.csv";
    public static final String UNIQUE_CSV_FILE_NAME = "rss_unique.csv";
    public static final String SAMPLE_DATA_TAGGED_CSV_FILE_NAME = "rss_unique_tagged.csv";
    public static final String FULL_DATA_TAGGED_CSV_FILE_NAME = "rss_unique_TAG_country_Ebola.csv";
    private static final String GEOMEDIA_HOME = "/Users/kkicinger/Studies/ZTIS/geomedia";
    private static final String GEOMEDIA_SAMPLE_DATA = "cist-sample_geomedia-db/Sample_GeomediaDB";
    public static final Path GEOMEDIA_SAMPLE_DATA_PATH = Paths.get(GEOMEDIA_HOME, GEOMEDIA_SAMPLE_DATA);
    private static final String GEOMEDIA_FULL_DATA = "Geomedia_extract_AGENDA/Geomedia_extract_AGENDA";
    public static final Path GEOMEDIA_FULL_DATA_PATH = Paths.get(GEOMEDIA_HOME, GEOMEDIA_FULL_DATA);

    public static final String APP_TITLE = "Geomedia Notes Analyser";

    private static final String IBM_ALCHEMY_BASE_URL = "http://gateway-a.watsonplatform.net/calls";
    private static final String IBM_ALCHEMY_TEXT_BASE_URL = IBM_ALCHEMY_BASE_URL + "/text";
    public static final String IBM_ALCHEMY_KEYWORDS_URL = IBM_ALCHEMY_TEXT_BASE_URL + "/TextGetRankedKeywords";
    public static final String IBM_ALCHEMY_TAXONOMY_URL = IBM_ALCHEMY_TEXT_BASE_URL + "/TextGetRankedTaxonomy";
    public static final String IBM_ALCHEMY_EMOTIONS_URL = IBM_ALCHEMY_TEXT_BASE_URL + "/TextGetEmotion";
    public static final String IBM_ALCHEMY_CONCEPT_URL = IBM_ALCHEMY_TEXT_BASE_URL + "/TextGetRankedConcepts";
    public static final String IBM_ALCHEMY_SENTIMENT_URL = IBM_ALCHEMY_TEXT_BASE_URL + "/TextGetTextSentiment";

    public static final String IBM_ALCHEMY_DEFAULT_API_KEY = "aed104a71c35e94bbce01ab18cbf48d63f6c9424";
    public static final String IBM_ALCHEMY_DEFAULT_SENTIMENT = "1";
    public static final String IBM_ALCHEMY_DEFAULT_OUTPUT_MODE = "json";

    public static class Params {

        public static final String IBM_ALCHEMY_API_KEY = "apikey";
        public static final String IBM_ALCHEMY_TEXT = "text";
        public static final String IBM_ALCHEMY_SENTIMENT = "sentiment";
        public static final String IBM_ALCHEMY_OUTPUT_MODE = "outputMode";
        public static final String IBM_ALCHEMY_KNOWLEDGE_GRAPH_MODE = "knowledgeGraph";

    }

}
