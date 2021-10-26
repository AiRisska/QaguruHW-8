package hwEight;

import com.codeborne.selenide.Condition;
import hwEight.menu.MenuItem;
import hwEight.pages.CheckSearchResults;
import hwEight.pages.PagesMainSearch;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.$;

public class TestSearchWithMethodSearch {
    private PagesMainSearch lib = new PagesMainSearch();
    private CheckSearchResults check = new CheckSearchResults();

    static Stream<Arguments> testWithMethodSource(){
        String word = "Маг";
        return Stream.of(
                Arguments.of(
                        1, word, MenuItem.AUTHORS, "Поиск авторов"
                ),Arguments.of(
                        2, word, MenuItem.WORKS, "Поиск произведений"
                ),Arguments.of(
//                        3, word, MenuItem.POSTS, "Поиск обсуждений"
//                ),Arguments.of(
                        4, word, MenuItem.ARTS, "Поиск иллюстраций"
//                ),Arguments.of(
//                        5, word, MenuItem.COLLECTIONS, "Поиск подборок"
        )
        );
    }
    @MethodSource("testWithMethodSource")
    @ParameterizedTest(name = "{2} со словом {1}")
    void testWithMethodSource(int i, String str, MenuItem menuItem, String title){
        lib.searchOnAuthorToday(str);
            check
                    .checkSearchWord(str)
                    .switchMenu(menuItem)
                    .click();
            $("#sticky > div:nth-child(2)").shouldHave(Condition.visible);
            check.checkHaveResults();
    }
}
