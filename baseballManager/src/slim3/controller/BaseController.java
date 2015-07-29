package slim3.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public abstract class BaseController extends Controller{

    protected Navigation run() throws Exception {
        Navigation navi = forward("index.jsp");
        //呼び出すメソッドの振り分け
        if(isGet()) {
            navi = get();
        } else if(isPost()) {
            navi = post();
        } else if(isPut()) {
            navi = put();
        } else if(isDelete()) {
            navi = delete();
        }

        return navi;
    }

    protected abstract Navigation get() throws Exception;
    protected abstract Navigation post() throws Exception;
    protected abstract Navigation put() throws Exception;
    protected abstract Navigation delete() throws Exception;

    protected void SetMessage(String msg) throws IOException {
        response.setContentType("text/html; charset=Shift_JIS");
        response.setStatus(HttpServletResponse.SC_OK);
        PrintWriter out = response.getWriter();
        out.println(msg);
        out.close();
    }
}
