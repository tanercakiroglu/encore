package configuration;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author taner �ak�ro�lu
 * @comment filter and log every request
 *
 */

public class RequestFilterLogging implements Filter {

	private AtomicLong atomicId = new AtomicLong(1);
	private static final String REQUEST_PREFIX = "Request: ";
	private final static Logger logger = LoggerFactory.getLogger(RequestFilterLogging.class);

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		long requestId = atomicId.incrementAndGet();
		MyRequestWrapper myRequestWrapper = new MyRequestWrapper(requestId,(HttpServletRequest) request);

		try {
			chain.doFilter(myRequestWrapper, response);
		} finally {
			logRequest(myRequestWrapper);
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 * @author taner cakiroglu
	 * @comment wrap the request to be able read request more than one time 
	 */
	public class MyRequestWrapper extends HttpServletRequestWrapper {
		private final String body;
		private long id;
		
		public MyRequestWrapper(Long requestId,HttpServletRequest request) throws IOException {
			super(request);
			this.id = requestId;
			StringBuilder stringBuilder = new StringBuilder();
			BufferedReader bufferedReader = null;
			try {
				InputStream inputStream = request.getInputStream();
				if (inputStream != null) {
					bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
					char[] charBuffer = new char[128];
					int bytesRead = -1;
					while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
						stringBuilder.append(charBuffer, 0, bytesRead);
					}
				} else {
					stringBuilder.append("");
				}
			} catch (IOException ex) {
				throw ex;
			} finally {
				if (bufferedReader != null) {
					try {
						bufferedReader.close();
					} catch (IOException ex) {
						throw ex;
					}
				}
			}
			body = stringBuilder.toString();
		}

		@Override
		public ServletInputStream getInputStream() throws IOException {
			final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(body.getBytes());
			return  new ServletInputStream() {
				public int read() throws IOException {
					return byteArrayInputStream.read();
				}
			};
		}

		@Override
		public BufferedReader getReader() throws IOException {
			return new BufferedReader(new InputStreamReader(this.getInputStream()));
		}

		public String getBody() {
			return this.body;
		}
		
		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}
	}
    /**
     * log the request
     * @param request
     */
	private void logRequest(final MyRequestWrapper request) {
		StringBuilder msg = new StringBuilder();
		String client = SecurityUtil.getClientIpAddr(request);
		String body = request.getBody();
		int clientPort = request.getRemotePort();
		msg.append(REQUEST_PREFIX);
		if (request instanceof MyRequestWrapper) {
			msg.append("request id=").append(( request).getId()).append("; ");
		}
		if (body != null) {
			msg.append("body=").append(body).append("; ");
		}
		HttpSession session = request.getSession(false);
		if (session != null) {
			msg.append("session id=").append(session.getId()).append("; ");
		}
		if (request.getMethod() != null) {
			msg.append("method=").append(request.getMethod()).append("; ");
		}
		if (client != null) {
			msg.append("remote=").append(client).append("; ");
		}

		msg.append("remote port=").append(clientPort).append("; ");

		if (request.getContentType() != null) {
			msg.append("content type=").append(request.getContentType()).append("; ");
		}
		msg.append("uri=").append(request.getRequestURI());
		if (request.getQueryString() != null) {
			msg.append('?').append(request.getQueryString());
		}
		if(logger.isDebugEnabled())
			logger.debug(msg.toString());
	}

	
}
