# JackCompiler

The Jack compiler is a program that gets a Jack program as input and generates executable VM code as output.

**Usage:** The compiler accepts a single command-line argument, as follows,

`prompt> JackCompiler` *source*

where *source* is either a file name of the form *Xxx*`.jack` (the extension is mandatory) or the name of a folder (in
which case there is no extension) containing one or more `.jack` files. The file/folder name may contain a file path. If
no path is specified, the compiler operates on the current folder. For each *Xxx*`.jack` file, the parser creates an
output file *Xxx*`.vm` and writes the VM commands into it. The output file is created in the same folder as the input
file. If there is a file by this name in the folder, it will be overwritten.
