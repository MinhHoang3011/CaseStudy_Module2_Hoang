package crawlsData;

import java.util.ArrayList;

public class CrawlAntibiotics implements ICrawlsData{

    private static CrawAntibiotics instance;

    private final String url = "https://www.nhathuocankhang.com/khang-sinh-khang-nam#c=10024&protype=2&o=3&pi=0";

    private ArrayList<String> dataAntibiotics = new ArrayList<>();

    private CrawlAntibiotics() {

    }
    public static CrawlAntibiotics getInstance() {
        if (instance == null) {
            return instance = new CrawlAntibiotics();
        }else return instance;
    }
}
