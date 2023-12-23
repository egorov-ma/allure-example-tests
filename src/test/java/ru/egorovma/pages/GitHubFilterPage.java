package ru.egorovma.pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

public class GitHubFilterPage {
    private final ElementsCollection resultsList = $$("div[data-testid='results-list'] a");

    public void findForRepository(String repo) {
        resultsList.findBy(text(repo)).click();
    }
}
