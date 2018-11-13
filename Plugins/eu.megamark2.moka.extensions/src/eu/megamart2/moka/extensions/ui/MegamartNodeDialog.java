package eu.megamart2.moka.extensions.ui;

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import eu.megamart2.moka.extensions.constants.MegamartConstants;

public class MegamartNodeDialog extends TitleAreaDialog {
	
	private String timeStamp;
	
	private String component;
	
	private String information;

	public MegamartNodeDialog(Shell parentShell,
			String timeStamp,String component,String information) {
		
		super(parentShell);
		this.timeStamp = timeStamp;
		this.component = component;
		this.information = information;
	}
	
	@Override
	protected Point getInitialSize() { return new Point(600,500); }

	 @Override
	 protected void configureShell(Shell shell) {  // set the title
	 super.configureShell(shell);
	 shell.setText(" Info ");
	 }
	
	@Override
	public void create() {
	super.create();
	setTitle("Moka node information");
	setMessage("Information about a Moka execution node");
	final URL url = FileLocator.find(Platform.getBundle(
			MegamartConstants.MEGAMART2_PLUGIN_ID),new Path("images/MegaMartIcon.png"));
	ImageDescriptor descriptor = ImageDescriptor.createFromURL(url);
	setTitleImage(descriptor.createImage());
	}
	
    @Override
    protected boolean isResizable() { return true; }
    
    @Override
    protected Control createDialogArea(Composite parent) {
    	
    	  // create composite
    	  Composite composite = (Composite)super.createDialogArea(parent);
    	  GridLayoutFactory.fillDefaults().numColumns(2).applyTo(composite);
    	  
    	  Label space = new Label(composite,SWT.NONE);
    	  space.setText("");
    	  
    	  int vIndent = 8;
    	  int hIndent = 6;
    	  
    	  Label timeStampLabel = new Label(composite,SWT.NONE);
    	  timeStampLabel.setText("Timestamp : ");
    	  GridDataFactory.swtDefaults().indent(hIndent,vIndent).applyTo(timeStampLabel);
    	  
    	  Text timeStampText = new Text(composite,SWT.BORDER | SWT.READ_ONLY);
    	  timeStampText.setText(timeStamp);
    	  GridDataFactory.fillDefaults().grab(true, false).applyTo(timeStampText);
    	  
    	  Label componentLabel = new Label(composite,SWT.NONE);
    	  componentLabel.setText("Component : ");
    	  GridDataFactory.swtDefaults().indent(hIndent,vIndent).applyTo(componentLabel);
    	  
    	  Text componentText = new Text(composite,SWT.BORDER | SWT.READ_ONLY);
    	  componentText.setText(component);
    	  GridDataFactory.fillDefaults().grab(true, false).indent(0,vIndent).applyTo(componentText);
    	  
    	  Label infoLabel = new Label(composite,SWT.NONE);
    	  infoLabel.setText("Information : ");
    	  GridDataFactory.swtDefaults().indent(hIndent,vIndent).applyTo(infoLabel);
    	  
    	  Text infoText = new Text(composite,SWT.BORDER | SWT.READ_ONLY);
    	  infoText.setText(information);
    	  GridDataFactory.fillDefaults().indent(0,vIndent).grab(true, true).applyTo(infoText);
    	  
    	  return composite;
    }
}
