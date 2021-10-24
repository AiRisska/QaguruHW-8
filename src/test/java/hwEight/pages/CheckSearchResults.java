package hwEight.pages;

import com.codeborne.selenide.Condition;
import hwEight.menu.MenuItem;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CheckSearchResults {


    public CheckSearchResults checkSearchWord(String word) {
        $(".search-input").shouldHave(Condition.value(word));
        return new CheckSearchResults();
    }

    public CheckSearchResults checkHaveResults() {
        $(".panel-body").shouldNotHave(Condition.text("Ваш запрос не дал результатов."));
        return new CheckSearchResults();
    }

    public CheckSearchResults switchMenu(MenuItem menuItem){
        $$(".nav").find(Condition.text(menuItem.getValue())).click();
        return  this;
    }

}
/*
    private ElementsCollection results = $$(".serp-item");

    public void checkResults(String expected) {
        results.shouldBe(CollectionCondition.sizeGreaterThan(0))
                .get(1)
                .shouldHave(text(expected));
    }

    public YandexResultsPage switchToMenuItem(MenuItem menuItem) {
        $$("li[role='listitem']").find(text(menuItem.getDesc())).click();
//        код выше - полиморфмный код, когда не требуется лишних строк. Он защитит сам себя от лишнего.
//        if (menuItem == SEARCH) {
//            //велик соблазна сразу указать в find(text("")) названия типа "Поиск". Но зачем? У нас есть enum! Перенесем туда.
//            $$("li[role='listitem']").find(text(menuItem.getDesc())).click();
//        } else if (menuItem == MenuItem.IMAGES) {
//            $$("li[role='listitem']").find(text(menuItem.getDesc())).click();
//            //исключение ниже на всякий случай, но у нас пока всего 2 варианта в enum
//        } else throw new IllegalArgumentException("Enum "+menuItem+" not supported here");

        return this;
                }
 */