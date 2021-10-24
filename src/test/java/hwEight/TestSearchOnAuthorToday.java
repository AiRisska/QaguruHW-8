package hwEight;

import hwEight.menu.MenuItem;
import hwEight.pages.PagesMainSearch;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

public class TestSearchOnAuthorToday {

    private PagesMainSearch lib = new PagesMainSearch();
    @ValueSource(strings = {
            "Первый",
            "Город",
            "Маг"
    })
    @ParameterizedTest(name = "Поиск слова {0}")
    void searchWord(String word) {
        lib.searchOnAuthorToday(word)
                .checkSearchWord(word)
                .checkHaveResults();
    }

    @EnumSource(value = MenuItem.class)
    @ParameterizedTest(name = "Поиск слова Маг в меню")
    void searchWordWithSwitchMenu(MenuItem menuItem) {
        lib.searchOnAuthorToday("Маг")
                .checkSearchWord("Маг")
                .checkHaveResults()
                .switchMenu(menuItem);
    }
    @CsvSource({
            "1, Первый, Поиск по слову 'Первый'",
            "2, Маг, Поиск по слову 'Маг'"
    })
    @ParameterizedTest(name = "{2}")
    void searchWords(int id, String word, String TestName) {
        lib.searchOnAuthorToday(word)
                .checkSearchWord(word)
                .checkHaveResults();
    }

}
