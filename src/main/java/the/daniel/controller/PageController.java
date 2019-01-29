package the.daniel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Daniel
 * @Date: 2019/1/15 16:10
 */
@RequestMapping("page")
@Controller
public class PageController {

    @GetMapping(value = "{pageName}")
    public String toPage(@PathVariable("pageName") String pageName){
        return pageName;
    }

}
