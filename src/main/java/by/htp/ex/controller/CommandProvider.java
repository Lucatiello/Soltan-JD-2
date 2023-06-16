package by.htp.ex.controller;

import by.htp.ex.controller.Command;
import by.htp.ex.controller.CommandName;
import by.htp.ex.controller.impl.*;

import java.util.HashMap;
import java.util.Map;

public final class CommandProvider {
	private final Map<CommandName, Command> commands = new HashMap<>();
	private final static CommandProvider instance = new CommandProvider();

	private CommandProvider (){
		commands.put(CommandName.GO_TO_BASE_PAGE, new GoToBasePage());
		commands.put(CommandName.GO_TO_REGISTRATION_PAGE, new GoToRegistrationPageCommand());
		commands.put(CommandName.DO_SIGN_IN, new DoSIgnIn());
		commands.put(CommandName.DO_SIGN_OUT, new DoSignOut());
		commands.put(CommandName.GO_TO_NEWS_LIST, new GoToNewsList());
		commands.put(CommandName.GO_TO_VIEW_NEWS, new GoToViewNews());
		commands.put(CommandName.DO_REGISTRATION, new DoRegistration());
		commands.put(CommandName.CHANGE_LOCALE, new ChangeLocale());
	}

	public Command getCommand(String command) {
		CommandName commandName = CommandName.valueOf(command.toUpperCase());
		return commands.get(commandName);
	}

	public static CommandProvider getInstance() {
		return instance;
	}
}
