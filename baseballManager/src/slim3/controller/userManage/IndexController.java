package slim3.controller.userManage;

import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

import slim3.meta.UserInfoMeta;
import slim3.model.UserInfo;

public class IndexController extends Controller {

    @Override
    public Navigation run() throws Exception {

        UserInfoMeta e = UserInfoMeta.get();
        List<UserInfo> userList = Datastore.query(e).asList();
        requestScope("userList", userList);


        return forward("index.jsp");
    }
}
