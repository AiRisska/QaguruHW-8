package hwEight;

import com.codeborne.selenide.Condition;
import hwEight.menu.MenuItem;
import hwEight.pages.PagesMainSearch;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.$;

public class TestSearchOnAuthorToday {

    static Stream<Arguments> testWithMethodSource(){
        String word = "Салфетка";
        return Stream.of(
                //здесь можно перечислять объекты любых типов внутри Arguments
                //в нашем примере мы передаем список имен
                Arguments.of(
//                        1, word, MenuItem.ALL
//                ), Arguments.of(
                        2, word, MenuItem.AUTHORS
/*                ),Arguments.of(
                        3, word, MenuItem.WORKS
                ),Arguments.of(
                        4, word, MenuItem.POSTS
                ),Arguments.of(
                        5, word, MenuItem.ARTS
                ),Arguments.of(
                        6, word, MenuItem.COLLECTIONS
*/        )
        );
    }
    @MethodSource("testWithMethodSource")
    @ParameterizedTest(name = "{1} {2}")
    void testWithMethodSource(int i, String str, MenuItem menuItem) throws Exception {
        lib.searchOnAuthorToday(str)
                .switchMenu(menuItem)
                .click();
//        wait(77000);
        System.out.println($(".panel-heading").getText());
//        lib                                .checkHaveResults();
    }

    static Stream<Arguments> printCol(){
        String word = "Салфетка";
        return Stream.of(
                Arguments.of(
                        2, word, MenuItem.AUTHORS
                )
        );
    }
    @MethodSource("printCol")
    @ParameterizedTest(name = "{1} {2}")
    void printCol(int i, String str, MenuItem menuItem){
        lib.searchOnAuthorToday(str)
                .printCol(menuItem);

        System.out.println($(".panel-heading").getText());
//        lib                                .checkHaveResults();
    }

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
 //               .switchMenu(menuItem)
        ;
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

    @Test
    void test() {

        lib.searchOnAuthorToday("Салфетка")
                .switchMenu(MenuItem.AUTHORS)
                .click()
        ;
        $("#sticky > div:nth-child(2)").shouldHave(Condition.visible);
//        wait(77000);
        System.out.println($(".panel-heading").getText());
//        lib                                .checkHaveResults();
    }
}
