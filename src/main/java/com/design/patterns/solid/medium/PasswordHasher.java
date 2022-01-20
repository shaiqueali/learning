package com.design.patterns.solid.medium;


/**
 * 1. Single Responsibility
 * Each class should have only one sole purpose, and not be filled with excessive functionality.
 * <p>
 * This class is implemented for hashing passwords, as the name implies. It should not be its responsibility to save them to the database.
 * Each class should have a single responsibility to fulfill.
 */
public class PasswordHasher {

    public String hashAndSavePassword(String password) {
        hashPassword(null, null);
        savePassword();
        return null;
    }

    /**
     * 2. Open-Closed Principle
     * Classes should be open for extension, closed for modification.
     */
    public String hashPassword(String password, String hashingType) {
        /**
         * If we implemented this way, we would break the O in SOLID so bad. Every time a new algorithm is implemented,
         * we need to modify the existing class, and it looks ugly.
         */
        if ("BASE64".equals(hashingType)) {
            return "hashed with Base64";
        } else if ("MD5".equals(hashingType)) {
            return "hashed with MD5";
        }
        return null;
    }

    public void savePassword() {
        //save to the db
    }
}
