package hwEight.pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PagesMainSearch {

    public CheckSearchResults searchOnAuthorToday(String word) {
        open("https://author.today/");
        $(".icon-search").shouldHave(Condition.visible);
        $(".icon-search").click();
        $(byName("q")).val(word).pressEnter();
        return new CheckSearchResults();
    }

    public CheckSearchResults checkHaveResults(){
        CheckSearchResults i = new CheckSearchResults();
        i.checkHaveResults();
        return i;
    }
}
