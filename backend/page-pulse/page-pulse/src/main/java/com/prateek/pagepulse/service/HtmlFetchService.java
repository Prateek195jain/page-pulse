package com.prateek.pagepulse.service;

import com.prateek.pagepulse.dto.FetchedPage;
import com.prateek.pagepulse.exception.FetchFailedException;
import com.prateek.pagepulse.exception.NonHtmlException;
import com.prateek.pagepulse.exception.TimeoutException;
import org.jsoup.Connection;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.UnsupportedMimeTypeException;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.SocketTimeoutException;

@Service
public class HtmlFetchService {

    public FetchedPage fetchPage(String url) {

        try {

            long startTime = System.currentTimeMillis();

            Connection.Response response = Jsoup
                    .connect(url)
                    .timeout(5000)
                    .ignoreHttpErrors(true)
                    .execute();

            long endTime = System.currentTimeMillis();

            String contentType = response.contentType();

            if (contentType == null || !contentType.toLowerCase().contains("text/html")) {
                throw new NonHtmlException("The URL does not point to an HTML page.");
            }

            Document document = response.parse();

            return new FetchedPage(
                    document,
                    response.statusCode(),
                    endTime - startTime,
                    contentType
            );

        } catch (SocketTimeoutException e) {

            throw new TimeoutException("The website took too long to respond.");

        } catch (UnsupportedMimeTypeException e) {

            throw new NonHtmlException("The URL does not point to an HTML page.");

        } catch (IOException e) {

            throw new FetchFailedException(
                    "Unable to retrieve the webpage. The resource may be inaccessible, blocked, or temporarily unavailable."
            );

        }
    }
}