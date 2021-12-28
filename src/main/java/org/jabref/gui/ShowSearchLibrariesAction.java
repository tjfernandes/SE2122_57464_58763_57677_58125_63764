package org.jabref.gui;

import org.jabref.gui.actions.SimpleCommand;
import org.jabref.preferences.PreferencesService;

import static org.jabref.gui.actions.ActionHelper.needsDatabase;

public class ShowSearchLibrariesAction extends SimpleCommand {

    private final JabRefFrame jabRefFrame;
    private final DialogService dialogService;
    private final PreferencesService preferences;

    public ShowSearchLibrariesAction(JabRefFrame jabRefFrame, DialogService dialogService, PreferencesService preferences, StateManager stateManager) {
        this.jabRefFrame = jabRefFrame;
        this.dialogService = dialogService;
        this.preferences = preferences;

        this.executable.bind(needsDatabase(stateManager));

    }

    @Override
    public void execute() {
        dialogService.showCustomDialogAndWait(new SearchLibraries(dialogService));

    }
}
