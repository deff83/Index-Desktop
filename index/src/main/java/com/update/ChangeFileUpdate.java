package com.update;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.Table.stage.DownLoadStage;
import com.mashape.unirest.http.exceptions.UnirestException;

import domain.Release;
import javafx.application.Platform;
import javafx.stage.Stage;

public class ChangeFileUpdate {
	private static ChangeFileUpdate changeFileUpdate = new ChangeFileUpdate();
	private File nameFile = null;
	private ChangeFileUpdate() {
	}
	public static ChangeFileUpdate getInstance() {
		return changeFileUpdate;
	}
	public boolean isChange(String specificRelease, DownLoadStage downloadstage) {
	    GithubUtility update = new GithubUtility("deff83", "Index-Desktop", specificRelease);
		Release release = null;
    	File location = new File(".");
		try {
		    release = update.getLatestRelease();
		    if (release.getTag_name().equals(specificRelease)) {
                return true;
            }
		} catch (UnirestException ex) {
		   
		} catch (Exception e) {}
		Logger.getLogger(ChangeFileUpdate.class.getName()).info(release+"");
		if(release!=null) {
			 
			File file = null;
			try {
				update.setDownloadstage(downloadstage);
			    file = update.downloadAssetToSpecificLocation(location.toPath(), release.getAssets().get(0));
			    nameFile = file;
			} catch (UnirestException ex) {
			   
			} catch (IOException ex) {
			   
			}
		}
		return false;
	}
	public File getNameFile() {
		return nameFile;
	}
}
