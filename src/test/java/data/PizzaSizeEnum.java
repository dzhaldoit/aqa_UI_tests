package data;

import lombok.Getter;

@Getter
public enum PizzaSizeEnum {
    BIG("Большая", "[data-testid='menu__pizza_size_Большая']", "35 см"),
    MEDIUM("Средняя", "[data-testid='menu__pizza_size_Средняя']", "30 см"),
    SMALL("Маленькая", "[data-testid='menu__pizza_size_Маленькая']", "25 см");
    private final String name;
    private final String selector;
    private final String size;

    PizzaSizeEnum(String name, String selector, String size) {
        this.name = name;
        this.selector = selector;
        this.size = size;
    }
}