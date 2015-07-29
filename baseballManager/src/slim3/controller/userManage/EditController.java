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

        //�ꗗ��ʂ���̈���
        String userId = asString("selectUserId");
        //��v���郆�[�UID������ꍇ�͏����\�����s��
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
            SetMessage("ID�͕K�{���ڂł��B");
            return null;
        }

        UserInfoMeta e = UserInfoMeta.get();
        int cnt = Datastore.query(e)
                    .filter(e.userId.equal(userId))
                    .count();
        if(cnt > 0) {
            SetMessage("�w�肳�ꂽID�͊��Ɏg�p����Ă��܂��B");
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
        SetMessage("�o�^�����ɐ������܂����B");

        return null;
    }

    @Override
    protected Navigation delete() throws Exception {
        String userId = asString("userId");
        if(Util.isEmpty(userId)) {
            SetMessage("�폜�����Ɏ��s���܂����B");
            return null;
        }

        //�Y�����[�U���擾
        UserInfoMeta e = UserInfoMeta.get();
        UserInfo userInfo = Datastore.query(e)
                .filter(e.userId.equal(userId))
                .asSingle();
        //�Y�����[�U�������ꍇ�̓G���[
        if(userInfo == null) {
            SetMessage("�폜�����Ɏ��s���܂����B");
            return null;
        }

        Datastore.delete(userInfo.getKey());
        SetMessage("�폜�����ɐ������܂����B");

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
            SetMessage("�X�V�����Ɏ��s���܂����B");
            return null;
        }

        //�Y�����[�U���擾
        UserInfoMeta e = UserInfoMeta.get();
        UserInfo userInfo = Datastore.query(e)
                .filter(e.userId.equal(userId))
                .asSingle();
        //�Y�����[�U�������ꍇ�̓G���[
        if(userInfo == null) {
            SetMessage("�X�V�����Ɏ��s���܂����B");
            return null;
        }

        //�p�X���[�h�͓��͂��ꂽ�Ƃ��̂ݍX�V
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
        SetMessage("�X�V�����ɐ������܂����B");

        return null;
    }
}
