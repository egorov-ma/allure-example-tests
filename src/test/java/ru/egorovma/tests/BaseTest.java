package ru.egorovma.tests;

import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Configuration.*;

public class BaseTest {
    @BeforeAll
    static void beforeAll() {
        baseUrl = "https://github.com";
    }
}
