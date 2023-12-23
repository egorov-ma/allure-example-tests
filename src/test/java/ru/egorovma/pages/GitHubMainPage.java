package ru.egorovma.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class GitHubMainPage {
    private final SelenideElement searchInput = $("span[data-target='qbsearch-input.inputButtonText']"),
            searchTextInput = $("#query-builder-test");

    public GitHubMainPage openMainPage(String url) {
        open(url);
        return this;
    }

    public void findForRepository(String repo) {
        searchInput.click();
        searchTextInput.setValue(repo).pressEnter();
    }
}