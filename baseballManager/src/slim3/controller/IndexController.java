package slim3.controller;

import org.slim3.controller.Navigation;

public class IndexController extends BaseController {

    @Override
    protected Navigation get() throws Exception {
        return redirect("/login");
    }

    @Override
    protected Navigation post() throws Exception {
        return null;
    }

    @Override
    protected Navigation delete() throws Exception {
        return null;
    }

    @Override
    protected Navigation put() throws Exception {
        return null;
    }
}
