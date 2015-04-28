package snippet;

/**
 * Main class.
 */
final class Snippet {

    /**
     * Prevent any instance member of this class to be created.
     */
    private Snippet() {
        throw new AssertionError("Instantiating utility class...");
    }

    /**
     * Simple first method.
     */
    public static void hello() {
        System.out.println("Hello World.");
    }
}
