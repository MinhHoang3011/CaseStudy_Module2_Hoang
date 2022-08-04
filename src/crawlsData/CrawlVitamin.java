package crawlsData;

import model.Analgesic;
import model.Medicine;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import javax.print.Doc;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrawlVitamin {

//        private static CrawlVitamin instance;

        private final String url = "https://www.nhathuocankhang.com/tim-kiem?key=vitamin1";
    private ArrayList<String> nameVitamin = new ArrayList<>();
    private ArrayList<String> priceVitamin = new ArrayList<>();
    private ArrayList<Integer> idVitamin = new ArrayList<>();
    private ArrayList<String> unitVitamin = new ArrayList<>();

    public   CrawlVitamin() {

    }
    public ArrayList<String> getNameVitamin() {
        return nameVitamin;
    }

    public ArrayList<String> getPriceVitamin() {
        return priceVitamin;
    }

    public ArrayList<Integer> getIdVitamin() {
        return idVitamin;
    }

    public ArrayList<String> getUnitVitamin() {
        return unitVitamin;
    }
    public void crawlAll() {
        try {
            Document doc = Jsoup.connect(url).get();
            ArrayList<Element> elementsName = doc.getElementsByClass("text-prod");
            ArrayList<Element> elementsPrice = doc.getElementsByClass("P_disprice");
            ArrayList<Element> elementsUnit = doc.getElementsByClass("qcdg");

            int id = 16;
            for (int i = 1; i <= 5; i++) {
                String name = elementsName.get(i).getElementsByTag("h3").text();
                String price = elementsPrice.get(i).getElementsByTag("b").text();
                String unit = elementsUnit.get(i).getElementsByTag("label").text();
                id ++;
                idVitamin.add(id);
                nameVitamin.add(name);
                priceVitamin.add(price);
                unitVitamin.add(unit);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //        private ArrayList<Medicine> dataVitamin = new ArrayList<>();
//
//        private CrawlVitamin() {
//
//        }
//        public static CrawlVitamin getInstance() {
//            if (instance == null) {
//                return instance = new CrawlVitamin();
//            }else return instance;
//        }
//        public List<Medicine> getDataVitamin(){
//            crawlAll();
//            return dataVitamin;
//        }
//        public void crawlAll() {
//            try {
//                Document doc = Jsoup.connect(url).get();
//                ArrayList<Element> elementName = doc.getElementsByClass("text-prod");
//                ArrayList<Element> elementPrice = doc.getElementsByClass("P_disprice");
//                ArrayList<Element> elementUnit = doc.getElementsByClass("qcdg");
//                int id = 0;
//                for (int i = 1; i < 5 ; i++) {
//                    Analgesic a1 = new Analgesic();
//                    String name = elementName.get(i).getElementsByTag("h3").text();
//                    a1.setName(name);
//                    String price = elementPrice.get(i).getElementsByTag("b").text();
//                    price = price.replaceAll(",","");
//                    price = price.replaceAll("₫","").trim();
//                    a1.setPrice(Double.parseDouble(price));
//                    String unit = elementUnit.get(i).getElementsByTag("label").text();
//                    a1.setUnit(unit);
//                    id ++;
//                }
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
    }
