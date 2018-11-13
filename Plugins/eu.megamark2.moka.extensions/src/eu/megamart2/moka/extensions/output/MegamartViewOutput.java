package eu.megamart2.moka.extensions.output;

import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import eu.megamart2.moka.extensions.info.MegamartAbstractInfoObject;
import eu.megamart2.moka.extensions.ui.MegamartView;

public class MegamartViewOutput {
	
	private static MegamartViewOutput INSTANCE;
	
	private MegamartView view;
	
	private MegamartViewOutput() {
		
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				IWorkbench work = PlatformUI.getWorkbench();
				IWorkbenchWindow wi = work.getActiveWorkbenchWindow();
				IWorkbenchPage page = wi.getActivePage();
				try {
					view = (MegamartView) page.showView("eu.megamart2.moka.extensions.view1");
				} catch (PartInitException e) {
		            System.out.println("[ERROR] megamart2 view init failed at MegamartViewOutput constructor");
					e.printStackTrace();
				}  
			}
		});
	}
	
	public static MegamartViewOutput getInstance() {
		if(INSTANCE == null) INSTANCE = new MegamartViewOutput();
		return INSTANCE;
	}
	
	public void releaseEntry(String time,MegamartAbstractInfoObject info) {
		if(view == null) return;
		view.addEntry(info,time);
	}

}
