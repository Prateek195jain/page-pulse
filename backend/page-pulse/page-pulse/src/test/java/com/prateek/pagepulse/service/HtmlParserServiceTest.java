package com.prateek.pagepulse.service;

import com.prateek.pagepulse.dto.AuditData;
import com.prateek.pagepulse.dto.FetchedPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HtmlParserServiceTest {

    private final HtmlParserService parserService = new HtmlParserService();

    @Test
    void shouldExtractPageTitle() {

        String html = """
                <html>
                    <head>
                        <title>OpenAI</title>
                    </head>
                    <body></body>
                </html>
                """;

        Document document = Jsoup.parse(html);

        FetchedPage fetchedPage = new FetchedPage(
                document,
                200,
                120,
                "text/html"
        );

        AuditData result = parserService.parse(
                fetchedPage,
                "https://example.com"
        );

        assertEquals("OpenAI", result.getPageTitle());
    }

    @Test
    void shouldExtractMetaDescription() {

        String html = """
            <html>
                <head>
                    <meta name="description" content="Artificial Intelligence Research">
                </head>
                <body></body>
            </html>
            """;

        Document document = Jsoup.parse(html);

        FetchedPage fetchedPage = new FetchedPage(
                document,
                200,
                100,
                "text/html"
        );

        AuditData result = parserService.parse(
                fetchedPage,
                "https://example.com"
        );

        assertEquals(
                "Artificial Intelligence Research",
                result.getMetaDescription()
        );
    }

    @Test
    void shouldCountH1Tags() {

        String html = """
            <html>
                <body>
                    <h1>First</h1>
                    <h1>Second</h1>
                    <h2>Heading</h2>
                </body>
            </html>
            """;

        Document document = Jsoup.parse(html);

        FetchedPage fetchedPage = new FetchedPage(
                document,
                200,
                100,
                "text/html"
        );

        AuditData result = parserService.parse(
                fetchedPage,
                "https://example.com"
        );

        assertEquals(2, result.getH1Count());
    }

    @Test
    void shouldCountImagesMissingAlt() {

        String html = """
            <html>
                <body>
                    <img src="1.jpg">
                    <img src="2.jpg" alt="Image">
                    <img src="3.jpg" alt="">
                    <img src="4.jpg">
                </body>
            </html>
            """;

        Document document = Jsoup.parse(html);

        FetchedPage fetchedPage = new FetchedPage(
                document,
                200,
                100,
                "text/html"
        );

        AuditData result = parserService.parse(
                fetchedPage,
                "https://example.com"
        );

        assertEquals(3, result.getImagesMissingAlt());
    }

    @Test
    void shouldCountWordsInBody() {

        String html = """
            <html>
                <body>
                    Hello world from Page Pulse
                </body>
            </html>
            """;

        Document document = Jsoup.parse(html);

        FetchedPage fetchedPage = new FetchedPage(
                document,
                200,
                100,
                "text/html"
        );

        AuditData result = parserService.parse(
                fetchedPage,
                "https://example.com"
        );

        assertEquals(5, result.getWordCount());
    }

    @Test
    void shouldHandleEmptyHtml() {

        Document document = Jsoup.parse("");

        FetchedPage fetchedPage = new FetchedPage(
                document,
                200,
                100,
                "text/html"
        );

        AuditData result = parserService.parse(
                fetchedPage,
                "https://example.com"
        );

        assertEquals("", result.getPageTitle());
        assertEquals("", result.getMetaDescription());
        assertEquals(0, result.getH1Count());
        assertEquals(0, result.getImagesMissingAlt());
        assertEquals(0, result.getWordCount());
    }

    @Test
    void shouldReturnEmptyMetaDescriptionWhenMissing() {

        String html = """
            <html>
                <head>
                    <title>Test Page</title>
                </head>
                <body></body>
            </html>
            """;

        Document document = Jsoup.parse(html);

        FetchedPage fetchedPage = new FetchedPage(
                document,
                200,
                100,
                "text/html"
        );

        AuditData result = parserService.parse(
                fetchedPage,
                "https://example.com"
        );

        assertEquals("", result.getMetaDescription());
    }
}