package ru.egorovma.steps;

import com.codeborne.selenide.*;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class GitHubIssuesLinksSteps {

    private final SelenideElement searchInput = $("span[data-target='qbsearch-input.inputButtonText']"),
            searchTextInput = $("#query-builder-test"),
            linkIssuesTab = $("#issues-tab");

    private final ElementsCollection resultsList = $$("div[data-testid='results-list'] a");
    private final ElementsCollection issues = $$("div[class='js-navigation-container js-active-navigation-container'] a");

    @Step("Открываем главную страницу {url}")
    public GitHubIssuesLinksSteps openMainPage(String url) {
        open(url);
        return this;
    }

    @Step("Ищем репозиторий {repo} и переходим в него")
    public GitHubIssuesLinksSteps findForRepository(String repo) {
        searchInput.click();
        searchTextInput.setValue(repo).pressEnter();
        resultsList.findBy(text(repo)).click();
        return this;
    }

    @Step("Открываем таб Issues")
    public void openIssuesTab() {
        linkIssuesTab.click();
    }

    @Step("Проверяем наличие Issue с текстом {issue}")
    public void checkIssueWithText(String issue) {
        issues.first().shouldHave(text(issue));
    }
}