package com.investment.investmentApplication.users.domain;

/**
 * The Class Roles
 *
 * @author Pedro Junho Silveira
 * @since 24/07/2026
 */

public enum Roles {

    ADMIN("admin");

    private final String role;

    Roles(String role){
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
