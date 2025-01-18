package pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.Assertions.assertThat;

public class CartPopupCommon {
    private final ElementsCollection productCardsInCart = $(".scroll__view").$$("article");
    private final SelenideElement itemsInCartCounter = $("[data-testid='cart-button__quantity']");

    public CartPopupCommon checkItemName(String itemName) {
        productCardsInCart.findBy(text(itemName)).shouldBe(visible);
        return this;
    }

    public CartPopupCommon checkItemPrice(String itemName, Integer itemPrice) {
        String priceText = productCardsInCart.findBy(text(itemName)).$(".current").getText();
        String numericPriceText = priceText.replaceAll("[^0-9]", "");
        int actualPrice = Integer.parseInt(numericPriceText);
        assertThat(actualPrice).isEqualTo(itemPrice);
        return this;
    }

    public CartPopupCommon checkThatItemsInCartCounterNotEmpty() {
        itemsInCartCounter.should(exist);
        return this;
    }
}