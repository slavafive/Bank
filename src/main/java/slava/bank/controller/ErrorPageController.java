package slava.bank.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ErrorPageController implements ErrorController {

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        String message = null;
        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());
            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                message = "Page Not Found";
            } else if (statusCode == HttpStatus.FORBIDDEN.value()) {
                message = "Access Denied";
            } else if (statusCode == HttpStatus.METHOD_NOT_ALLOWED.value()) {
                message = "Method Not Allowed";
            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                message = "Internal Server Error";
            } else {
                message = "Something Went Wrong";
            }
        }
        model.addAttribute("message", message);
        return "error/error";
    }

}
