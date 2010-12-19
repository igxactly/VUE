package tufts.vue.ibisimage;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

import tufts.vue.*;
import tufts.vue.ibisicon.*;

public class IBISIssueImage extends IBISImage {
	
	private static BufferedImage mImage = VueResources.getBufferedImage("IBISNodeTool.issue.image");
	private static File mImageFile = createImageFile(VueResources.getString("IBISNodeTool.issue.image.filename"), mImage);

	private static Resource mImageResource = new LWMap("dummy map").getResourceFactory().get(mImageFile);
	
	private IBISImageIcon mIcon = null;
	
	// HO 17/12/2010 BEGIN ***********
	private String saveImageFile = "";
	// HO 17/12/2010 END *************
	
	public IBISIssueImage() {
		super(mImageResource);
		// HO 19/12/2010 BEGIN ************
		mImageResource.setProperty(Resource.IMAGE_WIDTH, DEFAULT_IMAGE_WIDTH);
    	mImageResource.setProperty(Resource.IMAGE_HEIGHT, DEFAULT_IMAGE_HEIGHT);
    	// HO 19/12/2010 END ************
    	this.setIcon();

		// HO 17/12/2010 BEGIN ***********
		// persistence only
		this.setSaveImageFile(mImageFile.toString());
		// HO 17/12/2010 END *************
	}
	
	public void setImageFile(File f) {
	
		mImageFile = f;
	}
	
	public File getImageFile() {
		
		return mImageFile;
	} 
	
    /** persistance only */
    public String getSaveImageFile() {
        return saveImageFile == null ? null : saveImageFile.toString();
    }

    /** persistance only */
    public void setSaveImageFile(String path) {
        saveImageFile = path;
    }
	
	public void setImageResource(Resource r) {
		
		mImageResource = r;
	}
	
	public void setImageResource(File f) {
		mImageResource = new LWMap("dummy map").getResourceFactory().get(f);
	}
	
	public Resource getImageResource() {
		
		return mImageResource;
	} 
	
	public void setIcon() {
		
		mIcon = new IBISIssueIcon();
	}
	
	public IBISImageIcon getIcon() {
		
		return mIcon;
	}
}
