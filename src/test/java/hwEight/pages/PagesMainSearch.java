package hwEight.pages;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PagesMainSearch {

    public CheckSearchResults searchOnAuthorToday(String word) {
        open("https://author.today/");
        $(".icon-search").click();
        $(byName("q")).val(word).pressEnter();
        return new CheckSearchResults();
    }
}

/*
    public static final String URL = "https://ya.ru/";

    private SelenideElement searchInput = $(".input__control");
    private SelenideElement searchBtn = $("button[type='submit']");

    public YandexResultsPage doSearch(String searchQuery) {
        searchInput.setValue(searchQuery);
        searchBtn.click();
        return new YandexResultsPage();
    }

 */