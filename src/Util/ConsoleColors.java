package Util;

/*
 * Utilitário para cores no terminal
 * Usa ANSI Escape Codes
 */
public class ConsoleColors {

    // Reset (voltar ao padrão)
    public static final String RESET = "\u001B[0m";

    // Cores principais
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";

    // Negrito (opcional)
    public static final String BOLD = "\u001B[1m";
}