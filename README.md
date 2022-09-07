# jackalyze

Syntax analyzer that parses Jack programs according to the Jack grammar, producing an XML file that renders the
program's structure using marked-up text.

**Usage:** The syntax analyzer accepts a single command-line argument, as follows,

`prompt> JackAnalyzer` *source*

where *source* is either a file name of the form *Xxx*`.jack` (the extension is mandatory) or the name of a folder (in
which case there is no extension) containing one or more `.jack` files. The file/folder name may contain a file path. If
no path is specified, the analyzer operates on the current folder. For each *Xxx*`.jack` file, the parser creates an
output file *Xxx*`.xml` and writes the parsed output into it. The output file is created in the same folder as that of
the input. If there is a file by this name in the folder, it will be overwritten.
