package slim3.controller.userManage;

import java.util.Map;

import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Email;

import slim3.controller.BaseController;
import slim3.meta.UserInfoMeta;
import slim3.model.UserInfo;

public class EditController extends BaseController {

    @Override
    protected Navigation get() throws Exception {

        //一覧画面からの引数
        String userId =  this.request.getParameter("userId");
        //一致するユーザIDがある場合は初期表示を行う
        if(userId != null) {
            UserInfoMeta e = UserInfoMeta.get();
            UserInfo userInfo = Datastore.query(e)
                .filter(e.userId.equal(userId))
                .asSingle();
            if(userInfo != null) {
                requestScope("userInfo", userInfo);
                return forward("Edit.jsp");
            }
        }

        return forward("Regist.jsp");
    }

    @Override
    protected Navigation post() throws Exception {

        Map paramMap = this.request.getParameterMap();

        UserInfo userInfo = new UserInfo();
        userInfo.setKey(userInfo.getKey());
        userInfo.setUserId(paramMap.get("userId").toString());
        userInfo.setPassword(paramMap.get("password").toString());
        userInfo.setName(paramMap.get("name").toString());
        userInfo.setEmail((Email)paramMap.get("email"));
        userInfo.setAdmin((boolean)paramMap.get("isAdmin"));
        Datastore.put(userInfo);

        return forward("Edit.jsp");
    }

    @Override
    protected Navigation delete() throws Exception {
        return null;
    }

    @Override
    protected Navigation put() throws Exception {
//        this.request.getParameter("userId");
//        this.request.getParameter("password");
//        this.request.getParameter("name");
//        this.request.getParameter("email");
        Map paramMap = this.request.getParameterMap();

        if(!paramMap.containsKey("userId")) {
            return null;
        }


        String userId = paramMap.get("userId").toString();

        UserInfoMeta e = UserInfoMeta.get();
        UserInfo userInfo = Datastore.query(e)
            .filter(e.userId.equal(userId))
            .asSingle();

        userInfo.setPassword(paramMap.get("password").toString());
        userInfo.setName(paramMap.get("name").toString());
        userInfo.setEmail((Email)paramMap.get("email"));
        userInfo.setAdmin((boolean)paramMap.get("isAdmin"));
        Datastore.put(userInfo);


        return forward("Edit.jsp");
    }
}
