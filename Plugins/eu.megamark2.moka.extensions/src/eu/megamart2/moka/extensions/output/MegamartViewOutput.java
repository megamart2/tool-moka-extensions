package eu.megamart2.moka.extensions.output;

import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import eu.megamart2.moka.extensions.ui.MegamartView;
import eu.megamart2.moka.extensions.ui.MokaEntry;

public class MegamartViewOutput {
	
	private MegamartView view;
	
	public MegamartViewOutput() {
		
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
	
	public void releaseEntry(MokaEntry entry) {
		if(view == null) return;
		view.addEntry(entry);
	}

}
