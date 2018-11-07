package eu.megamart2.moka.extensions.ui;

import javax.inject.Inject;

import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.part.ViewPart;

public class MegamartView extends ViewPart{

	public static final String ID = "eu.megamart2.moka.extensions.ui.MegamartView";
	
	private Tree tree;

    @Inject IWorkbench workbench;
    
    public void addEntry(MokaEntry entry) {
    	
    	Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
		    	if(tree == null) return;
		    	if(tree.isDisposed()) return;
		    	
		    	TreeItem item = new TreeItem(tree,SWT.NONE);
		    	item.setText(new String[] 
		    			{entry.getTime(),entry.getComponent(),entry.getmessage()});
		    	
		    	tree.pack();
			}	
    	});
    }

	@Override
	public void createPartControl(Composite parent) {
			
	  GridLayoutFactory.fillDefaults().numColumns(1).applyTo(parent);
	  
	  tree = new Tree(parent,SWT.NONE);
	  tree.setLinesVisible(true);
	  tree.setHeaderVisible(true);
	  
	  TreeColumn timeColumn = new TreeColumn(tree,SWT.LEFT);
	  timeColumn.setText("Time");
	  timeColumn.setWidth(250);
	  
	  TreeColumn componentColumn = new TreeColumn(tree,SWT.LEFT);
	  componentColumn.setText("Component");
	  componentColumn.setWidth(250);
	  
	  TreeColumn messageColumn = new TreeColumn(tree,SWT.LEFT);
	  messageColumn.setText("Information");
	  messageColumn.setWidth(250);
	  
      TreeViewer viw = new TreeViewer(tree,SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
      tree.addListener(SWT.MouseDoubleClick,new Listener() {
		@Override
		public void handleEvent(Event event) {
			// TODO open dialog with information
			System.out.println("DoubleClick " + tree.getSelection().length); 
		}
      });
      
	  parent.pack();
	}

	@Override
	public void setFocus() {}
}
