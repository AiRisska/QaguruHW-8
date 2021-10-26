package hwEight;

import hwEight.menu.MenuItem;
import hwEight.pages.PagesMainSearch;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@Tag(value = "OnMenu")
public class TestSearchWordSwitchMenu {

    private PagesMainSearch lib = new PagesMainSearch();

    @EnumSource(value = MenuItem.class)
    @ParameterizedTest(name = "Поиск слова Маг в меню")
    void searchMagWithSwitchMenu(MenuItem menuItem){
        lib.searchOnAuthorToday("Маг")
                .checkSearchWord("Маг")
                .checkHaveResults()
                .switchMenu(menuItem)
        ;
    }

    @EnumSource(value = MenuItem.class)
    @ParameterizedTest(name = "Поиск слова Город в меню")
    void searchTownWithSwitchMenu(MenuItem menuItem){
        lib.searchOnAuthorToday("Город")
                .checkSearchWord("Город")
                .checkHaveResults()
                .switchMenu(menuItem)
        ;
    }
}
