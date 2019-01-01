package com.springmvc.interceptor;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MonitoringInterceptor implements HandlerInterceptor {

  ThreadLocal<StopWatch> stopWatchLocal = new ThreadLocal<StopWatch>();
 // Logger logger = Logger.getLogger(this.getClass()); // Logger ��ü ���
  protected Log logger = LogFactory.getLog(MonitoringInterceptor.class);


  
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, 
                            Object handler) throws Exception {
     StopWatch stopWatch = new StopWatch(handler.toString());
     stopWatch.start(handler.toString());
     stopWatchLocal.set(stopWatch);
     logger.info("������ URL ��� : " + getURLPath(request));  //�α� �޽����� ���
     logger.info("��û ó�� ���� �ð� : " + getCurrentTime());  //�α� �޽����� ���
      return true;
  }
  public void postHandle(HttpServletRequest arg0, HttpServletResponse response, 
                         Object handler, ModelAndView modelAndView) throws Exception {
    logger.info("��û ó�� ���� �ð� : " + getCurrentTime());  //�α� �޽����� ���
  }
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, 
                             Object handler, Exception exception) throws Exception {
     StopWatch stopWatch = stopWatchLocal.get();
     stopWatch.stop();
     logger.info("��û ó�� �ҿ� �ð� : " + stopWatch.getTotalTimeMillis()+ " ms");  //�α� �޽����� ���
     stopWatchLocal.set(null);
     logger.info("====================================================");  //�α� �޽����� ���
  }
  private String getURLPath(HttpServletRequest request) { //��û URL�� �������� ������ �޼ҵ�
     String currentPath = request.getRequestURI();
     String queryString = request.getQueryString();
     queryString = queryString == null ? "" : "?" + queryString;
     return currentPath+queryString;
  }
  private String getCurrentTime() { //���� ��/��/�� ��:��:�ʸ� ������ �޼ҵ�
    DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(System.currentTimeMillis());
    return formatter.format(calendar.getTime());
  }
}