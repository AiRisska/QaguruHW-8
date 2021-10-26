package hwEight.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import hwEight.menu.MenuItem;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CheckSearchResults {

    private ElementsCollection menu = $$("a[data-bind]");

    public CheckSearchResults checkSearchWord(String word) {
        $(".search-input").shouldHave(Condition.value(word));
        return new CheckSearchResults();
    }

    public CheckSearchResults checkHaveResults(){
        $(".panel-body").shouldNotHave(text("Ваш запрос не дал результатов."));
        return new CheckSearchResults();
    }

    public SelenideElement switchMenu(MenuItem menuItem){
        return menu
                .find(Condition.text(menuItem.getValue()));
    }

}
