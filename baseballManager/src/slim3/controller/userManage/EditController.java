package slim3.controller.userManage;

import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

import slim3.controller.BaseController;
import slim3.meta.UserInfoMeta;
import slim3.model.UserInfo;
import slim3.util.Util;

import com.google.appengine.api.datastore.Email;

public class EditController extends BaseController {

    @Override
    protected Navigation get() throws Exception {

        //一覧画面からの引数
        String userId = asString("selectUserId");
        //一致するユーザIDがある場合は初期表示を行う
        if(Util.isNotEmpty(userId)) {
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
        String userId = asString("userId");
        String password = asString("password");
        String name = asString("name");
        String email = asString("email");
        String isAdmin = asString("isAdmin");

        if(Util.isEmpty(userId)) {
            SetMessage("IDは必須項目です。");
            return null;
        }

        UserInfoMeta e = UserInfoMeta.get();
        int cnt = Datastore.query(e)
                    .filter(e.userId.equal(userId))
                    .count();
        if(cnt > 0) {
            SetMessage("指定されたIDは既に使用されています。");
            return null;
        }

        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userId);
        userInfo.setPassword(password);
        userInfo.setName(name);
        userInfo.setEmail(new Email(email));
        if(Util.isNotEmpty(isAdmin) && isAdmin.equals("1")) {
            userInfo.setAdmin(true);
        } else {
            userInfo.setAdmin(false);
        }
        Datastore.put(userInfo);
        SetMessage("登録処理に成功しました。");

        return null;
    }

    @Override
    protected Navigation delete() throws Exception {
        String userId = asString("userId");
        if(Util.isEmpty(userId)) {
            SetMessage("削除処理に失敗しました。");
            return null;
        }

        //該当ユーザを取得
        UserInfoMeta e = UserInfoMeta.get();
        UserInfo userInfo = Datastore.query(e)
                .filter(e.userId.equal(userId))
                .asSingle();
        //該当ユーザが無い場合はエラー
        if(userInfo == null) {
            SetMessage("削除処理に失敗しました。");
            return null;
        }

        Datastore.delete(userInfo.getKey());
        SetMessage("削除処理に成功しました。");

        return null;
    }

    @Override
    protected Navigation put() throws Exception {
        String userId = asString("userId");
        String password = asString("password");
        String name = asString("name");
        String email = asString("email");
        String isAdmin = asString("isAdmin");

        if(Util.isEmpty(userId)) {
            SetMessage("更新処理に失敗しました。");
            return null;
        }

        //該当ユーザを取得
        UserInfoMeta e = UserInfoMeta.get();
        UserInfo userInfo = Datastore.query(e)
                .filter(e.userId.equal(userId))
                .asSingle();
        //該当ユーザが無い場合はエラー
        if(userInfo == null) {
            SetMessage("更新処理に失敗しました。");
            return null;
        }

        //パスワードは入力されたときのみ更新
        if(!Util.isEmpty(password)) {
            userInfo.setPassword(password);
        }
        userInfo.setName(name);
        userInfo.setEmail(new Email(email));
        if(Util.isNotEmpty(isAdmin) && isAdmin.equals("1")) {
            userInfo.setAdmin(true);
        } else {
            userInfo.setAdmin(false);
        }
        Datastore.put(userInfo);
        SetMessage("更新処理に成功しました。");

        return null;
    }
}
