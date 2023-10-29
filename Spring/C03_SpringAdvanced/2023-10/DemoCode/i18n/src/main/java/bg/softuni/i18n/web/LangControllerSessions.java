package bg.softuni.i18n.web;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LangControllerSessions {

  @GetMapping("/session")
  public String getLang(
      HttpSession session,
      Model model) {

    var lang = session.getAttribute("lang");
    if (lang == null) {
      lang = "bg";
    }

    session.setAttribute("name", "Ivan");

    model.addAttribute("lang", lang);

    return "lang-view-session";
  }

  @PostMapping("/session")
  public String postLang(@RequestParam("lang") String lang,
      HttpSession session) {

    session.setAttribute("lang", lang);

    return "redirect:/session";
  }

}
