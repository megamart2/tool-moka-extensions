package eu.megamart2.moka.extensions.ui;

import javax.inject.Inject;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import eu.megamart2.moka.extensions.format.MegamartFormatFacade;
import eu.megamart2.moka.extensions.info.MegamartAbstractInfoObject;

public class MegamartView extends ViewPart{

	public static final String ID = "eu.megamart2.moka.extensions.ui.MegamartView";
	
	private Tree tree;
	
	private final Shell shell;

    @Inject IWorkbench workbench;
    
    public MegamartView() {
    	super();
    	shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
    }
    
    public void addEntry(MegamartAbstractInfoObject entry,String time) {
    	
    	Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
		    	if(tree == null) return;
		    	if(tree.isDisposed()) return;
		    	
		    	TreeItem item = new TreeItem(tree,SWT.NONE);
		    	MegamartFormatFacade format = 
		    			new MegamartFormatFacade("%n:%t");
		    	String component = format.format(entry);
		    	format.setFormat("%v");
		    	String message = format.format(entry);
		    	item.setText(new String[] 
		    			{time,component,message});
		    	
		    	tree.pack();
			}	
    	});
    }

	@Override
	public void createPartControl(Composite parent) {
			
	 // GridLayoutFactory.fillDefaults().numColumns(1).applyTo(parent);
		parent.setLayout(new FillLayout());
	  
	  tree = new Tree(parent,SWT.NONE);
	  tree.setLinesVisible(true);
	  tree.setHeaderVisible(true);
	  
	  TreeColumn timeColumn = new TreeColumn(tree,SWT.LEFT);
	  timeColumn.setText("Timestamp");
	  timeColumn.setWidth(250);
	  
	  TreeColumn componentColumn = new TreeColumn(tree,SWT.LEFT);
	  componentColumn.setText("Component");
	  componentColumn.setWidth(250);
	  
	  TreeColumn messageColumn = new TreeColumn(tree,SWT.LEFT);
	  messageColumn.setText("Information");
	  messageColumn.setWidth(250);
	  
      //TreeViewer viw = new TreeViewer(tree,SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
      tree.addListener(SWT.MouseDoubleClick,new Listener() {
		@Override
		public void handleEvent(Event event) {

			TreeItem[] items = tree.getSelection();
			if(items == null) return;
			if(items.length < 1) return;
			
			TreeItem item = items[0];
		    MegamartNodeDialog dialog = new MegamartNodeDialog(shell,
		    		item.getText(0),item.getText(1),item.getText(2));
	
		    dialog.open();
		}
      });
      
	  parent.pack();
	}

	@Override
	public void setFocus() {}
}
