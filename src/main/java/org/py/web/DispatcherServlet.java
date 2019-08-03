package org.py.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "dispatcherSetvlet", urlPatterns = {"/"})
public class DispatcherServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(DispatcherServlet.class);
    @Override
    public void init(ServletConfig config) throws ServletException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        service(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        service(req, resp);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(InputStream ins = getClass().getClassLoader().getResourceAsStream("templates/index/index.html");
            InputStreamReader reader = new InputStreamReader(ins, StandardCharsets.UTF_8);
            PrintWriter out = resp.getWriter()) {
            CharBuffer buffer = CharBuffer.allocate(128);
            List<String> lines = new ArrayList<>();
            while(reader.read(buffer) != -1) {
                buffer.flip();
                lines.add(buffer.toString());
            }
            String html = lines.stream().reduce("", String::concat);
            out.print(html);
        } catch(IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
