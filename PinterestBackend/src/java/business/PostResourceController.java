/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import beans.Post;
import dal.PostDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonValue;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Camer
 */
public class PostResourceController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PostDAO dao = new PostDAO();
        List<Post> data = dao.fetchAll();
        JsonArrayBuilder jsonArray = Json.createArrayBuilder();
        data.parallelStream().forEach(post -> jsonArray.add(Json.createObjectBuilder().add("srcset", post.getImgSrc()).add("caption", post.getCaption())));
        JsonArray array = jsonArray.build();
        response.setContentType("application/json");
        response.getOutputStream().print(array.toString());
    }

   
}
