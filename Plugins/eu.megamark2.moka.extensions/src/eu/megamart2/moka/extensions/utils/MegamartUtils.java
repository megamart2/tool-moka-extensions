package eu.megamart2.moka.extensions.utils;

import java.io.IOException;

import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IOConsole;
import org.eclipse.ui.console.IOConsoleOutputStream;

public class MegamartUtils {

	private IOConsoleOutputStream out;
	
	public MegamartUtils() { 
		if(out == null) {
			Display.getDefault().asyncExec(new Runnable() {
				@Override
				public void run() {
			IConsole[] consoles = ConsolePlugin.getDefault()
					.getConsoleManager().getConsoles();
			IConsole iout = null; 
			for(IConsole c : consoles)
				if(c.getName().contains("fUML")) {
					iout = c;
					break;
				}
			if(iout instanceof IOConsole) {
				out = ((IOConsole) iout).newOutputStream();
			}
				}
			});
		}
	}
	
	public void write(String line) {
		line = line.replaceAll("  "," ");
		line = line.replaceAll(",,",",");
		line = line.replaceAll(", ,",",");
		line = line.replaceAll(",}","}");
		line = line.replaceAll(", }","}");
		line = line.replaceAll(",]",",]");
		line = line.replaceAll(", ]",",]");

		try {
			out.write(line);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
