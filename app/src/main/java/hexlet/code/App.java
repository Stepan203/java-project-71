package hexlet.code;

import picocli.CommandLine;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "gendiff", mixinStandardHelpOptions = true, version = "1.0",
        description = "Compares two configuration files and shows a difference.")
public class App implements Callable<Integer> {

     @CommandLine.Parameters(index = "0", paramLabel = "<filepath1>", description = "path to first file")
    File filepath1;
    @CommandLine.Parameters(index = "1", paramLabel = "<filepath2>", description = "path to second file")
    File filepath2;

    @CommandLine.Option(names = {"-f", "--format"}, paramLabel = "format",
            description = "output format [default: stylish]")
    private String format = "stylish";

    public static void main(String[] args) throws IOException {
        int exitCode = new CommandLine(new App()).execute(args);
        Differ.generate("file1.json");
        System.exit(exitCode);
    }

    @Override
    public Integer call() throws Exception {
        //String result = Differ.generate(filepath1, filepath2);
     //   System.out.println(result);
        System.out.println("Hello");
        return 0;
    }
}
