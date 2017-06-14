package reservation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/jsontest")
public class JsonTestServlet extends HttpServlet {
	    public void doGet(HttpServletRequest req, HttpServletResponse res)
	                throws ServletException, IOException {

	        //res.setContentType("application/json; charset=utf-8");
	        //「jsonp1372612532406」みたいな文字が格納される
	        String callback = req.getParameter("callback");
	        System.out.println(callback);
	        res.setContentType("text/javascript; charset=utf-8");
	        res.setHeader("Access-Control-Allow-Origin", "*");
	        PrintWriter out = res.getWriter();

	        Gson gson = new Gson();
	        Person person = new Person();
	        person.setAge(34);
	        person.setName("早玖也");
	        person.setJob("保育園児");
	        //このcallbackを付けないと、JavaScript側でデータを受け取れないみたい
	        out.println( callback + "(" + gson.toJson(person) + ")");
	        //out.println("(" + gson.toJson(person) + ")");
	    }
}
