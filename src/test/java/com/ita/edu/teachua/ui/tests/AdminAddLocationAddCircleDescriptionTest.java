package com.ita.edu.teachua.ui.tests;

import com.ita.edu.teachua.ui.pages.home.HomePage;
import com.ita.edu.teachua.ui.pages.user.MyProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AdminAddLocationAddCircleDescriptionTest extends TestRunnerWithValueProvider {
    final String descriptionText40Characters = "Lorem ipsum dolor sit amet, consectetuer";
    final String descriptionText1000Characters = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean " +
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
    final String descriptionText1500Characters = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean " +
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

    @Test(description = "TUA-160")
    public void verifyThatAdminCanNotAddLocationAfterLeavingAllFieldsEmpty() {
        HomePage homePage = new HomePage(driver);
        homePage.login(valueProvider.getAdminEmail(), valueProvider.getAdminPassword());

        boolean isEnable = homePage
                .getHeader()
                .clickAdminProfile()
                .clickAddCenter()
                .clickAddLocationBtn()
                .isAddButtonEnable();

        Assert.assertFalse(isEnable);
    }

    @Test(description = "TUA-172")
    public void verifyThatDescriptionTextFieldIsFilledInWithValidData() {
        HomePage homePage = new HomePage(driver);
        homePage
                .login(valueProvider.getAdminEmail(), valueProvider.getAdminPassword());

        MyProfilePage myProfilePage = new MyProfilePage(driver);
        myProfilePage
                .clickDropDownProfileButton()
                .clickMyProfileButton()
                .clickAddButton()
                .clickAddCircle()
                .setCircleNameField("Football")
                .setCircleCategory("1")
                .setCircleAgeRange("7", "9")
                .clickCircleNextStageButton()
                .setCirclePhoneNumber("0673297976")
                .clickCircleNextStageButton();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(myProfilePage
                .setDescriptionField(descriptionText1000Characters)
                .isCircleFinishButtonEnable());
        softAssert.assertTrue(myProfilePage
                .setDescriptionField(descriptionText40Characters)
                .isCircleFinishButtonEnable());
        softAssert.assertTrue(myProfilePage
                .setDescriptionField(descriptionText1500Characters)
                .isCircleFinishButtonEnable());
        softAssert.assertAll();
    }
}
