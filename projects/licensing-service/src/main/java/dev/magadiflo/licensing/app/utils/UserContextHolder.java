package dev.magadiflo.licensing.app.utils;

import org.springframework.util.Assert;

public class UserContextHolder {

    private static final ThreadLocal<UserContext> threadLocal = new ThreadLocal<>();

    public static final UserContext getContext() {
        UserContext userContext = threadLocal.get();
        if (userContext == null) {
            userContext = createEmptyContext();
            threadLocal.set(userContext);
        }
        return threadLocal.get();
    }

    public static final void setUserContext(UserContext userContext) {
        Assert.notNull(userContext, "Sólo se permiten instancias de userContext no nulas");
        threadLocal.set(userContext);
    }

    public static final UserContext createEmptyContext() {
        return new UserContext();
    }

}
