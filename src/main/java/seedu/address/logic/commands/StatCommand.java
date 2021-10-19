package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import javafx.collections.ObservableList;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.property.Buyer;
import seedu.address.model.property.Property;
import seedu.address.model.stats.HistogramStat;
import seedu.address.model.stats.Stat;

public class StatCommand extends Command {

    public static final String COMMAND_WORD = "stat";
    public static final String PROPERTY_WORD = "properties";
    public static final String BUYER_WORD = "buyers";
    public static final String ALL_WORD = PROPERTY_WORD + " and " + BUYER_WORD;
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Opens a pop up with a price histogram of buyers, properties or both.\n"
            + "Parameters: [(property | buyer)]";

    public static final String MESSAGE_ARGUMENTS = "Displaying prices of %s.";

    private final boolean showBuyer;
    private final boolean showProperty;

    /**
     * Constructor for {@code StatCommand}.
     * @param showBuyer whether histogram should show buyers.
     */
    public StatCommand(boolean showBuyer, boolean showProperty) {
        requireAllNonNull(showBuyer, showProperty);
        this.showBuyer = showBuyer;
        this.showProperty = showProperty;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        ObservableList<Buyer> buyerList = model.getFilteredBuyerList();
        ObservableList<Property> propertyList = model.getFilteredPropertyList();
        String msgArgs = ALL_WORD;
        if (showBuyer && !showProperty) {
            msgArgs = BUYER_WORD;
        } else if (!showBuyer & showProperty) {
            msgArgs = PROPERTY_WORD;
        }
        Stat stat = new HistogramStat(buyerList, propertyList, showBuyer, showProperty, msgArgs);
        return new CommandResult(String.format(MESSAGE_ARGUMENTS, msgArgs), UiAction.STAT, stat);
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof StatCommand)) {
            return false;
        }

        // state check
        StatCommand e = (StatCommand) other;
        return showBuyer == e.showBuyer && showProperty == e.showProperty;
    }

}
