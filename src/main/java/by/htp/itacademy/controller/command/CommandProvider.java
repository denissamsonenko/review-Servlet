package by.htp.itacademy.controller.command;

import java.util.HashMap;
import java.util.Map;

import by.htp.itacademy.controller.command.impl.ChangeLocale;
import by.htp.itacademy.controller.command.impl.CreateNews;
import by.htp.itacademy.controller.command.impl.DeleteNews;
import by.htp.itacademy.controller.command.impl.FindByIdNews;
import by.htp.itacademy.controller.command.impl.FindForUpdate;
import by.htp.itacademy.controller.command.impl.UpdateNews;
import by.htp.itacademy.controller.command.impl.SaveNews;
import by.htp.itacademy.controller.command.impl.ShowAllNews;

public class CommandProvider {

	private Map <ParameterName, Command> commands = new HashMap<ParameterName, Command>();

	public CommandProvider() {
		commands.put(ParameterName.SAVE_NEWS, new SaveNews());
		commands.put(ParameterName.CREATE_NEWS, new CreateNews());
		commands.put(ParameterName.SHOW_ALL_NEWS, new ShowAllNews());
		commands.put(ParameterName.UPDATE_NEWS, new UpdateNews());
		commands.put(ParameterName.FIND_BY_ID, new FindByIdNews());
		commands.put(ParameterName.DELETE_NEWS, new DeleteNews());
		commands.put(ParameterName.FIND_FOR_UPDATE, new FindForUpdate());
		commands.put(ParameterName.CHANGE_LOCALE, new ChangeLocale());
	}
	
	public Command getCommand(String commandName) {
		Command command;
		ParameterName valueName;
		
		commandName = commandName.toUpperCase();
		valueName = ParameterName.valueOf(commandName);
		
		command = commands.get(valueName);
		
		return command;
	}
}
