package com.cado.service.impl;
import com.cado.service.GenerateHTML;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class GenerateHTMLImpl implements GenerateHTML {

    public String htmlSimple = "<!DOCTYPE html>\n" +
            "<html>\n" +
            "<head>\n" +
            "    <title>Hello, World! #1</title>\n" +
            "</head>\n" +
            "<body>\n" +
            "    <h1>Hello, World! #1</h1>\n" +
            "</body>\n" +
            "</html>";
    public String htmlInput = "<!DOCTYPE html>\n" +
            "<html>\n" +
            "<head>\n" +
            "    <title>Hello, World with Input</title>\n" +
            "</head>\n" +
            "<body>\n" +
            "    <h1>Hello, World! #2</h1>\n" +
            "    <div>\n" +
            "        <input type=\"text\" placeholder=\"Your name here\">\n" +
            "    </div>\n" +
            "</body>\n" +
            "</html>\n";
    public String htmlButton = "<!DOCTYPE html>\n" +
            "<html>\n" +
            "<head>\n" +
            "    <title>Hello, World with Input</title>\n" +
            "</head>\n" +
            "<body>\n" +
            "    <h1>Hello, World! #3</h1>\n" +
            "    <div>\n" +
            "        <input type=\"text\" id=\"nameInput\" placeholder=\"Enter your name\">\n" +
            "        <button id=\"sayHiButton\">Say Hi</button>\n" +
            "    </div>\n" +
            "\n" +
            "    <script>\n" +
            "        document.getElementById(\"sayHiButton\").addEventListener(\"click\", function () {\n" +
            "            var name = document.getElementById(\"nameInput\").value;\n" +
            "            alert(\"Hello, \" + name + \"!\");\n" +
            "        });\n" +
            "    </script>\n" +
            "</body>\n" +
            "</html>\n";
    public GenerateHTMLImpl(){}

    @Async
    public CompletableFuture<String> getHTMLSimple() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        return CompletableFuture.completedFuture(this.htmlSimple);
    }
    @Async
    public CompletableFuture<String> getHtmlInput() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        return CompletableFuture.completedFuture(this.htmlInput);
    }
    @Async
    public CompletableFuture<String> getHtmlButton() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        return CompletableFuture.completedFuture(this.htmlButton);
    }
}
