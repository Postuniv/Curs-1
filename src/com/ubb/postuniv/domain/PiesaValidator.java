package com.ubb.postuniv.domain;

public class PiesaValidator {

    public void validate(Piesa piesa) {
        String errors = "";
        if (piesa.getDenumire().isEmpty()) {
            errors += "Denumirea piesei nu poate fi goala!\n";
        }
        if (piesa.getStoc() < 0) {
            errors += "Stocul trebuie sa fie >= 0!\n";
        }
        if (!piesa.getTip().equals("OEM") &&
            !piesa.getTip().equals("AM") &&
            !piesa.getTip().equals("SH")) {
            errors += "Tipul trebuie sa fie unul dintre OEM, AM, SH!\n";
        }

        if (!errors.isEmpty()) {
            throw new RuntimeException(errors);
        }
    }
}
