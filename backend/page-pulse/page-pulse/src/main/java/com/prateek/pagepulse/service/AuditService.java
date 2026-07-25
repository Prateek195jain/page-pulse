package com.prateek.pagepulse.service;

import com.prateek.pagepulse.dto.AuditData;
import com.prateek.pagepulse.dto.AuditResponse;
import com.prateek.pagepulse.dto.FetchedPage;
import com.prateek.pagepulse.exception.InvalidUrlException;
import com.prateek.pagepulse.util.UrlValidator;
import org.springframework.stereotype.Service;

@Service
public class AuditService {

    private final HtmlFetchService htmlFetchService;
    private final HtmlParserService htmlParserService;

    public AuditService(HtmlFetchService htmlFetchService,
                        HtmlParserService htmlParserService) {

        this.htmlFetchService = htmlFetchService;
        this.htmlParserService = htmlParserService;
    }

    public AuditResponse audit(String url) {

        if (!UrlValidator.isValid(url)) {
            throw new InvalidUrlException("Please enter a valid URL.");
        }

        FetchedPage fetchedPage = htmlFetchService.fetchPage(url);

        AuditData auditData = htmlParserService.parse(fetchedPage, url);

        return new AuditResponse(true, auditData);
    }
}