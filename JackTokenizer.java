import java.io.File;
import java.util.Scanner;

/**
 * This module ignores all comments and white space in the input stream and enables accessing the input one token at a
 * time. Also, it parses and provides the <i>type</i> of each token, as defined by the Jack grammar.
 *
 * @author Maarten Derks
 */
class JackTokenizer {

    private final Scanner sc;
    String line;

    /**
     * Ignores all comments and white space in the input stream, and serializes it into Jack-language tokens.
     * The token types are specified according to the Jack grammar.
     *
     * @param file
     * @throws Exception
     */
    JackTokenizer(File file) throws Exception {
        sc = new Scanner(file);
    }

    /**
     * Are there more lines in the input?
     *
     * @return boolean
     */
    boolean hasMoreLines() {
        return sc.hasNextLine();
    }

    /**
     * Gets the next line from the input, and makes it the current line.
     * This method should be called only if {@link #hasMoreLines() hasMoreLines} is true.
     * Initially there is no current line.
     */
    void advance() {
        do {
            line = sc.nextLine().replaceFirst("//.+", "").trim();
        } while (line.startsWith("/**") || line.startsWith("/*") || line.startsWith("//") || line.equals(""));
    }
}
