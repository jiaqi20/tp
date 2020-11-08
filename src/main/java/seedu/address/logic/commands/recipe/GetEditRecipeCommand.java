package seedu.address.logic.commands.recipe;

import static java.util.Objects.requireNonNull;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.recipe.Recipe;

/**
 * Sets the main window command box to the command of the specified recipe for editing purposes.
 */
public class GetEditRecipeCommand extends Command {
    public static final String COMMAND_WORD = "editR";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Permits edit of the recipe identified by the index number used in the displayed recipe list.\n"
            + "Parameters: " + "INDEX (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " 1";

    public static final String MESSAGE_GET_EDIT_RECIPE_SUCCESS = "Recipe to edit shown: %1$s";

    private static Logger logger = Logger.getLogger("GetEditRecipeLogger");

    private final Index toEdit;

    public GetEditRecipeCommand(Index toEdit) {
        this.toEdit = toEdit;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        logger.log(Level.INFO, "Getting recipe at position " + toEdit.getOneBased());

        List<Recipe> lastShownList = model.getFilteredRecipeList();

        if (toEdit.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_RECIPE_DISPLAYED_INDEX);
        }

        Recipe recipeToEdit = lastShownList.get(toEdit.getZeroBased());
        int recipePositionToEdit = lastShownList.indexOf(recipeToEdit) + 1;
        CommandResult commandResult = new CommandResult(String.format(MESSAGE_GET_EDIT_RECIPE_SUCCESS,
                recipeToEdit.toString()), COMMAND_WORD);
        commandResult.setCommandBox(recipeToEdit.stringify(recipePositionToEdit));
        return commandResult;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof GetEditRecipeCommand // instanceof handles nulls
                && toEdit.equals(((GetEditRecipeCommand) other).toEdit)); // state check
    }

}
