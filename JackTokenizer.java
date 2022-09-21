import java.io.File;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * This module ignores all comments and white space in the input stream and enables accessing the input one token at a
 * time. Also, it parses and provides the <i>type</i> of each token, as defined by the Jack grammar.
 *
 * @author Maarten Derks
 */
class JackTokenizer {

    private final Scanner sc;
    String token;
    String nextToken = "";

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
     * Are there more tokens in the input?
     *
     * @return boolean
     */
    boolean hasMoreTokens() {
        return sc.hasNext();
    }

    /**
     * Gets the next token from the input, and makes it the current token.
     * This method should be called only if {@link #hasMoreTokens() hasMoreTokens} is true.
     * Initially there is no current token.
     */
    void advance() {
        if (!nextToken.isEmpty()) {
            if (nextToken.startsWith("\"")) {
                String buildToken = nextToken;
                Pattern defDelimiter = sc.delimiter();
                sc.useDelimiter("");
                nextToken = sc.next();
                while (!nextToken.equals("\"")) {
                    buildToken = buildToken.concat(nextToken);
                    nextToken = sc.next();
                }
                buildToken = buildToken.concat(nextToken);
                this.token = buildToken;
                sc.useDelimiter(defDelimiter);
                this.nextToken = sc.next();
            } else if (nextToken.startsWith("(") || nextToken.startsWith(")") || nextToken.startsWith("[") || nextToken.startsWith("]") || nextToken.startsWith(";") || nextToken.startsWith(",") || nextToken.startsWith(".")) {
                this.token = nextToken.substring(0,1);
                this.nextToken = nextToken.substring(1);
            } else {
                if (nextToken.contains("(")) {
                    this.token = nextToken.substring(0, nextToken.indexOf("("));
                    this.nextToken = nextToken.substring(nextToken.indexOf("("));
                } else if (nextToken.contains(")")) {
                    this.token = nextToken.substring(0, nextToken.indexOf(")"));
                    this.nextToken = nextToken.substring(nextToken.indexOf(")"));
                } else if (nextToken.contains("]")) {
                    this.token = nextToken.substring(0, nextToken.indexOf("]"));
                    this.nextToken = nextToken.substring(nextToken.indexOf("]"));
                } else {
                    this.token = nextToken;
                    this.nextToken = "";
                }
            }
        } else {
            String token = sc.next();
            while (token.equals("//") | token.equals("/**")) {
                sc.nextLine();
                token = sc.next();
            }
            if (token.contains(".")) {
                this.token = token.substring(0, token.indexOf("."));
                this.nextToken = token.substring(token.indexOf("."));
            } else if (token.contains("(")) {
                this.token = token.substring(0, token.indexOf("("));
                this.nextToken = token.substring(token.indexOf("("));
            } else if (token.contains(")")) {
                this.token = token.substring(0, token.indexOf(")"));
                this.nextToken = token.substring(token.indexOf(")"));
            } else if (token.contains("[")) {
                this.token = token.substring(0, token.indexOf("["));
                this.nextToken = token.substring(token.indexOf("["));
            } else if (token.contains(";")) {
                this.token = token.substring(0, token.indexOf(";"));
                this.nextToken = token.substring(token.indexOf(";"));
            } else if (token.contains(",")) {
                this.token = token.substring(0, token.indexOf(","));
                this.nextToken = token.substring(token.indexOf(","));
            } else {
                this.token = token;
            }
        }
    }
}
