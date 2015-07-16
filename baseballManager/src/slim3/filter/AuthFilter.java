package slim3.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import slim3.util.Const;

public class AuthFilter implements Filter {


    private String[] excludes;

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain chain) throws IOException, ServletException {

        //�Z�b�V�����`�F�b�N
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)res;
        HttpSession session = request.getSession();
        //���F��

        String thisURL = request.getRequestURI();
        if (request.getUserPrincipal() == null) {
            if (!isExcludePath(thisURL)) {
              //�F�؃`�F�b�N
              if(session.getAttribute(Const.KEY_USERINFO) == null) {
                  response.sendRedirect("/login");
                  return;
              }
          }
      }
      chain.doFilter(req, res);
    }
    /**
     * ���N�G�X�g���ꂽURL�����O�Ώۂ����f����B
     * ���O�Ώۂ̏ꍇtrue��Ԃ�
     * @param thisURL
     * @return
     */
    private boolean isExcludePath(String thisURL) {
        String[] excludes = this.excludes;
        for (String path : excludes) {
            // ���O�Ώۃp�X�̍Ōオ�u*�v�̏ꍇ�AindexOf�Ŋ܂܂�邩�m�F
            if (path.indexOf("*") == path.length() - 1) {
                if (thisURL.indexOf(path.substring(0, path.length() - 2)) >= 0) {
                    return true;
                }
            } else {
                // ��L�ȊO�́A���S��v
                if (thisURL.equals(path)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        String exclude = config.getInitParameter("exclude");
        if (exclude == null) return;
        this.excludes = exclude.split(",");
    }
}
