package com.syaaa.springboot.compent;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Locale;

/**
 * @ClassName MyLocalResolver
 * @Description TODO
 * @Author APPO
 * @Date 11:28   2018-9-18
 * @Version 1.0
 **/
public class MyLocalResolver implements LocaleResolver{

    private static final String I18N_LANGUAGE = "i18n_language";
    private static final String I18N_LANGUAGE_SESSION = "i18n_language_session";
    /**
     * 在连接上设置区域信息的方法
     * @param httpServletRequest
     * @return
     */
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        Locale locale = Locale.getDefault();
        String parameter = httpServletRequest.getParameter("language");
        if (!StringUtils.isEmpty(parameter)) {
            String[] split = parameter.split("_");
            locale = new Locale(split[0],split[1]);

            //将国际化语言保存到session
            HttpSession session = httpServletRequest.getSession();
            session.setAttribute(I18N_LANGUAGE_SESSION, locale);
        }else{
            //如果没有带国际化参数，则判断session有没有保存，有保存，则使用保存的，也就是之前设置的，避免之后的请求不带国际化参数造成语言显示不对
            HttpSession session = httpServletRequest.getSession();
            Locale localeInSession = (Locale) session.getAttribute(I18N_LANGUAGE_SESSION);
            if(localeInSession != null) {
                locale = localeInSession;
            }
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
