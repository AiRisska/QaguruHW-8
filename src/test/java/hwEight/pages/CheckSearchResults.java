package hwEight.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import hwEight.menu.MenuItem;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.*;

public class CheckSearchResults {

    private ElementsCollection menu = $$("a[data-bind]");

    public CheckSearchResults checkSearchWord(String word) {
        $(".search-input").shouldHave(Condition.value(word));
        return new CheckSearchResults();
    }

    public CheckSearchResults checkHaveResults() {
        $(".panel-body").shouldNotHave(text("Ваш запрос не дал результатов."));
        return new CheckSearchResults();
    }

    public void printCol(MenuItem menuItem) {
        $(byLinkText(menuItem.getValue())).click();;

    }

    public SelenideElement switchMenu(MenuItem menuItem){
        SelenideElement item = menu
                .find(Condition.text(menuItem.getValue()));
//        System.out.println(menuItem.getValue()+" item "+item);
        return  item;
    }
//   //*[@id="sticky"]/div/ul/li[2]
    //    #sticky > div > ul > li:nth-child(2) > a      #sticky > div > ul > li:nth-child(3) > a
}
