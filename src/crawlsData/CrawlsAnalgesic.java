package crawlsData;

import model.Analgesic;
import model.Medicine;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.awt.*;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class CrawlsAnalgesic {
//    private static CrawlsAnalgesic instance;
    private final String url = "https://www.nhathuocankhang.com/thuoc-giam-dau-khang-viem#c=10023&protype=2&o=3&pi=0";
//    private ArrayList<Medicine> dataAnalgesic = new ArrayList<>();
    private ArrayList<String> nameAnalgesic = new ArrayList<>();
    private ArrayList<String> priceAnalgesic = new ArrayList<>();
    private ArrayList<Integer> idAnalgesic = new ArrayList<>();
    private ArrayList<String> unitAnalgesic = new ArrayList<>();
    public CrawlsAnalgesic() {
    }
    public ArrayList<String> getNameAnalgesic(){
        return nameAnalgesic;
    }
    public ArrayList<String> getPriceAnalgesic(){
        return priceAnalgesic;
    }
    public ArrayList<Integer> getIdAnalgesic() {
        return idAnalgesic;
    }
    public ArrayList<String> getUnitAnalgesic() {
        return unitAnalgesic;
    }
    public void crawlAll() {
        try {
            Document doc = Jsoup.connect(url).get();
            ArrayList<Element> elementName = doc.getElementsByClass("text-prod");
            ArrayList<Element> elementPrice = doc.getElementsByClass("P_disprice");
            ArrayList<Element> elementUnit = doc.getElementsByClass("qcdg");
            int id =1;
            for (int i = 1; i <= 5 ; i++) {
                String name = elementName.get(i).getElementsByTag("h3").text();
                String price = elementPrice.get(i).getElementsByTag("b").text();
                String unit = elementUnit.get(i).getElementsByTag("label").text();
                id++;
                idAnalgesic.add(id);
                nameAnalgesic.add(name);
                priceAnalgesic.add(price);
                unitAnalgesic.add(unit);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

//    private CrawlsAnalgesic() {
//    }
//    public static CrawlsAnalgesic getInstance() {
//        if (instance == null) {
//            return instance = new CrawlsAnalgesic();
//        }else return instance;
//    }
//   public List<Medicine> getDataAnalgesic() {
//        crawlAll();
//        return dataAnalgesic;
//   }
//    public void crawlAll() {
//        try {
//            Document doc = Jsoup.connect(url).get();
//            ArrayList<Element> elementName = doc.getElementsByClass("text-prod");
//            ArrayList<Element> elementPrice = doc.getElementsByClass("P_disprice");
//            ArrayList<Element> elementUnit = doc.getElementsByClass("qcdg");
//            int id = 0;
//            for (int i = 1; i < 5 ; i++) {
//                Analgesic a1 = new Analgesic();
//                String name = elementName.get(i).getElementsByTag("h3").text();
//                a1.setName(name);
//                String price = elementPrice.get(i).getElementsByTag("b").text();
//                price = price.replaceAll(",","");
//                price = price.replaceAll("₫","").trim();
//                a1.setPrice(Double.parseDouble(price));
//                String unit = elementUnit.get(i).getElementsByTag("label").text();
//                a1.setUnit(unit);
//                id ++;
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
