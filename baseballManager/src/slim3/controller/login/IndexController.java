package slim3.controller.login;

import java.util.List;

import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Key;

import slim3.controller.BaseController;
import slim3.meta.UserInfoMeta;
import slim3.model.UserInfo;
import slim3.util.Const;

public class IndexController extends BaseController {


    @Override
    protected Navigation get() throws Exception {
        return forward("index.jsp");
    }

    @Override
    protected Navigation post() throws Exception {
        String userId =  this.request.getParameter("userId");
        String password =  this.request.getParameter("password");

        //データ全削除
//        List<Key> keys = Datastore.query().asKeyList();
//        Datastore.delete(keys);

        UserInfoMeta e2 = UserInfoMeta.get();
        UserInfo userInfo2 = Datastore.query(e2)
            .filter(e2.userId.equal("saito"))
            .asSingle();

        if(userInfo2 == null) {
            userInfo2 = new UserInfo();
            userInfo2.setKey(userInfo2.getKey());
            userInfo2.setUserId("saito");
            userInfo2.setPassword("takuya");
            Datastore.put(userInfo2);
        }

        UserInfoMeta e = UserInfoMeta.get();
        UserInfo userInfo = Datastore.query(e)
            .filter(e.userId.equal(userId), e.password.equal(password))
            .asSingle();

        //値が存在する場合はログイン完了
        if(userInfo == null) {
            return forward("index.jsp");
        }

        sessionScope(Const.KEY_USERINFO, userInfo);

        return redirect("/top");
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