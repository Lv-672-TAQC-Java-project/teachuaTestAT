package com.ita.edu.teachua.ui.tests;

import com.ita.edu.teachua.ui.pages.home.HomePage;
import com.ita.edu.teachua.ui.pages.user.AddLocationComponent;
import com.ita.edu.teachua.ui.pages.user.MyProfilePage;
import com.ita.edu.teachua.ui.pages.user.EditMyProfileComponent;
import com.ita.edu.teachua.utils.TestNGListener;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AdminAddLocationAddCircleDescriptionTest extends TestRunnerWithValueProvider {
    final String DESCRIPTION_TEXT_40_CHARACTERS = "Lorem ipsum dolor sit amet, consectetuer";
    final String DESCRIPTION_TEXT_1000_CHARACTERS = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean " +
            "commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, " +
            "nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla " +
            "consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim " +
            "justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. " +
            "Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. " +
            "Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, " +
            "viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. " +
            "Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui. " +
            "Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus, sem quam semper libero, sit amet " +
            "adipiscing sem neque sed ipsum. N";
    final String DESCRIPTION_TEXT_1500_CHARACTERS = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean " +
            "commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, " +
            "nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla " +
            "consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim " +
            "justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. " +
            "Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. " +
            "Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, " +
            "viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. " +
            "Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui. " +
            "Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus, sem quam semper libero, sit amet " +
            "adipiscing sem neque sed ipsum. Nam quam nunc, blandit vel, luctus pulvinar, hendrerit id, lorem. " +
            "Maecenas nec odio et ante tincidunt tempus. Donec vitae sapien ut libero venenatis faucibus. Nullam " +
            "quis ante. Etiam sit amet orci eget eros faucibus tincidunt. Duis leo. Sed fringilla mauris sit amet " +
            "nibh. Donec sodales sagittis magna. Sed consequat, leo eget bibendum sodales, augue velit cursus nunc, " +
            "quis gravida magna mi a libero. Fusce vulputate eleifend sapien. Vestibulum purus quam, scelerisque ut, " +
            "mollis sed, nonummy id, met";

    TestNGListener testNGListener = new TestNGListener();

    @Description("Verify that a 'Керівник' cannot add location to the list of locations after leaving all mandatory and optional fields empty")
    @Issue("TUA-160")
    @Test(description = "TUA-160")
    public void verifyThatAdminCanNotAddLocationAfterLeavingAllFieldsEmpty() {
        HomePage homePage = new HomePage(driver);
        homePage.login(valueProvider.getAdminEmail(), valueProvider.getAdminPassword());
        testNGListener.saveScreenshot(driver);
        AddLocationComponent addLocationComponent = homePage
                .getHeader()
                .clickAdminProfile()
                .clickAddCenter()
                .clickAddLocationBtn();
        testNGListener.saveScreenshot(driver);

        boolean isEnable = addLocationComponent.isAddButtonEnable();
        Assert.assertFalse(isEnable);
    }

    @Description("Verify that the ‘Опис’ text field is filled in with valid data when a user enters " +
            "from 40 to 1500 symbols into the field")
    @Issue("TUA-172")
    @Test(description = "TUA-172")
    public void verifyThatDescriptionTextFieldIsFilledInWithValidData() {
        HomePage homePage = new HomePage(driver);
        homePage
                .login(valueProvider.getAdminEmail(), valueProvider.getAdminPassword());
        testNGListener.saveScreenshot(driver);
        MyProfilePage myProfilePage = new MyProfilePage(driver);
        myProfilePage
                .clickDropDownProfileButton()
                .clickMyProfileButton()
                .clickAddButton()
                .clickAddWorkshop();
        testNGListener.saveScreenshot(driver);
        EditMyProfileComponent editMyProfileComponent = new EditMyProfileComponent(driver);
        editMyProfileComponent
                .setWorkshopNameField("Football")
                .setWorkshopCategory("1")
                .setWorkshopAgeRange("7", "9")
                .clickWorkshopNextStageButton()
                .setWorkshopPhoneNumber("0673297976");
        testNGListener.saveScreenshot(driver);
        editMyProfileComponent
                .clickWorkshopNextStageButton();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(editMyProfileComponent
                        .setWorkshopDescriptionField(DESCRIPTION_TEXT_1000_CHARACTERS)
                        .isWorkshopFinishButtonEnable(),
                "Workshop description field should be filled in with the 1000 characters text");
        testNGListener.saveScreenshot(driver);
        softAssert.assertTrue(editMyProfileComponent
                        .setWorkshopDescriptionField(DESCRIPTION_TEXT_40_CHARACTERS)
                        .isWorkshopFinishButtonEnable(),
                "Workshop description field should be filled in with the 40 characters text");
        testNGListener.saveScreenshot(driver);
        softAssert.assertTrue(editMyProfileComponent
                        .setWorkshopDescriptionField(DESCRIPTION_TEXT_1500_CHARACTERS)
                        .isWorkshopFinishButtonEnable(),
                "Workshop description field should be filled in with the 1500 characters text");
        testNGListener.saveScreenshot(driver);
        softAssert.assertAll();
    }
}
