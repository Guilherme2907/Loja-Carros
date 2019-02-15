package com.guilherme.lojacarros.domain.enums;

/**
 *
 * @author Guilherme
 */
public enum Profile {

    CLIENTE(1, "ROLE_CLIENTE"), ADMIN(2, "ROLE_ADMIN");

    private Integer cod;
    private String description;

    private Profile(Integer cod, String description) {
        this.cod = cod;
        this.description = description;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static Profile toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }
        for (Profile p : Profile.values()) {
            if (p.getCod() == cod) {
                return p;
            }
        }
        return null;
    }
}
