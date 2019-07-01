package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;
import java.nio.file.*;

public class JSoupGetDemo {
    public static void main(String[] args) throws IOException {

        /* коннект */
        URL url = new URL("http://youhouse.ru/tarify_zhkh/moskva%20gorjachaja%20voda.php");
        Document document = Jsoup.parse(url, 5000);
        Document document1 = Jsoup.connect("http://youhouse.ru/tarify_zhkh/moskva%20gorjachaja%20voda.php").get();

        /* заголовок */
        System.out.println("************************************title()***********************************");
        System.out.println(document.title());

        /* получение всех тегов h1 */
        System.out.println("************************************getElementsByTag()***********************************");
        Elements tags_h1 = document.getElementsByTag("h1");
        for (Element h1 : tags_h1) {
            System.out.println(h1.text());
        }

        System.out.println("************************************body()**************************************");
        /* получение body() */
        Element body = document.body();

        /* получение по id */
        System.out.println("************************************getElementById()**************************************");
        Element login = body.getElementById("login");
        System.out.println(login);

        /* получение по tag */
        System.out.println("************************************getElementsByTag()**************************************");
        Elements table = login.getElementsByTag("table");
        System.out.println(table);

        /* получение по selector */
        System.out.println("************************************select()*********************************************");
        Elements selector_td = body.select("table > tbody > tr:nth-child(1) >" +
                " td > table:nth-child(3) > tbody > tr > td:nth-child(3) > table " +
                "> tbody > tr:nth-child(2) > td > table:nth-child(6) > tbody:nth-child(2) > tr > td:nth-child(2)");
        System.out.println(selector_td);
        System.out.println(selector_td.text());

        /* получение атрибутов*/
        System.out.println("************************************attributes()*********************************************");
        Elements graphs = body.select("table > tbody > tr:nth-child(1) > td > table:nth-child(3) " +
                "> tbody > tr > td:nth-child(3) > table > tbody > tr:nth-child(2) > td > div > a");

        String relativeImageUrl = graphs.first().attr("href");
        String absoluteImageUrl = graphs.first().absUrl("href");
        System.out.println(relativeImageUrl);
        System.out.println(absoluteImageUrl);
        Attributes attributes = graphs.first().attributes();
        for (Attribute attr : attributes) {
            System.out.println(attr.getKey()+":"+attr.getValue());
        }

        /*  Получить картинку с сайта и скопировать ее локально!*/
        Path relativePathInp  = Paths.get("src/jsoup/graph123.jpg");
        URL urlImg = new URL(absoluteImageUrl);
        try (InputStream inpStream = new BufferedInputStream(urlImg.openStream())) {
            Files.copy(inpStream, relativePathInp, StandardCopyOption.REPLACE_EXISTING);
        }

    }
}