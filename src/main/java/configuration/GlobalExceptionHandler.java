package configuration;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import exceptions.BusinessException;
import org.springframework.web.servlet.view.RedirectView;
import util.JSONUtil;

@ControllerAdvice(basePackages= {"com.encore.controllers"})
public class GlobalExceptionHandler {
    private static final String AJAX_HEADER="faces-request";
    private static final String AJAX_HEADER_VALUE="partial/ajax";

    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public Object businessException(Exception e, HttpServletRequest req, HttpServletResponse response)  {
        String exceptionMsg = e.getMessage();
        return handleBusinessException(req, response, exceptionMsg);
    }

   @ExceptionHandler(value = {BadCredentialsException.class})
    @ResponseBody
    public Object badCredentialException(Exception e, HttpServletRequest req, HttpServletResponse response)  {
        String exceptionMsg = e.getMessage();
        return handleBadCredentialException(req, response, exceptionMsg);
    }

  
    @ExceptionHandler(value = Throwable.class)
    @ResponseBody
    public Object defaultErrorHandler(Exception e, HttpServletRequest req, HttpServletResponse response)  {
        return handleException(req, response, ExceptionUtils.getStackTrace(e));
    }



    private Object handleException(HttpServletRequest req, HttpServletResponse response, String exceptionMsg) {


        String ajaxHeader = req.getHeader(AJAX_HEADER);

        if (AJAX_HEADER_VALUE.equals(ajaxHeader)) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return JSONUtil.getJSONResultWithSystemError(exceptionMsg);
        }
        else{
            RedirectView rv = new RedirectView();
            rv.setUrl("app/500");
            rv.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
            return rv;

        }

    }
    private Object handleBadCredentialException(HttpServletRequest req, HttpServletResponse response,
                                                String exceptionMsg) {
    	 String ajaxHeader = req.getHeader(AJAX_HEADER);

         if (AJAX_HEADER_VALUE.equals(ajaxHeader)) {
             response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
             return JSONUtil.getJSONResultWithSystemError(exceptionMsg);
         }
         else{
                 RedirectView rv = new RedirectView();
                 rv.setUrl("app/403");
                 rv.setStatusCode(HttpStatus.FORBIDDEN);
                 return rv;
         }
    }

    private Object handleBusinessException(HttpServletRequest req, HttpServletResponse response, String exceptionMsg) {
        String ajaxHeader = req.getHeader(AJAX_HEADER);
        if (AJAX_HEADER_VALUE.equals(ajaxHeader)) {
            response.setStatus(HttpServletResponse.SC_OK);
            return JSONUtil.getJSONResultWithBusinessError(exceptionMsg);
        }
        else{
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        return response;
    }

}
