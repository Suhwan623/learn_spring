package kr.hs.gbsw.tree.article.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class HelloWorldController {
    @GetMapping("/helloworld")
    public String sayHelloWorld(){
        return "Hello, world!";
    }
    @GetMapping("/books/{bookName}")
    public String getBook(
            @PathVariable String bookName,
            @RequestParam
            String format,
            @RequestParam(value = "lang", required = false)
            String language
    ){
        return String.format(
                "%s, %s, %s",
                bookName,
                format,
                language
        );
    }
}
