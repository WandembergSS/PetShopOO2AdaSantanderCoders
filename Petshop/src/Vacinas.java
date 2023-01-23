public enum Vacinas {
    ANTIRABICA,
    GIARDIA,
    OUTRA;

    public static Vacinas getVacinaPorString(String vacina) {
        for (Vacinas v : Vacinas.values()) {
            if (v.name().equalsIgnoreCase(vacina)) {
                return v;
            }
        }
        return null;
    }
}


