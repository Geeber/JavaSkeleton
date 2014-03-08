// package .;


import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 * Main class for the application.
 *
 * @author Kevin Litwack (kevin@kevinlitwack.com)
 */
public class Main {

    ///// PUBLIC CONSTANTS /////

    ///// PUBLIC STATIC METHODS /////

    /**
     * Executes the application with the given arguments.
     *
     * @param args The arguments.
     */
    public static void main(String[] args) throws Exception {
        // Parse the command line arguments.
        Options options = buildCommandLineOptions();
        CommandLine cmd = parseCommandLine(args, options);

        // If help was requested, just display it and exit.
        if (cmd.hasOption("help")) {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("my-app [OPTION]...", options);
            System.exit(0);
        }

        // Get the command-line argument, if present.
        String name = "world";
        if (cmd.hasOption("name")) {
            name = cmd.getOptionValue("name");
        }

        // Print the greeting.
        System.out.printf("Hello, %s!\n", name);
    }

    ///// PUBLIC METHODS //////

    ///// PROTECTED METHODS /////

    ///// PRIVATE TYPES /////

    ///// PRIVATE CONSTANTS /////

    ///// PRIVATE FIELDS /////

    ///// PRIVATE METHODS /////

    ///// PRIVATE STATIC METHODS /////

    private static Options buildCommandLineOptions() {
        Option help = new Option("h", "help", false, "Print this message");
        Option name = new Option("n", "name", true, "Name to greet");
        name.setArgName("NAME");

        // Add all of the options to an Objects object and return it.
        Options options = new Options();
        options.addOption(help);
        options.addOption(name);
        return options;
    }

    private static CommandLine parseCommandLine(String[] args,
                                                Options options) throws ParseException {
        CommandLineParser parser = new BasicParser();
        return parser.parse(options, args, true);
    }

}
