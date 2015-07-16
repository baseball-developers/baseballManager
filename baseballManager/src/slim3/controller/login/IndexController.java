package slim3.controller.login;

import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Key;

import slim3.Util.Const;
import slim3.meta.UserInfoMeta;
import slim3.model.UserInfo;

public class IndexController extends Controller {

    @Override
    public Navigation run() throws Exception {

        String userId =  this.request.getParameter("userId");
        String password =  this.request.getParameter("password");

        //�f�[�^�S�폜
//        List<Key> keys = Datastore.query().asKeyList();
//        Datastore.delete(keys);

        UserInfoMeta e2 = UserInfoMeta.get();
        UserInfo userInfo2 = Datastore.query(e2)
            .filter(e2.userId.equal("saito"), e2.password.equal("takuya"))
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

        //�l�����݂���ꍇ�̓��O�C������
        if(userInfo == null) {
            return forward("index.jsp");
        }

        sessionScope(Const.KEY_USERINFO, userInfo);

        return redirect("/menu");
    }
}