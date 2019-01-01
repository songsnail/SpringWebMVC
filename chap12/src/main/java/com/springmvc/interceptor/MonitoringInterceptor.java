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
 // Logger logger = Logger.getLogger(this.getClass()); // Logger 객체 얻기
  protected Log logger = LogFactory.getLog(MonitoringInterceptor.class);


  
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, 
                            Object handler) throws Exception {
     StopWatch stopWatch = new StopWatch(handler.toString());
     stopWatch.start(handler.toString());
     stopWatchLocal.set(stopWatch);
     logger.info("접근한 URL 경로 : " + getURLPath(request));  //로그 메시지를 출력
     logger.info("요청 처리 시작 시각 : " + getCurrentTime());  //로그 메시지를 출력
      return true;
  }
  public void postHandle(HttpServletRequest arg0, HttpServletResponse response, 
                         Object handler, ModelAndView modelAndView) throws Exception {
    logger.info("요청 처리 종료 시각 : " + getCurrentTime());  //로그 메시지를 출력
  }
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, 
                             Object handler, Exception exception) throws Exception {
     StopWatch stopWatch = stopWatchLocal.get();
     stopWatch.stop();
     logger.info("요청 처리 소요 시간 : " + stopWatch.getTotalTimeMillis()+ " ms");  //로그 메시지를 출력
     stopWatchLocal.set(null);
     logger.info("====================================================");  //로그 메시지를 출력
  }
  private String getURLPath(HttpServletRequest request) { //요청 URL과 쿼리문을 얻어오는 메소드
     String currentPath = request.getRequestURI();
     String queryString = request.getQueryString();
     queryString = queryString == null ? "" : "?" + queryString;
     return currentPath+queryString;
  }
  private String getCurrentTime() { //현재 년/월/일 시:분:초를 얻어오는 메소드
    DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(System.currentTimeMillis());
    return formatter.format(calendar.getTime());
  }
}