package worker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

import bean.BackupPathDetailsBean;
import exception.FileBackupException;

public class FileBackupWorker
{
	public FileBackupWorker(String pathsFileLocation, int parametersCount) throws FileBackupException
	{
		readPathsFile(new File(pathsFileLocation), parametersCount);
	}
	
	private void readPathsFile(File pathsFile, int parametersCount) throws FileBackupException
	{
		try
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(pathsFile)));
			String iniString=null;
			ArrayList<BackupPathDetailsBean> backupPathDetailsList=new ArrayList<BackupPathDetailsBean>();
			BackupPathDetailsBean backupPathDetailsBean=null;
			while((iniString=br.readLine())!=null)
			{
				String parametersList[]=iniString.split("#~#");
				if(parametersList.length!=parametersCount)
					throw new FileBackupException("Improper File Format; File should have "+(parametersCount-1)+" "+(((parametersCount-1)==0||(parametersCount-1==1))?"delimiter.":"delimiters."));
				else if(new File(parametersList[1]).isFile())
					throw new FileBackupException("Invalid Destination Path. Destination should be a folder.");
				else
				{
					backupPathDetailsBean=new BackupPathDetailsBean();
					backupPathDetailsBean.setSourceFolder(parametersList[0]);
					backupPathDetailsBean.setDestinationFolder(parametersList[1]);
					backupPathDetailsList.add(backupPathDetailsBean);
				}
			}
			br.close();
			createBackup(backupPathDetailsList);
		}
		catch (FileNotFoundException e)
		{
			throw new FileBackupException("Specified file path is invalid.");
		}
		catch (IOException e)
		{
			throw new FileBackupException("Unable to read data from the Master Paths file.");
		}
	}
	
	private void createBackup(ArrayList<BackupPathDetailsBean> backupPathDetailsList) throws FileBackupException
	{
		for(int i=0;i<backupPathDetailsList.size();i++)
		{
			File source=new File(backupPathDetailsList.get(i).getSourceFolder());
			File destination=new File(backupPathDetailsList.get(i).getDestinationFolder());
			if(source.isFile())
			{
				try
				{
					Files.copy(source.toPath(), destination.toPath(),StandardCopyOption.REPLACE_EXISTING);
				}
				catch (IOException e)
				{
					throw new FileBackupException("Unable to read/write data from/to the source/destination : "+source.getAbsolutePath()+" / "+destination.getAbsolutePath());
				}
			}
			else
			{
				
			}
		}
	}
}
