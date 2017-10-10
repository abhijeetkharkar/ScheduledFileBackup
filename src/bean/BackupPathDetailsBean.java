package bean;

public class BackupPathDetailsBean
{
	private String sourceFolder;
	private String destinationFolder;
	private boolean isBackupAllRequired;
	private boolean isFileOverwriteRequired;
	private boolean actionFile;
	private boolean isFolderOverwriteRequired;
	private boolean actionFolder;
	private boolean isFolderContentToBeBackedUp;
	private String filesForBackup;
	private String otherParameters;
	
	public boolean isActionFile() {
		return actionFile;
	}
	public void setActionFile(boolean actionFile) {
		this.actionFile = actionFile;
	}
	public boolean isActionFolder() {
		return actionFolder;
	}
	public void setActionFolder(boolean actionFolder) {
		this.actionFolder = actionFolder;
	}	
	public String getSourceFolder() {
		return sourceFolder;
	}
	public void setSourceFolder(String sourceFolder) {
		this.sourceFolder = sourceFolder;
	}
	public String getDestinationFolder() {
		return destinationFolder;
	}
	public void setDestinationFolder(String destinationFolder) {
		this.destinationFolder = destinationFolder;
	}
	public boolean isBackupAllRequired() {
		return isBackupAllRequired;
	}
	public void setBackupAllRequired(boolean isBackupAllRequired) {
		this.isBackupAllRequired = isBackupAllRequired;
	}
	public boolean isFileOverwriteRequired() {
		return isFileOverwriteRequired;
	}
	public void setFileOverwriteRequired(boolean isFileOverwriteRequired) {
		this.isFileOverwriteRequired = isFileOverwriteRequired;
	}
	public boolean isFolderOverwriteRequired() {
		return isFolderOverwriteRequired;
	}
	public void setFolderOverwriteRequired(boolean isFolderOverwriteRequired) {
		this.isFolderOverwriteRequired = isFolderOverwriteRequired;
	}
	public boolean isFolderContentToBeBackedUp() {
		return isFolderContentToBeBackedUp;
	}
	public void setFolderContentToBeBackedUp(boolean isFolderContentToBeBackedUp) {
		this.isFolderContentToBeBackedUp = isFolderContentToBeBackedUp;
	}
	public String getFilesForBackup() {
		return filesForBackup;
	}
	public void setFilesForBackup(String filesForBackup) {
		this.filesForBackup = filesForBackup;
	}
	public String getOtherParameters() {
		return otherParameters;
	}
	public void setOtherParameters(String otherParameters) {
		this.otherParameters = otherParameters;
	}
}