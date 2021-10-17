package seedu.address.logic.parser;

import static seedu.address.logic.parser.ParserUtil.MESSAGE_INVALID_ACTOR;

import seedu.address.logic.commands.ExportCommand;
import seedu.address.logic.commands.buyer.ExportBuyersCommand;
import seedu.address.logic.commands.property.ExportPropertiesCommand;
import seedu.address.logic.parser.PreambleData.Actor;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new ExportCommand object
 */
public class ExportCommandParser {
    private static final int NUMBER_OF_PREAMBLE_ARGUMENTS = 1;

    /**
     * Parses the given {@code String} of arguments in the context of the ExportCommand
     * and returns an ExportCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public ExportCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args);

        PreambleData preambleData = ParserUtil.parsePreamble(argMultimap.getPreamble(), NUMBER_OF_PREAMBLE_ARGUMENTS);
        Actor actor = preambleData.getActor();
        switch (actor) {
        case PROPERTY:
            return new ExportPropertiesCommand();
        case BUYER:
            return new ExportBuyersCommand();
        default:
            throw new ParseException(MESSAGE_INVALID_ACTOR);
        }
    }

}