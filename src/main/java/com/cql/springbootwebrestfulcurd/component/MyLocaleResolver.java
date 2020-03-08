package com.cql.springbootwebrestfulcurd.component;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MyLocaleResolver implements LocaleResolver {


    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        Locale locale = Locale.getDefault();
        String params = request.getParameter("l");
        if (!StringUtils.isEmpty(params)) {
            String[] param = params.split("_");
            locale = new Locale(param[0], param[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
