package hwEight;

import hwEight.pages.PagesMainSearch;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@Tag(value = "SearchPage")
public class TestSearchWithValueSource {

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

}
