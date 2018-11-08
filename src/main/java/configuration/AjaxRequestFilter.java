package configuration;

import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class AjaxRequestFilter  extends GenericFilterBean {


    private static final String FACES_REQUEST_HEADER = "faces-request";

    private String invalidSessionUrl;

    boolean ajaxRequestReceived = false;

    boolean sessionExpired = false;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = null;
        if (request instanceof HttpServletRequest) {
            httpRequest = (HttpServletRequest) request;
            ajaxRequestReceived = "partial/ajax".equals(httpRequest
                    .getHeader(FACES_REQUEST_HEADER));
            sessionExpired = hasSessionExpired(httpRequest);
        }

        if (sessionExpired && ajaxRequestReceived && httpRequest!=null) {
            performRedirect(httpRequest, response);
        } else {
            chain.doFilter(request, response);
        }

    }
    private void performRedirect(HttpServletRequest request,  ServletResponse response) throws IOException {
        String contextPath = request.getContextPath();
        String redirectUrl = contextPath + invalidSessionUrl;

        String ajaxRedirectJson =JSONUtil.getJSONResultWithSuccess(redirectUrl);

        response.setContentType("application/json");
        response.getWriter().write(ajaxRedirectJson);
    }

    private boolean hasSessionExpired(HttpServletRequest httpRequest) {
        return (httpRequest != null && !httpRequest.isRequestedSessionIdValid()) ;
    }

    public void setInvalidSessionUrl(String invalidSessionUrl) {
        this.invalidSessionUrl = invalidSessionUrl;
    }

}
