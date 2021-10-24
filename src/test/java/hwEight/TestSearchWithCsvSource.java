package hwEight;

import hwEight.pages.PagesMainSearch;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@Tag(value = "SearchPage")
public class TestSearchWithCsvSource {

    private PagesMainSearch lib = new PagesMainSearch();

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
