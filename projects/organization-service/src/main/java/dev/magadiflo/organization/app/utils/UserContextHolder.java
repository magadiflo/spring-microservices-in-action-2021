package dev.magadiflo.organization.app.utils;

import org.springframework.util.Assert;

public class UserContextHolder {

    private static final ThreadLocal<UserContext> threadLocal = new ThreadLocal<>();

    public static UserContext getContext() {
        UserContext userContext = threadLocal.get();
        if (userContext == null) {
            userContext = createEmptyContext();
            threadLocal.set(userContext);
        }
        return threadLocal.get();
    }

    public static void setUserContext(UserContext userContext) {
        Assert.notNull(userContext, "Sólo se permiten instancias de userContext no nulas");
        threadLocal.set(userContext);
    }

    public static UserContext createEmptyContext() {
        return new UserContext();
    }

}