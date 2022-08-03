package crawlsData;

import model.Analgesic;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrawlsAnalgesic implements ICrawlsData{
    private static CrawlsAnalgesic instance;
    private final String url = "https://www.nhathuocankhang.com/thuoc-giam-dau-khang-viem#c=10023&protype=2&o=3&pi=0";
    private ArrayList<String> dataAnalgesic = new ArrayList<>();

    private CrawlsAnalgesic() {

    }
    public static CrawlsAnalgesic getInstance() {
        if (instance == null) {
            return instance = new CrawlsAnalgesic();
        }else return instance;
    }
   public List<String> getDataAnalgesic() {
        crawlAll();
        return dataAnalgesic;
   }
    public void crawlAll() {
        try {
            Document doc = Jsoup.connect(url).get();
            ArrayList<Element> elementName = doc.getElementsByClass("text-prod");
            ArrayList<Element> elementPrice = doc.getElementsByClass("P_disprice");
            ArrayList<Element> elementUnit = doc.getElementsByClass("qcdg");
            int id = 0;
            for (int i = 1; i < 5 ; i++) {
                Analgesic a1 = new Analgesic();
                String name = elementName.get(i).getElementsByTag("h3").text();
                a1.setName(name);
                String price = elementPrice.get(i).getElementsByTag("b").text();
                price = price.replaceAll(",","");
                price = price.replaceAll("Đ","").trim();
                a1.setPrice(Double.parseDouble(price));
                String unit = elementUnit.get(i).getElementsByTag("label").text();
                id ++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
