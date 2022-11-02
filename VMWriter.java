import java.io.File;
import java.io.PrintWriter;

/**
 * This module features a set of simple routines for writing VM commands into the output file.
 *
 * @author Maarten Derks
 */
class VMWriter {

    private final PrintWriter pw;

    /**
     * Creates a new output <code>.vm</code> file / stream, and prepares it for writing.
     *
     * @param out output file
     */
    VMWriter(File out) throws Exception {
        pw = new PrintWriter(out);
    }

    /**
     * Writes a VM <code>push</code> command.
     *
     * @param segment
     * @param index
     */
    void writePush(Segment segment, int index) {

    }

    /**
     * Writes a VM <code>pop</code> command.
     *
     * @param segment
     * @param index
     */
    void writePop(Segment segment, int index) {

    }

    /**
     * Writes a VM arithmetic-logical command.
     *
     * @param command
     */
    void writeArithmetic(Command command) {

    }

    /**
     * Writes a VM <code>label</code> command.
     *
     * @param label
     */
    void writeLabel(String label) {

    }

    /**
     * Writes a VM <code>goto</code> command.
     *
     * @param label
     */
    void writeGoto(String label) {

    }

    /**
     * Writes a VM <code>if-goto</code> command.
     *
     * @param label
     */
    void writeIf(String label) {

    }

    /**
     * Writes a VM <code>call</code> command.
     *
     * @param name
     * @param nVars
     */
    void writeCall(String name, int nVars) {

    }

    /**
     * Writes a VM <code>function</code> command.
     *
     * @param name
     * @param nVars
     */
    void writeFunction(String name, int nVars) {

    }

    /**
     * Writes a VM <code>return</code> command.
     */
    void writeReturn() {

    }

    /**
     * Closes the output file / stream.
     */
    void close() {
        pw.close();
    }
}
