import java.io.File;
import java.io.FilenameFilter;
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
            CompilationEngine ce = new CompilationEngine(f, new File(f.getAbsolutePath().replaceFirst("[.][^.]+$", ".xml")));
            ce.compileClass();
        }
    }
}
