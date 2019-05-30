package eu.megamart2.moka.logging.output;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IOConsole;
import org.eclipse.ui.console.IOConsoleOutputStream;

public class MegamartOutput {
	
	private static MegamartOutput INSTANCE;

	private IOConsoleOutputStream outConsole;
	
	public File folder;
	public boolean newExecution;
	
	private EObject modelElement;
	private File file;
	private BufferedWriter writer;
	private String fileName;
	
	private boolean disposed;
	
	private MegamartOutput() { 
        disposed = true;
	}
	
	public static MegamartOutput getInstance() {
		
		if(INSTANCE == null) INSTANCE = new MegamartOutput();
		return INSTANCE;
	}
	
	public void setFolder(File folder) {
		this.folder = folder;
	}
	
	public void reset() {
		newExecution = true;
	}
	
	public void write(String line) {

		if(disposed) init(modelElement);
		if(outConsole == null || writer == null) init(modelElement);
		if(outConsole == null || writer == null) return;
		if(line == null) return; // TODO check nulls
		if(line.replaceAll(" ","").replaceAll("\n","").isEmpty()) return;
		
		try {
			outConsole.write(line + "\n");
			writer.write(line + "\n");
			//writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void init(EObject modelElement) {
	   
		this.modelElement = modelElement;
		
	   // file
	   if(newExecution || file == null) {  
		   
			// look for project folder
		List<Adapter> adapters = modelElement.eAdapters();
		String uri;
		String projectPath = null;
		ResourceSpy spy = new ResourceSpy();
			for(Adapter adapter : adapters) {
                    uri =  spy.getUriFromTracker(adapter);
					if(uri != null) {
						if(uri.contains("\\")) uri = uri.replaceAll("\\","/");
						if(!uri.substring(0, "platform:/".length()).equalsIgnoreCase("platform:/")) {
							if(uri.charAt(0) == '/')
								uri = "platform:" + uri;
							else uri = "platform:/" + uri;
						}
						uri = uri.substring(0,uri.lastIndexOf("/"));
						try {
							projectPath = (FileLocator.resolve(new URL(uri))).toURI().toString();
							if(projectPath.substring(0, projectPath.indexOf('/')).equalsIgnoreCase("file:"))
							projectPath = projectPath.replaceFirst("file:","");
						} catch (URISyntaxException | IOException e) {
							e.printStackTrace();
						}
					    
						break;
					}
			}
			
		   
        if(projectPath != null) {
   
        folder = new File(projectPath + "/simulations/");
        if(!folder.exists()) folder.mkdirs();
        
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy_hh-mm-ss");
		fileName = dateFormat.format(new Date()) + "_Moka_Simulation.txt";
        
        file = new File(projectPath + "/simulations/" + fileName); 
        
        if(!file.exists())
			try {
				file.createNewFile();
			} catch (IOException e) { e.printStackTrace(); }
        }
        newExecution = false;
	   }
		
		// console
		if(outConsole == null) {
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
				outConsole = ((IOConsole) iout).newOutputStream();
			}
				}
			});
		}
		
		// file writer
		try {
			writer = new BufferedWriter(new FileWriter(file));
		} catch (IOException e) {
			e.printStackTrace(); 
		  }
		
		disposed = false;
	}
	
	public void dispose() {
		try {
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		writer = null;
		disposed = true;
	}
	
	public boolean isDisposed() { return disposed; }
	
	private class ResourceSpy extends ResourceImpl {
		String getUriFromTracker(Adapter adapter) {
			if(adapter instanceof ResourceImpl.ModificationTrackingAdapter) {
				ResourceImpl.ModificationTrackingAdapter mod = 
						((ResourceImpl.ModificationTrackingAdapter)adapter);
				try {
					Field field = mod.getClass().getDeclaredField("this$0");
					field.setAccessible(true);
					Object resourceOb = field.get(mod);
					ResourceImpl resource = (ResourceImpl)resourceOb;
					return resource.getURI().devicePath();
					
				} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException
						| SecurityException e) {
					e.printStackTrace();
				}	        
			}
			return null;
		}
          
		}
}
