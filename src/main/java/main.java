import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class main {
    private static final String URL_NAME = "http://dantri.com.vn";
    public static void main(String[] args) throws IOException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd_MM_YYYY_HH_mm_ss");
        String fileName = simpleDateFormat.format(new Date());
        Document doc = Jsoup.connect(URL_NAME).get();
        Elements links = doc.select("a");

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(fileName)));

        for (Element link: links){
            bufferedWriter.write(link.attr("href") +"\n");
        }
        bufferedWriter.close();
    }
}
