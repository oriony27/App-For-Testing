package com.app.testing.exception.impl;

import com.app.testing.exception.BaseException;

public class ValidationExceptions {

    public static class UserAlreadyExists extends BaseException {
        private static final long serialVersionUID = 3555714415375055302L;

        public UserAlreadyExists(String message) {
            super(message);
        }
    }

    public static class NoSuchUser extends BaseException {
        private static final long serialVersionUID = 3555752415375055302L;

        public NoSuchUser(String message) {
            super(message);
        }
    }
}