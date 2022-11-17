package fr.sdv.rsa.automates.enums;

public enum EtatCellule {
    active("■"),
    inactive("□"),
    ;

    private String icon ;

    public String getIcon() {
        return icon;
    }

    EtatCellule(String icon) {
        this.icon = icon;
    }
}
