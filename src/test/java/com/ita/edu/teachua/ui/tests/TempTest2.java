package com.ita.edu.teachua.ui.tests;


import com.ita.edu.teachua.utils.jdbc.entity.ChallengesEntity;
import com.ita.edu.teachua.utils.jdbc.entity.NewsEntity;
import com.ita.edu.teachua.utils.jdbc.entity.UserEntity;
import com.ita.edu.teachua.utils.jdbc.services.ChallengesService;
import com.ita.edu.teachua.utils.jdbc.services.NewsService;
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
    public void Challenges() {
        ChallengesService challengesService = new ChallengesService();
        List<ChallengesEntity> challenges = challengesService.getAllChallenges();
        for (ChallengesEntity challenge : challenges) {
            System.out.println(challenge);
        }
    }

    @Test
    public void News() {
        NewsService newsService = new NewsService();
        List<NewsEntity> news = newsService.getAllNews();
        for (NewsEntity newsItem : news) {
            System.out.println(newsItem);
        }
    }
}
