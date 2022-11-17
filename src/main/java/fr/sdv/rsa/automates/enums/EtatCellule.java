package fr.sdv.rsa.automates.enums;

public enum EtatCellule {
    active("■"),
    inactive("□"),
    ;

    private final String icon;

    EtatCellule(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }
}
