import org.jsoup.Jsoup
import java.net.URL


fun main(args: Array<String>) {
    println("Hello, World!")
    println(add(1.0,2.0))
    val wiki = "https://en.wikipedia.org"

    val doc = Jsoup.connect("$wiki/wiki/List_of_films_with_a_100%25_rating_on_Rotten_Tomatoes").get()    // <1>
    doc.select(".wikitable:first-of-type tr td:first-of-type a")    // <2>
        .map { col -> col.attr("href") }    // <3>
        .parallelStream()    // <4>
        .forEach{println(it)}
//        .map { extractMovieData(it) }    // <5>
//        .filter { it != null }
//        .forEach { println(it) }
    println(URL("https://google.com").readText())
}