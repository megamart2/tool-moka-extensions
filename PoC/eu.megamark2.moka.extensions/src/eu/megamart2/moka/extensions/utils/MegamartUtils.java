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
	
	public void writeLine(String line) {
		try {
			out.write(line + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
