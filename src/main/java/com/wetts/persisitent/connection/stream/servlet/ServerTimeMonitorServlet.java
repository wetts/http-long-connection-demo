package com.wetts.persisitent.connection.stream.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServerTimeMonitorServlet extends HttpServlet {

    private static final long serialVersionUID = -3981794330055840248L;

    private String interval = "1";

    public void init(ServletConfig config) throws ServletException {
        this.interval = config.getInitParameter("interval");
        super.init();
    }

    public void destroy() {
        this.interval = null;
        super.destroy();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            java.io.IOException {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(1000 * Integer.valueOf(interval));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss E");
            String date_str = df.format(new Date());

            writerResponse(response, date_str, "showServerTime");// msg是test.jsp中的那个js方法的名称
        }
        return;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            java.io.IOException {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(1000 * Integer.valueOf(interval));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss E");
            String date_str = df.format(new Date());

            writerResponse(response, date_str, "showServerTime");// msg是test.jsp中的那个js方法的名称
        }
        return;
    }

    protected void writerResponse(HttpServletResponse response, String body, String client_method) throws IOException {
        StringBuffer sb = new StringBuffer();
        sb.append(body).append("<br>");
        sb.append("<script type=\"text/javascript\">//<![CDATA[\n");
        sb.append("     parent.").append(client_method).append("(\"").append(body).append("\");\n");
        sb.append("//]]></script>");
        System.out.println(sb.toString());

        response.setContentType("text/html;charset=GBK");
        response.addHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
        response.setHeader("Cache-Control", "pre-check=0,post-check=0");
        response.setDateHeader("Expires", 0);
        response.getWriter().write(sb.toString());
        response.flushBuffer();
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

}
