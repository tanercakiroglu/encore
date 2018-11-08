package configuration;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.codehaus.jackson.map.ObjectMapper;

/**
 * 
 * @author  taner cakiroglu
 *
 */

public class SecurityUtil {

	private SecurityUtil(){}

	private static final ObjectMapper mapper = new ObjectMapper();

	/**
	 * @handle error
	 * @param response
	 * @param exception
	 * @param status
	 * @param message
	 * @throws IOException
	 */
	public static void sendError(HttpServletResponse response, Exception exception, int status, String message)
			throws IOException {
		response.setContentType("application/json;charset=UTF-8");
		response.setStatus(status);
		PrintWriter writer = response.getWriter();
		writer.write(mapper.writeValueAsString(exception.getMessage()));
		writer.flush();
		writer.close();
	}

	/**
	 * @handle response
	 * @param response
	 * @param status
	 * @param object
	 * @throws IOException
	 */
	public static void sendResponse(HttpServletResponse response, int status, Object object) throws IOException {
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.write(mapper.writeValueAsString(object));
		response.setStatus(status);
		writer.flush();
		writer.close();
	}

	/**
	 * @comment whether client is hiding behind some proxy
	 * @param request
	 * @return
	 */
	public static String getClientIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_CLUSTER_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_FORWARDED");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_VIA");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("REMOTE_ADDR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
}