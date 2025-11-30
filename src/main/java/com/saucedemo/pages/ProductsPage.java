package com.saucedemo.pages;

import org.openqa.selenium.By;

public class ProductsPage extends BasePage {

    private By productsHeader = By.xpath("//span[text()='Products']"); ////if texts inside a span = browser console search --> //span[text()='Products']

    public boolean isProductsHeaderDisplayed() {
        return find(productsHeader).isDisplayed();
    }


}
