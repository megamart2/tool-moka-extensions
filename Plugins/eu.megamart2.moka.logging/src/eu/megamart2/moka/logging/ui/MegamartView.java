package eu.megamart2.moka.logging.ui;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
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

import eu.megamart2.moka.logging.format.MegamartFormatFacade;
import eu.megamart2.moka.logging.format.MegamartInfoFormat;
import eu.megamart2.moka.logging.info.MegamartAbstractInfoObject;

public class MegamartView extends ViewPart{

	public static final String ID = "eu.megamart2.moka.logging.ui.MegamartView";
	
	private Tree tree;
	
	private Composite composite;
	
	private TreeColumn timeColumn,componentColumn,messageColumn;
	
	private final Shell shell;
	
	private Map<TreeItem,MegamartAbstractInfoObject> map;

    @Inject IWorkbench workbench;
    
    public MegamartView() {
    	super();
    	shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
    }
    
    public void addEntry(MegamartAbstractInfoObject entry,String time) {
    	
       if(map == null) 
    	   map = new HashMap<TreeItem,MegamartAbstractInfoObject>();
    	
    	Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
		    	if(tree == null) return;
		    	if(tree.isDisposed()) return;
		    	
		    	TreeItem item = new TreeItem(tree,SWT.NONE);
		    	MegamartFormatFacade format = 
		    			new MegamartFormatFacade("%n : %t");
		    	String component = format.format(entry);
		    	format.setFormat("%v");
		    	MegamartInfoFormat innerFormat = 
		    			new MegamartInfoFormat(MegamartInfoFormat.UML_FORMAT);
		    	format.setInnerFormat(innerFormat);
		    	String message = format.format(entry);
		    	item.setText(new String[] 
		    			{time,component,message});
		    	
		    	map.put(item, entry);
		    	tree.pack();
			}	
    	});
    	Display.getDefault().asyncExec(new Runnable() {
    		@Override
    		public void run() { resize(); }
    	});
    }
    
    private void resize() {
		int width = composite.getSize().x/3;
		if(timeColumn.getWidth() == width) return;
		timeColumn.setWidth(width);
		componentColumn.setWidth(width);
		messageColumn.setWidth(width);
    }

	@Override
	public void createPartControl(Composite parent) {
		
	  map = new HashMap<TreeItem,MegamartAbstractInfoObject>();
	  this.composite = parent;
			
	  GridLayoutFactory.fillDefaults().applyTo(parent);
	  
	  tree = new Tree(parent,SWT.NONE);
	  GridDataFactory.fillDefaults().grab(true,true).applyTo(parent);
	  tree.setLinesVisible(true);
	  tree.setHeaderVisible(true);
	  
	  
	  timeColumn = new TreeColumn(tree,SWT.LEFT);
	  timeColumn.setText("Timestamp");
	  
	  componentColumn = new TreeColumn(tree,SWT.LEFT);
	  componentColumn.setText("Component");
	  
	  messageColumn = new TreeColumn(tree,SWT.LEFT);
	  messageColumn.setText("Information");
	  
      tree.addListener(SWT.MouseDoubleClick,new Listener() {
		@Override
		public void handleEvent(Event event) {

			TreeItem[] items = tree.getSelection();
			if(items == null) return;
			if(items.length < 1) return;
			
			TreeItem item = items[0];
			MegamartAbstractInfoObject info = map.get(item);
		   MegamartNodeDialog dialog = new MegamartNodeDialog(shell,
		    		item.getText(0),item.getText(1),info);
	
		    dialog.open();
		}
      });

	  parent.pack();
	  
	  tree.addControlListener(new ControlListener() {
		@Override
		public void controlMoved(ControlEvent e) {
			System.out.println(" ----- Tree Moved -----");
		}
		@Override
		public void controlResized(ControlEvent e) {}  
	  });
	  
	  parent.addControlListener(new ControlListener() {
		@Override
		public void controlMoved(ControlEvent e) {
			System.out.println(" ----- Parent Moved -----");
		}
		@Override
		public void controlResized(ControlEvent e) {
			System.out.println("\nRESIZE SUMMARY :");
			System.out.println(" -- parent : " + parent.getSize());
			
			int width = composite.getSize().x/3;
			if(timeColumn.getWidth() != width) {
			timeColumn.setWidth(width);
			componentColumn.setWidth(width);
			messageColumn.setWidth(width);
			}
			
			System.out.print(" -- tree : " + tree.getSize());
			System.out.println(" -- columns : " + timeColumn.getWidth());
			//tree.setSize(parent.getSize());
			//parent.pack();
			//parent.reskin(SWT.ALL);
			//tree.redraw();
			//System.out.print(" -- tree resized : " + tree.getSize());
			System.out.println("*****************************\n");
		}	  
	  });
	}
	
	public void clean() { 
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				tree.removeAll();
			}	
		});
		}

	@Override
	public void setFocus() {}
}
