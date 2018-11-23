package configuration;

import exceptions.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import util.JSONUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice(basePackages = {"com.encore.controllers"})
public class GlobalExceptionHandler {
    private static final String AJAX_HEADER = "faces-request";
    private static final String AJAX_HEADER_VALUE = "partial/ajax";

    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public Object defaultErrorHandler(Exception e, HttpServletRequest req, HttpServletResponse response) {
        return handleException(req, response, e.getCause() != null ? e.getCause().toString() : "Teknik bir hata yüzünden işleminiz kesilmiştir.");
    }

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public Object businessException(Exception e, HttpServletRequest req, HttpServletResponse response) {
        String exceptionMsg = e.getMessage();
        return handleBusinessException(req, response, exceptionMsg);
    }

    @ExceptionHandler(BadCredentialsException.class)
    @ResponseBody
    public Object badCredentialException(Exception e, HttpServletRequest req, HttpServletResponse response) {
        String exceptionMsg = e.getMessage();
        return handleBadCredentialException(req, response, exceptionMsg);
    }

    private Object handleException(HttpServletRequest req, HttpServletResponse response, String exceptionMsg) {


        String ajaxHeader = req.getHeader(AJAX_HEADER);

        if (AJAX_HEADER_VALUE.equals(ajaxHeader)) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .header("Content-Type", "application/json; charset=UTF-8")
                    .body(JSONUtil.getJSONResultWithSystemError(exceptionMsg));
        } else {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return new ModelAndView("500");
        }

    }

    private Object handleBadCredentialException(HttpServletRequest req, HttpServletResponse response,
                                                String exceptionMsg) {
        String ajaxHeader = req.getHeader(AJAX_HEADER);

        if (AJAX_HEADER_VALUE.equals(ajaxHeader)) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .header("Content-Type", "application/json; charset=UTF-8")
                    .body(JSONUtil.getJSONResultWithSystemError(exceptionMsg));

        } else {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return new ModelAndView("403");
        }
    }

    private Object handleBusinessException(HttpServletRequest req, HttpServletResponse response, String exceptionMsg) {
        String ajaxHeader = req.getHeader(AJAX_HEADER);
        if (AJAX_HEADER_VALUE.equals(ajaxHeader)) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .header("Content-Type", "application/json; charset=UTF-8")
                    .body(JSONUtil.getJSONResultWithBusinessError(exceptionMsg));
        }
        response.setStatus(HttpServletResponse.SC_OK);
        return response;
    }

}
