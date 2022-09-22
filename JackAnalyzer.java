import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * This is the main program that drives the overall syntax analysis process, using the services of a
 * <code>JackTokenizer</code> and a <code>CompilationEngine</code>. For each source <i>Xxx</i><code>.jack</code> file,
 * the analyzer
 * <ol>
 *  <li>creates a <code>JackTokenizer</code> from the <i>Xxx</i><code>.jack</code> input file;</li>
 *  <li>creates an output file named <i>Xxx</i><code>.xml</code>; and</li>
 *  <li>uses the <code>JackTokenizer</code> and the <code>CompilationEngine</code> to parse the input file and write the parsed code to the output file.</li>
 * </ol>
 *
 * @author Maarten Derks
 */
class JackAnalyzer {

    public static void main(String[] args) throws Exception {
        List<File> files = new ArrayList<>();

        File in = new File(args[0]);
        if (in.isFile()) {
            files.add(in.getAbsoluteFile());
        } else {
            FilenameFilter filter = (dir, name) -> name.matches(".*.jack");
            files.addAll(Arrays.asList(Objects.requireNonNull(in.listFiles(filter))));
        }

        for (File f : files) {
            PrintWriter pw = new PrintWriter(new FileWriter(f.getAbsolutePath().replaceFirst("[.][^.]+$", "T.xml")));
            JackTokenizer jt = new JackTokenizer(f);
            while (jt.hasMoreTokens()) {
                jt.advance();
                if (jt.token.isEmpty()) {
                    jt.advance();
                }
                switch (jt.tokenType()) {
                    case KEYWORD:
                        pw.println("<keyword> " + jt.keyWord().toString().toLowerCase() + " </keyword>");
                        break;
                    case SYMBOL:
                        String symbol;
                        switch (jt.symbol()) {
                            case '<': symbol = "&lt;"; break;
                            case '>': symbol = "&gt;"; break;
                            case '\\': symbol = "&quot;"; break;
                            case '&': symbol = "&amp;"; break;
                            default: symbol = String.valueOf(jt.symbol()); break;
                        }
                        pw.println("<symbol> " + symbol + " </symbol>");
                        break;
                    case IDENTIFIER:
                        pw.println("<identifier> " + jt.identifier() + " </identifier>");
                        break;
                    default: pw.println(jt.token);
                }
            }
            pw.close();
        }
    }
}
