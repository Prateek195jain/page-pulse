package com.prateek.pagepulse.service;

import com.prateek.pagepulse.dto.AuditData;
import com.prateek.pagepulse.dto.FetchedPage;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

@Service
public class HtmlParserService {

    public AuditData parse(FetchedPage fetchedPage, String url) {

        Document document = fetchedPage.getDocument();

        String pageTitle = document.title();

        Element metaDescriptionElement =
                document.selectFirst("meta[name=description]");

        String metaDescription =
                metaDescriptionElement != null
                        ? metaDescriptionElement.attr("content")
                        : "";

        int h1Count = document.select("h1").size();

        int imagesMissingAlt = (int) document.select("img")
                .stream()
                .filter(image -> !image.hasAttr("alt") || image.attr("alt").isBlank())
                .count();

        String bodyText = document.body() != null
                ? document.body().text().trim()
                : "";

        int wordCount = bodyText.isEmpty()
                ? 0
                : bodyText.split("\\s+").length;

        return new AuditData(
                url,
                fetchedPage.getHttpStatus(),
                fetchedPage.getResponseTimeMs(),
                pageTitle,
                metaDescription,
                h1Count,
                imagesMissingAlt,
                wordCount
        );
    }
}