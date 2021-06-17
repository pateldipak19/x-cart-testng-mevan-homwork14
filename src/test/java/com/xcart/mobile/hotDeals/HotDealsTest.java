package com.xcart.mobile.hotDeals;

import com.xcart.mobile.pages.BestSellers;
import com.xcart.mobile.pages.Homepage;
import com.xcart.mobile.pages.Sale;
import com.xcart.mobile.retryAnalyzer.RetryAnalyzer;
import com.xcart.mobile.testbase.TestBase;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HotDealsTest extends TestBase {

    SoftAssert softAssert = new SoftAssert();
    Homepage homepage = new Homepage();
    Sale sale = new Sale();
    BestSellers bestSellers = new BestSellers();

    @Test(groups = {"smoke", "regression"},retryAnalyzer = RetryAnalyzer.class)
    public void verifySaleProductsArrangeAlphabetically() throws InterruptedException {

        homepage.mouseHoverOnHotDeals();
        homepage.clickOnSalesOrBestSellers("Sale");
        Thread.sleep(2000);
        String expectedSaleText = "Sale";
        softAssert.assertEquals(expectedSaleText, sale.actualSaleText());

        sale.selectSortByFilter("Name A - Z");
        Thread.sleep(2000);

        List<String> actualProductNameList = sale.getProductNames();
        List<String> expectedProductNameList = new ArrayList<>(actualProductNameList);
        Collections.sort(expectedProductNameList);
        softAssert.assertEquals(expectedProductNameList, actualProductNameList);
    }

    @Test(groups = {"smoke", "regression"},retryAnalyzer = RetryAnalyzer.class)
    public void verifySaleProductsPriceArrangeLowToHigh() throws InterruptedException {

        homepage.mouseHoverOnHotDeals();
        homepage.clickOnSalesOrBestSellers("Sale");
        Thread.sleep(2000);
        String expectedSaleText = "Sale";
        softAssert.assertEquals(expectedSaleText, sale.actualSaleText());

        sale.selectSortByFilter("Price Low - High");
        Thread.sleep(2000);

        List<Double> actualProductPriceList = sale.getProductPrices();
        List<Double> expectedProductPriceList = new ArrayList<>(actualProductPriceList);
        Collections.sort(expectedProductPriceList);
        softAssert.assertEquals(expectedProductPriceList, actualProductPriceList);

    }

    @Test(groups = {"smoke", "sanity", "regression"},retryAnalyzer = RetryAnalyzer.class)
    public void verifySaleProductsArrangeByRates() throws InterruptedException {

        homepage.mouseHoverOnHotDeals();
        homepage.clickOnSalesOrBestSellers("Sale");
        Thread.sleep(2000);
        String expectedSaleText = "Sale";
        softAssert.assertEquals(expectedSaleText, sale.actualSaleText());

        sale.selectSortByFilter("Rates");
        Thread.sleep(2000);

        List<Double> actualProductRating = sale.getProductRates();
        List<Double> expectedProductRating = new ArrayList<>(actualProductRating);
        Collections.sort(expectedProductRating, Collections.<Double>reverseOrder());
        softAssert.assertEquals(expectedProductRating, actualProductRating);

    }

    @Test(groups = {"sanity", "regression"},retryAnalyzer = RetryAnalyzer.class)
    public void verifyBestSellersProductsArrangeByZToA() throws InterruptedException {

        homepage.mouseHoverOnHotDeals();
        homepage.clickOnSalesOrBestSellers("Bestsellers");
        Thread.sleep(2000);
        String expectedBestSellerText = "Bestsellers";
        softAssert.assertEquals(expectedBestSellerText, bestSellers.actualBestSellerText());

        bestSellers.selectSortByFilter("Name Z - A");
        Thread.sleep(2000);

        List<String> actualProductNames = bestSellers.getProductName();
        List<String> expectedProductNames = new ArrayList<>(actualProductNames);
        Collections.sort(expectedProductNames, Collections.<String>reverseOrder());
        softAssert.assertEquals(expectedProductNames, actualProductNames);
    }

    @Test(groups = {"sanity", "regression"},retryAnalyzer = RetryAnalyzer.class)
    public void verifyBestSellersProductsPriceArrangeHighToLow() throws InterruptedException {

        homepage.mouseHoverOnHotDeals();
        homepage.clickOnSalesOrBestSellers("Bestsellers");
        Thread.sleep(2000);
        String expectedBestSellerText = "Bestsellers";
        softAssert.assertEquals(expectedBestSellerText, bestSellers.actualBestSellerText());

        bestSellers.selectSortByFilter("Price High - Low");
        Thread.sleep(2000);

        List<Double> actualProductPrice = bestSellers.getProductPrice();
        List<Double> expectedProductPrice = new ArrayList<>(actualProductPrice);
        Collections.sort(expectedProductPrice, Collections.<Double>reverseOrder());
        softAssert.assertEquals(expectedProductPrice, actualProductPrice);
    }

    @Test(groups = {"regression"},retryAnalyzer = RetryAnalyzer.class)
    public void verifyBestSellersProductsArrangeByRates() throws InterruptedException {

        homepage.mouseHoverOnHotDeals();
        homepage.clickOnSalesOrBestSellers("Bestsellers");
        Thread.sleep(2000);
        String expectedBestSellerText = "Bestsellers";
        softAssert.assertEquals(expectedBestSellerText, bestSellers.actualBestSellerText());

        bestSellers.selectSortByFilter("Rates");
        Thread.sleep(2000);

        List<Double> actualProductRating = bestSellers.getProductRating();
        List<Double> expectedProductRating = new ArrayList<>(actualProductRating);
        Collections.sort(expectedProductRating, Collections.<Double>reverseOrder());
        softAssert.assertEquals(expectedProductRating, actualProductRating);
    }
}
