package pl.com.sages.hr.command;

import pl.com.sages.hr.model.Observable;
import pl.com.sages.hr.model.Observer;

/**
 * Created by aliberadzki on 24.09.16.
 */
public class ObservableCommandDecorator implements Command, Observable{

    private Command myCommand;
    public ObservableCommandDecorator(Command myCommand) {
        this.myCommand = myCommand;
    }

    @Override
    public String getCommandName() {
        return myCommand.getCommandName();
    }

    @Override
    public String getShortHelp() {
        return myCommand.getShortHelp();
    }

    @Override
    public String getLongHelp() {
        return myCommand.getLongHelp();
    }

    @Override
    public void doAction(String[] args) {
        myCommand.doAction(args);
    }

    @Override
    public void addObserver(Observer observer) {
        //TODO pomieszane Obserwator i dekorator...
    }

    @Override
    public void removeObserver(Observer obsever) {

    }

    @Override
    public void notifyObservers() {

    }
}
