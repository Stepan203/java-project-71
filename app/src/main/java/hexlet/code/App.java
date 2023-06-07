package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Option;
import java.io.IOException;
import java.util.concurrent.Callable;
@CommandLine.Command(name = "gendiff", mixinStandardHelpOptions = true, version = "1.0",
        description = "Compares two configuration files and shows a difference.")
public class App implements Callable<Integer> {
    private static final int SUCCESS = 0;

    // interface Spec {
    //@Option(names = "-c", defaultValue = "123", description = "... ${DEFAULT-VALUE} ...")
    //int count();
    //}

    @Option(names = {"-f", "--format"}, defaultValue = "stylish",
            description = "output format [default: ${DEFAULT-VALUE}]", paramLabel = "format")
    private String format;

    @CommandLine.Parameters(index = "0", paramLabel = "<filepath1>", description = "path to first file")
    private static String filepath1;
    @CommandLine.Parameters(index = "1", paramLabel = "<filepath2>", description = "path to second file")
    private static String filepath2;

  //  @CommandLine.Option(names = {"-f", "--format"}, paramLabel = "format",
  //          description = "output format [default: stylish]")
  //  private String format = "stylish";

    public static void main(String[] args) throws IOException {
        int exitCode = new CommandLine(new App()).execute(args);
        // Differ.generate("file1.json", "file2.json");
        System.exit(exitCode);
    }

    @Override
    public Integer call() throws Exception {
        System.out.println(Differ.generate(filepath1, filepath2, format));
      //  System.out.println(Differ.generate(filepath1, filepath2, format));
        //System.out.println("Hello");
        return SUCCESS;
    }
}
