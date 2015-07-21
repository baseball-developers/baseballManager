package slim3.controller.userManage;

import org.slim3.controller.Navigation;

import slim3.controller.BaseController;

public class EditController extends BaseController {

    @Override
    protected Navigation get() throws Exception {

        //一覧画面からの引数
        String userId =  this.request.getParameter("userId");
        //一致するユーザIDがある場合は初期表示を行う
        if(userId != null) {

        }




        return forward("Edit.jsp");
    }

    @Override
    protected Navigation post() throws Exception {

        String userId =  this.request.getParameter("userId");

        return forward("Edit.jsp");
    }

    @Override
    protected Navigation delete() throws Exception {
        return null;
    }

    @Override
    protected Navigation put() throws Exception {
        return forward("Edit.jsp");
    }
}
