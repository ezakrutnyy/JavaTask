package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class JSoupSetDemo {
    public static void main(String[] args) throws IOException {

        String html = "<html><head><title>Sample Title</title></head>"
                + "<body>"
                + "<p>New State</p>"
                + "<div id='sampleDiv'><a id='googleA' href='www.google.com'>Google</a></div>"
                + "<div class='comments'><a href='www.sample1.com'>Sample1</a>"
                + "<a href='www.sample2.com'>Sample2</a>"
                + "<a href='www.sample3.com'>Sample3</a><div>"
                +"</div>"
                + "<div id='imageDiv' class='header'><img name='google' src='google.png' />"
                + "<img name='yahoo' src='yahoo.jpg' />"
                +"</div>"
                +"</body></html>";


        Document document = Jsoup.parse(html);

        /* set Attributes */
        Element p = document.getElementsByTag("p").first();
        p.addClass("MyClass");
        p.empty();
        p.appendText("НОВАЯ СТАТЬЯ");
        p.attr("id", "new");

        /* сохраним как файло html */
        Files.copy(new ByteArrayInputStream(document.toString().getBytes()),
                Paths.get("src/jsoup/index.html"), REPLACE_EXISTING);


        /* change html tag */
        Element div = document.getElementById("sampleDiv");
        div.html("<p>This is a sample content.</p>");
        div.prepend("<p> Prepend </p>");
        div.append("<p> Append </p>");
        div.before("<span> Before Div</span>");
        div.after("<span> After Div</span>");

        div = document.getElementById("imageDiv");
        div.text("Current Text!");
        div.prepend("Prepend Text!");
        div.append("Append Text!");

        Files.copy(new ByteArrayInputStream(document.toString().getBytes()),
                Paths.get("src/jsoup/index2.html"), REPLACE_EXISTING);

    }
}
