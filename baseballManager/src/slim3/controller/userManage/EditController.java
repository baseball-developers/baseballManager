package slim3.controller.userManage;

import org.slim3.controller.Navigation;

import slim3.controller.BaseController;

public class EditController extends BaseController {

    @Override
    protected Navigation get() throws Exception {
        return forward("Edit.jsp");
    }

    @Override
    protected Navigation post() throws Exception {
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
