package automationpractice.page_ors.shopandCart;

import org.openqa.selenium.By;

public class ProductPage {

    public static final By ProductName= By.xpath("//h1[@itemprop='name']");
    public static final By ProductPrice= By.id("our_price_display");
    public static final By AddToCart= By.xpath("//button/span[contains(text(),\"Add to cart\")]");
    public static final By PopupCross= By.xpath("//span[@class='cross']");
    public static final By Cart_btn= By.xpath("//b[contains(text(),'Cart')]");
    public static String ProdTextName;
    public static String PriceTextName;
}
