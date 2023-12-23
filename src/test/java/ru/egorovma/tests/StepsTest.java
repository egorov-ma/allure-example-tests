package ru.egorovma.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.egorovma.pages.GitHubFilterPage;
import ru.egorovma.pages.GitHubMainPage;
import ru.egorovma.pages.GitHubRepositoriesPage;
import ru.egorovma.steps.GitHubIssuesLinksSteps;

import static com.codeborne.selenide.Configuration.baseUrl;
import static io.qameta.allure.Allure.step;

public class StepsTest extends BaseTest {

    GitHubMainPage mainPage = new GitHubMainPage();
    GitHubFilterPage filterPage = new GitHubFilterPage();
    GitHubRepositoriesPage repositoriesPage = new GitHubRepositoriesPage();

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String FIND_ISSUE = "allure";

    @Test
    @DisplayName("Check issue with listener step")
    void checkIssueWithListenerTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        mainPage.openMainPage(baseUrl)
                .findForRepository(REPOSITORY);
        filterPage.findForRepository(REPOSITORY);
        repositoriesPage.openIssuesTab();

        repositoriesPage.checkIssueWithText(FIND_ISSUE);

    }

    @Test
    @DisplayName("Check issue with lambda step")
    public void checkIssueWithLambdaStepTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу " + baseUrl, () -> mainPage.openMainPage(baseUrl));
        step("Ищем репозиторий " + REPOSITORY, () -> mainPage.findForRepository(REPOSITORY));
        step("Кликаем по ссылке репозитория " + REPOSITORY, () -> filterPage.findForRepository(REPOSITORY));
        step("Открываем таб Issues", () -> repositoriesPage.openIssuesTab());

        step("Проверяем наличие Issue с номером " + FIND_ISSUE, () -> repositoriesPage.checkIssueWithText(FIND_ISSUE));
    }

    @Test
    @DisplayName("Check issue with annotated step")
    public void checkIssueWithAnnotatedStepTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        GitHubIssuesLinksSteps steps = new GitHubIssuesLinksSteps();

        steps.openMainPage(baseUrl)
                .findForRepository(REPOSITORY)
                .openIssuesTab();

        steps.checkIssueWithText(FIND_ISSUE);
    }
}