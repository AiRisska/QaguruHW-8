package hwEight.menu;

public enum MenuItem {

    ALL("Все"),
    AUTHORS("Авторы"),
    WORKS("Произведения"),
    POSTS("Обсуждения"),
    ARTS("Иллюстрации"),
    COLLECTIONS("Подборки")
    ;

    // панелька справа panel sidebar search-sidebar варианты Все Авторы Произведения Обсуждения Иллюстрации Подборки

    private String value;

    MenuItem(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
