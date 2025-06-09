package com.pharmacity.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pharmacity.utils.BrowserHelper;
import static com.pharmacity.locators.LoginPageLocator.*;

import java.util.List;

import static com.pharmacity.locators.HomePageLocator.*;

public class HomePage {

    private WebDriver driver;

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // public String AdsBanner = "//div[@class='flex w-auto items-center
    // justify-center']";
    // public String adsBannerCloseButton = "//div[@class='flex w-auto items-center
    // justify-center']//button";
    // public String topBanner = "//div[@class='hidden
    // md:block']//div[@data-topbanner='true']";
    // public String headerTopBanner = "//div[@class='hidden bg-primary-50
    // md:flex']";
    // public String headerBottomBanner = "//div[@class='z-20 mx-auto w-full
    // md:container md:pb-3 md:pt-4']";
    // public String mainBanner = "//div[@class='swiper swiper-initialized
    // swiper-horizontal custom-swiper-navigation w-full banner
    // aspect-banner-image-mobile h-full overflow-hidden md:rounded-xl
    // swiper-backface-hidden']";
    // public String topRightCornerBanner = "(//div[@class='hidden w-full
    // grid-rows-2 gap-4 md:grid md:w-[32.4%]']//div[@class='h-full w-full'])[1]";
    // public String bottomRightCornerBanner = "(//div[@class='hidden w-full
    // grid-rows-2 gap-4 md:grid md:w-[32.4%]']//div[@class='h-full w-full'])[2]";
    // public String uspPrescriptionBanner = "(//div[@class='h-[calc(52rem/16)]
    // w-[calc(52rem/16)] md:h-[calc(62rem/16)] md:w-[calc(62rem/16)]'])[1]";
    // public String uspNumber = "//div[@class='flex max-w-[136px]
    // justify-center']//span[@class='text-[14px] leading-[20px] -mx-[5px]
    // line-clamp-2 h-10 w-20 text-center font-medium']";
    // public String uspCouponBanner = "(//div[@class='h-[calc(52rem/16)]
    // w-[calc(52rem/16)] md:h-[calc(62rem/16)] md:w-[calc(62rem/16)]'])[2]";
    // public String uspBookingCareBanner = "(//div[@class='h-[calc(52rem/16)]
    // w-[calc(52rem/16)] md:h-[calc(62rem/16)] md:w-[calc(62rem/16)]'])[3]";
    // public String uspGeneStoryBanner = "(//div[@class='h-[calc(52rem/16)]
    // w-[calc(52rem/16)] md:h-[calc(62rem/16)] md:w-[calc(62rem/16)]'])[4]";
    // public String uspPXuCodeBanner = "(//div[@class='h-[calc(52rem/16)]
    // w-[calc(52rem/16)] md:h-[calc(62rem/16)] md:w-[calc(62rem/16)]'])[5]";
    // public String uspPXuHistoryBanner = "(//div[@class='h-[calc(52rem/16)]
    // w-[calc(52rem/16)] md:h-[calc(62rem/16)] md:w-[calc(62rem/16)]'])[6]";
    // public String uspPharmacityStoreBanner = "(//div[@class='h-[calc(52rem/16)]
    // w-[calc(52rem/16)] md:h-[calc(62rem/16)] md:w-[calc(62rem/16)]'])[7]";
    // public String uspOnlineConsultBanner = "(//div[@class='h-[calc(52rem/16)]
    // w-[calc(52rem/16)] md:h-[calc(62rem/16)] md:w-[calc(62rem/16)]'])[8]";
    // public String outstandingBrand = "//div[@class='block-title flex p-4
    // md:px-0']//h2[text()='Thương hiệu nổi bật']";
    // public String bestSellingBrand = "//div[@class='pb-4
    // md:container']//h2[text()='Thương hiệu bán chạy']";
    // public String bestSellingProduct = "//div[@class='pb-4
    // md:container']//h2[text()='Sản phẩm bán chạy']";
    // public String diseaseResearch = "//div[@class='container py-3 md:pb-4']";
    // public String seasonalDisease = "//div[@class='container py-4']";
    // public String healthCare = "//div[@class='md:container']//h4[text()='Góc sức
    // khỏe']";
    // public String aboutUs = "//div[@class='hidden md:block']//h2[text()='VỀ CHÚNG
    // TÔI']";

    // public String soldProductCollection = "//div[@class='pb-4 md:container' and
    // @data-collection-code='san-pham-da-mua']";
    // public String soldProductCollectionList = "//div[@class='pb-4 md:container'
    // and @data-collection-code='san-pham-da-mua']//div[@class='product-card flex
    // h-full flex-col']";
    // public String soldProductName = "//h4[text()='Sản phẩm đã mua']";
    // public String soldProductLabel = "//div[@class='pb-4 md:container' and
    // @data-collection-code='san-pham-da-mua']//div[@class='flex flex-1 flex-col
    // justify-end']//div";

    // public String recommendProductCollection = "//div[@class='pb-4
    // md:container'and @data-collection-code='goi-y-danh-cho-ban']";
    // public String recommendCollectionList = "//div[@class='pb-4 md:container'and
    // @data-collection-code='goi-y-danh-cho-ban']//div[@class='product-card flex
    // h-full flex-col']";
    // public String recommendProductName = "//h4[text()='Gợi ý dành riêng cho
    // bạn']";
    // public String recommendProductLabel = "//div[@class='pb-4 md:container'and
    // @data-collection-code='goi-y-danh-cho-ban']//div[@class='flex flex-1 flex-col
    // justify-end']//div";

    // public String bestSellingProductCollection = "//div[@class='pb-4
    // md:container'and @data-collection-code='san-pham-ban-chay']";
    // public String bestSellingProductCollectionList = "//div[@class='pb-4
    // md:container'and
    // @data-collection-code='san-pham-ban-chay']//div[@class='product-card flex
    // h-full flex-col']";
    // public String bestSellingProductName = "//h4[text()='Sản phẩm bán chạy']";
    // public String bestSellingProductLabel = "//div[@class='pb-4 md:container'and
    // @data-collection-code='san-pham-ban-chay']//div[@class='flex flex-1 flex-col
    // justify-end']//div";

    // public String unitProductDetailList = "//div[@class='flex flex-wrap gap-2']";
    // public String lastItemHomePage = "//h4[text()='Công Ty Cổ Phần Dược Phẩm
    // Pharmacity']";

    // public String flashSaleBanner = "//div[@class='h-full w-full bg-gradient-to-t
    // from-hyperLink via-green-500 to-green-200 bg-repeat-x']";

    // public String generalCollection = "//div[@class='md:-ml-1']";

    // public String firstItemRecommend = "(//div[@class='swiper-slide !h-auto
    // !w-[178px] pb-[1px] md:!w-[202.6px] swiper-slide-active'])[2]";

    // public String collection = "//h4[@class='font-semibold line-clamp-1 text-base
    // md:text-[20px]']";
    // public String collectionProduct = "//div[@class='pb-4 md:container']";

    // public String productNormalCollection =
    // "(//div[@class='md:-ml-1'])[2]//a[@class='product-card']";
    // public String normalCollection = "(//div[@class='md:-ml-1'])[2]";
    // public String flashsaleCollection = "(//div[@class='md:-ml-1'])[1]";

    // public String labelProductItem = "//div[@class='flex flex-1 flex-col
    // justify-end']//div";
    public void checkAndChangLanguage(WebDriver driver, String xpathLocator, String popupLocator) {
        BrowserHelper.isDisplayedSuccess(driver, xpathLocator, 1);
        BrowserHelper.waitAndClickElement(driver, xpathLocator, 1);
        BrowserHelper.isDisplayedSuccess(driver, popupLocator, 2);
        List<WebElement> listLangButton = driver.findElements(By.xpath(LIST_BUTTON_LANGUAGE_HEADER_MIDDLE));
        if (listLangButton.size() == 3) {
            BrowserHelper.isDisplayedSuccess(driver, BTN_VIETNAMESE_LANGUAGE_HEADER_MIDDLE, 1);
            BrowserHelper.isDisplayedSuccess(driver, BTN_ENGLISH_LANGUAGE_HEADER_MIDDLE, 1);
            BrowserHelper.isDisplayedSuccess(driver, BTN_OK_LANGUAGE_HEADER_MIDDLE, 1);
        }else{
            System.out.println("List button đang có: " + listLangButton.size() + " nút");
        }

        BrowserHelper.waitAndClickElement(driver, BTN_CLOSE_LANGUAGE_HEADER_MIDDLE, 1);
    }

}
