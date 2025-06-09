package com.pharmacity.locators;

public class HomePageLocator {

    // --- Banner khi mới vào trang website
    public static final String BANNER_ADS = "//div[@class='flex w-auto items-center justify-center']";
    public static final String BTN_ADS_BANNER_CLOSE = "//div[@class='flex w-auto items-center justify-center']//button";

    // --- Các banner trong phần Theader 
    //-- Top header
    public static final String BANNER_HEADER_TOP = "//div[@class='hidden md:block']//div[@data-topbanner='true']";

    //-- Middle header
    public static final String HEADER_MIDDLE = "//div[@class='hidden h-8 bg-primary-50 md:flex']";
    public static final String ICON_DOWNLOAD_HEADER_MIDDLE = "//div[@class='hidden h-8 bg-primary-50 md:flex']//span[@class='p-icon inline-flex align-[-0.125em] justify-center max-h-full max-w-full w-4 h-4 p-0']";
    public static final String TXT_DOWNLOAD_HEADER_MIDDLE = "//div[@class='hidden h-8 bg-primary-50 md:flex']//span[text()='Tải ứng dụng']";
    public static final String ATR_DOWNLOAD_HEADER_MIDDLE = "//div[@class='flex cursor-pointer items-center gap-1 whitespace-nowrap text-xs']";
    public static final String POPUP_DOWNLOAD_HEADER_MIDDLE = "//div[@style='position: fixed; left: 0px; top: 0px; transform: translate(164px, 88px); min-width: max-content; --radix-popper-transform-origin: 46.462501525878906px -10px; z-index: 1000; --radix-popper-available-width: 1364px; --radix-popper-available-height: 597.5999755859375px; --radix-popper-anchor-width: 94.92500305175781px; --radix-popper-anchor-height: 24px;']";
    
    public static final String ATR_LANGUAGE_HEADER_MIDDLE = "(//div[@class='flex cursor-pointer items-center'])[1]";
    public static final String ICON_LANGUAGE_HEADER_MIDDLE = "(//div[@class='flex cursor-pointer items-center']//img[@src='https://prod-cdn.pharmacity.io/e-com/images/ecommerce/20241009074539-0-flag_VietNam.png'])[1]";
    public static final String POPUP_LANGUAGE_HEADER_MIDDLE = "(//div[@class='flex w-full flex-col space-y-1.5 px-4 pb-2 md:px-6 md:pt-7 fixed left-0 top-0 pt-6']//ancestor::div)[1]";
    public static final String LIST_BUTTON_LANGUAGE_HEADER_MIDDLE = "//div[@class='grid grid-cols-2 gap-4']//button[@type='button']";
    public static final String BTN_VIETNAMESE_LANGUAGE_HEADER_MIDDLE = "//button[@type='button' and text()='Tiếng Việt']";
    public static final String BTN_ENGLISH_LANGUAGE_HEADER_MIDDLE = "//button[@type='button' and text()='English']";
    public static final String BTN_OK_LANGUAGE_HEADER_MIDDLE = "//button[@type='button']//span[text()='Chọn']";
    public static final String BTN_CLOSE_LANGUAGE_HEADER_MIDDLE = "//button[@type='button' and @class='fixed right-2 top-5 rounded-sm opacity-100 outline-0 ring-offset-background transition-opacity hover:opacity-80 md:right-4 md:top-6 z-10']";
    
    public static final String ATR_HOTLINE_HEADER_MIDDLE = "//span[@class='shrink-0 whitespace-nowrap']";
    public static final String TXT_HOTLINE_PHONENUMBER_HEADER_MIDDLE = "//span[@class='shrink-0 whitespace-nowrap']//span[text()='1800 6821']";
    
    public static final String TXT_BIZ_HEADER_MIDDLE = "//p[@title='Doanh nghiệp']";
    public static final String TXT_HOTDEAL_HEADER_MIDDLE = "//p[@title='Deal hot tháng 5 🔥']";
    public static final String TXT_ORDER_RESEARCH_HEADER_MIDDLE = "//p[@title='Tra cứu đơn hàng']";
    public static final String TXT_HEALTH_HEADER_MIDDLE = "//p[@title='Góc sức khỏe']";
    public static final String TXT_MEDICAL_SYSTEM_HEADER_MIDDLE = "//p[@title='Hệ thống nhà thuốc']";
    
    //-- Bottom header
    public static final String HEADER_BOTTOM = "//div[@class='mx-auto w-full md:container md:relative md:pb-3 md:pt-4']";
    public static final String ICON_HEADER_BOTTOM = "//div[@class='hidden flex-shrink-0 md:flex md:w-[187px] md:justify-center']//img[@src='https://prod-cdn.pharmacity.io/e-com/images/static-website/pharmacity-logo.svg']";
    
    public static final String FIELD_SEARCH_BOTTOM = "//div[@class='w-full border-neutral-500 placeholder:text-neutral-600 focus:ring-neutral-500 focus:border-neutral-700 outline-none p-3.5 search-input flex h-10 items-center justify-start rounded-sm border-0 bg-white py-1 pl-10 text-start text-sm font-medium text-neutral-700']";
    public static final String TXT_SEARCH_BOTTOM = "//div[@class='w-full border-neutral-500 placeholder:text-neutral-600 focus:ring-neutral-500 focus:border-neutral-700 outline-none p-3.5 search-input flex h-10 items-center justify-start rounded-sm border-0 bg-white py-1 pl-10 text-start text-sm font-medium text-neutral-700']//span";  
    
    public static final String ICON_NOTIFICATION_HEADER_BOTTOM = "(//div[@class='absolute bottom-0 left-0 right-0 top-0']//button)[1]";
    public static final String NUMB_NOTIFICATION_HEADER_BOTTOM = "(//div[@class='absolute bottom-0 left-0 right-0 top-0']//button//div)[1]";
    
    public static final String ICON_CART_HEADER_BOTTOM = "(//div[@class='absolute bottom-0 left-0 right-0 top-0']//button)[2]";
    public static final String NUMB_CART_HEADER_BOTTOM = "(//div[@class='absolute bottom-0 left-0 right-0 top-0']//button//div)[2]";
    
    public static final String FIELD_PROFILE_HEADER_BOTTOM = "//div[@class='hidden  md:inline-flex']//button";
    public static final String TXT_PROFILE_HEADER_BOTTOM = "//div[@class='hidden  md:inline-flex']//button//div";
    
    public static final String FIELD_TRENDING_KEY_HEADER_BOTTOM = "//div[@class='mt-[3px] line-clamp-1 hidden h-5 flex-wrap space-x-3 text-xs text-white md:flex']";
    public static final String LIST_TRENDING_KEY_HEADER_BOTTOM = "//div[@class='mt-[3px] line-clamp-1 hidden h-5 flex-wrap space-x-3 text-xs text-white md:flex']//span";

    public static final String FIELD_CATEGORY_MENU_HEADER_BOTTOM = "//div[@class='category']";
    public static final String BTN_CATEGORY_MENU_HEADER_BOTTOM = "//div[@class='category']//button";
    public static final String TXT_CATEGORY_MENU_HEADER_BOTTOM = "//span[@class='shrink-0 whitespace-nowrap']";

    public static final String FIELD_CATEGORY_PLAYLIST_HEADER_BOTTOM = "//div[@class='relative text-sm text-white']";
    public static final String LIST_CATEGORY_PLAYLIST_HEADER_BOTTOM = "//div[@class='relative text-sm text-white']//div[@class='swiper-wrapper']";
    public static final String TXT_CATEGORY_PLAYLIST_HEADER_BOTTOM = "//div[@class='relative text-sm text-white']//div[@class='swiper-wrapper']//span";


    //MAIN BANNER
    public static final String BANNER_MAIN = "//div[@class='swiper swiper-initialized swiper-horizontal custom-swiper-navigation w-full banner aspect-banner-image-mobile h-full overflow-hidden md:rounded-xl']";
    public static final String BANNER_CORNER_TOP_RIGHT = "(//div[@class='hidden w-full grid-rows-2 gap-4 md:grid md:w-[389px]']//div[@class='h-full w-full'])[1]";
    public static final String BANNER_CORNER_BOTTOM_RIGHT = "(//div[@class='hidden w-full grid-rows-2 gap-4 md:grid md:w-[389px]']//div[@class='h-full w-full'])[2]";
    public static final String FIELD_BANNER_USP = "//div[@class='swiper swiper-initialized swiper-horizontal swiper-free-mode custom-swiper-navigation w-full mySwiper pmc-services']";
    public static final String LIST_BANNER_USP = "//div[@class='swiper-wrapper']//div[contains(@class, 'swiper-slide')]//div[@class='grid w-[80px] justify-items-center gap-1.5']";
    public static final String TXT_BANNER_USP = "//div[@class='swiper-wrapper']//div[contains(@class, 'swiper-slide')]//div[@class='grid w-[80px] justify-items-center gap-1.5']//span";
    
    //FLash Sale Collection
    public static final String FIELD_FLASH_SALE = "//div[@class='w-full']//div[@class='sm:container']//ancestor::div[@class='w-full']";
    public static final String LIST_FLASH_SALE = "//div[@class='relative py-4 sm:pl-1']//div[contains(@class,'swiper-slide !h-auto !w-[178px]')]";
    public static final String BTN_CHOOSE_PRODUCt_FLASH_SALE = "//div[@class='relative py-4 sm:pl-1']//div[contains(@class,'swiper-slide !h-auto !w-[178px]')]//button[@type='button']";
    public static final String BTN_MORE_FLASH_SALE = "//div[@class='w-full']//a[text()='Xem thêm']";
    
    //"Sản phẩm đã mua" collection
    public static final String ATR_COLLECTION_SOLD_PRODUCT = "//div[@class='pb-4 md:container' and @data-collection-code='san-pham-da-mua']";
    public static final String LIST_COLLECTION_SOLD_PRODUCT = "//div[@class='pb-4 md:container' and @data-collection-code='san-pham-da-mua']//div[@class='product-card flex h-full flex-col']";
    
    //"Gợi ý dành riêng cho bạn" collection
    public static final String ATR_COLLECTION_RECOMMEND_PRODUCT = "//div[@class='pb-4 md:container'and @data-collection-code='goi-y-danh-cho-ban']";
    public static final String LIST_COLLECTION_RECOMMEND = "//div[@class='pb-4 md:container'and @data-collection-code='goi-y-danh-cho-ban']//div[@class='product-card flex h-full flex-col']";
    
    //"Thương hiệu nổi bật" collection
    public static final String ATR_OUTSTANDING_BRAND = "//h4[text()='Thương hiệu nổi bật']//ancestor::div[@class='pb-4 md:container']";
    public static final String TITLE_OUTSTANDING_BRAND = "//div[@class='pb-4 md:container']//h4[text()='Thương hiệu nổi bật']";
    public static final String LIST_OUTSTANDING_BRAND = "//h4[text()='Thương hiệu nổi bật']//ancestor::div[@class='pb-4 md:container']//div[contains(@class,'swiper-slide mr-2 !w-[126px]')]";
    public static final String BTN_MORE_OUTSTANDING_BRAND = "//h4[text()='Thương hiệu nổi bật']//ancestor::div[@class='pb-4 md:container']//a[text()='Xem thêm']";
    
    //"Danh mục nổi bật" collection
    public static final String ATR_FEATURES_CATEGORIES = "//h4[text()='Danh mục nổi bật']//ancestor::div[@class='container pb-4']";
    public static final String TITLE_FEATURES_CATEGORIES = "//div[@class='container pb-4']//h4[text()='Danh mục nổi bật']";
    public static final String LIST_FEATURES_CATEGORIES = "//div[@class='container pb-4']//a[@class='flex items-center  gap-2 rounded-lg border p-2']";
    
    //"Thương hiệu bán chạy" banner
    public static final String ATR_BEST_SELLING_BRAND = "//h4[text()='Thương hiệu bán chạy']//ancestor::div[@class='md:container md:pb-6']";
    public static final String TITLE_BEST_SELLING_BRAND = "//div[@class='md:container md:pb-6']//h4[text()='Thương hiệu bán chạy']";
    public static final String ATR_BEST_SELLING_BRAND_MAIN = "//div[@class='md:container md:pb-6']//div[@class='z-[1] row-span-2 -mr-1 pr-1 md:col-span-2 md:mr-0 md:h-auto md:pr-0']";
    public static final String LIST_BEST_SELLING_BRAND = "//div[@class='md:container md:pb-6']//a[@class='group relative']";
    
    //"Sản phẩm bán chạy" collection
    public static final String ATR_BEST_SELLING_PRODUCT = "//h4[text()='Sản phẩm bán chạy']//ancestor::div[@class='pb-4 md:container']";
    public static final String TXT_BEST_SELLING_PRODUCT = "//div[@class='pb-4 md:container']//h4[text()='Sản phẩm bán chạy']";
    public static final String LIST_BEST_SELLING_PRODUCT = "//h4[text()='Sản phẩm bán chạy']//ancestor::div[@class='pb-4 md:container']//div[contains(@class,'swiper-slide !h-auto')]";
    public static final String BTN_MORE_BEST_SELLING_PRODUCT = "//h4[text()='Sản phẩm bán chạy']//ancestor::div[@class='pb-4 md:container']//a[text()='Xem thêm']";

    //"Tra cứu bệnh" function
    public static final String ATR_DISEASE_LOOKUP = "//h4[text()='Tra cứu bệnh']//ancestor::div[@class='container py-3 md:pb-4']";
    public static final String TXT_DISEASE_LOOKUP = "//div[@class='container py-3 md:pb-4']////h4[text()='Tra cứu bệnh']";
    public static final String LIST_DISEASE_LOOKUP = "//h4[text()='Tra cứu bệnh']//ancestor::div[@class='container py-3 md:pb-4']//div[@class='flex items-center rounded-md shadow-lg relative gap-0']";
    public static final String BTN_MORE_DISEASE_LOOKUP = "//h4[text()='Tra cứu bệnh']//ancestor::div[@class='container py-3 md:pb-4']//a[text()='Xem thêm']";

    //"Nhóm bệnh theo mua" collection
    public static final String ATR_SEASONAL_DISEASE = "//h4[text()='Nhóm bệnh theo mùa']//ancestor::div[@class='container py-4']";
    public static final String TXT_SEASONAL_DISEASE = "//div[@class='container py-4']//h4[text()='Nhóm bệnh theo mùa']";
    public static final String LIST_SEASONAL_DISEASE = "//h4[text()='Nhóm bệnh theo mùa']//ancestor::div[@class='container py-4']//div[@class='flex items-center gap-2 rounded-md shadow-lg']";
    public static final String BTN_MORE_SEASONAL_DISEASE = "//h4[text()='Nhóm bệnh theo mùa']//ancestor::div[@class='container py-4']//a[text()='Xem thêm']";
    
    //"Góc sức khỏe" page
    public static final String TXT_SEASONAL_DISEASE = "//div[@class='container py-4']//h4[text()='Nhóm bệnh theo mùa']";

    

} 
