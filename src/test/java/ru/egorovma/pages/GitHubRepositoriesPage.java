package ru.egorovma.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class GitHubRepositoriesPage {

    SelenideElement linkIssuesTab = $("#issues-tab");
    ElementsCollection issues = $$("div[class='js-navigation-container js-active-navigation-container'] a");

    public void openIssuesTab() {
        linkIssuesTab.click();
    }

    public void checkIssueWithText(String issue) {
        issues.first().shouldHave(text(issue));
    }
}