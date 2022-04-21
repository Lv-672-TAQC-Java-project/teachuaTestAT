package com.ita.edu.teachua.ui.tests;


import com.ita.edu.teachua.utils.jdbc.entity.FeedbackEntity;
import com.ita.edu.teachua.utils.jdbc.entity.UserEntity;
import com.ita.edu.teachua.utils.jdbc.services.FeedbackService;
import com.ita.edu.teachua.utils.jdbc.services.UserService;
import org.testng.annotations.Test;

import java.util.List;

//public class TempTest2 extends TestRunnerWithValueProvider {
public class TempTest2 {


    //    @Test
//    public void test3() {
//        HomePage home = new HomePage(driver);
//        SoftAssert softAssert = new SoftAssert();
//        home
//                .getHeader()
//                .clickUserProfile()
//                .clickLogin()
//                .setEmail(valueProvider.getAdminEmail())
//                .setPassword(valueProvider.getAdminPassword())
//                .clickLoginButton();
//
//    }
//
    @Test
    public void test4() {
        UserService userService = new UserService();
        List<UserEntity> users = userService.getAllUsers();
        for (UserEntity user : users) {
            System.out.println(user);
        }

    }

    @Test
    public void test5() {
        FeedbackService feedbackService = new FeedbackService();
        List<FeedbackEntity> feedbacks = feedbackService.getAllFeedbacks();

//        FeedbackEntity feedback = new FeedbackEntity();
//        System.out.println(feedback);

        for (FeedbackEntity feedback : feedbacks) {
            System.out.println(feedback);
        }
    }
}
