package utilities;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlobDirectory;
import com.microsoft.azure.storage.blob.CloudBlockBlob;
import com.microsoft.azure.storage.blob.ListBlobItem;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AzureBlobFileDownload {

	public static final String STORAGE_CONNECTION_STRING = "DefaultEndpointsProtocol=https;"
			+ "AccountName=aecpstorageprod;" // Your account name.
			+ "AccountKey=iy2z3VeLKSKtBsPhmUeIjkwcuMOfEepkATE1KVsyLaS252gRuCsOcBu5XYQF4eW7cra8kJBwQsv4oFoEfmjPFA==;" // your
																														// account
																														// key.
			+ "EndpointSuffix=core.windows.net";
	private static final Logger LOGGER = Logger.getLogger(AzureBlobFileDownload.class.getName());

	public static void M() throws IOException {
		try {
			CloudStorageAccount account = CloudStorageAccount.parse(STORAGE_CONNECTION_STRING);
			CloudBlobClient serviceClient = account.createCloudBlobClient();
			File file = new File("D:\\WorkInno\\Poonam\\New folder");
			if (!file.exists()) {
				// Create the directory
				if (file.mkdir()) {
					System.out.println("Directory created successfully: " + file.getAbsolutePath());
				} else {
					System.err.println("Failed to create directory: " + file.getAbsolutePath());
				}
			}
			// Accessing the container to download files
			CloudBlobContainer container = serviceClient.getContainerReference("finance");
			CloudBlobDirectory downloadDirectory = container.getDirectoryReference("MissingAccountingPeriodReport");
			// Creating a backup container if does not exists.
			// CloudBlobContainer container1 =
			// serviceClient.getContainerReference("backupsicontainer");
			container.createIfNotExists();
			// container1.createIfNotExists();
			// Iterating through all the blobs in the container
			Iterable<ListBlobItem> blobs = downloadDirectory.listBlobs();
			for (ListBlobItem blob : blobs) {
				// Accessing the file name from the blobs in the container inorder to create the
				// same in the backup container.
				String[] str1 = blob.getUri().toString().split("/");
				File f = new File(file.getAbsolutePath() + "\\" + str1[5]);
				CloudBlockBlob cloudBlob = (CloudBlockBlob) blob;
				// Downloading files from the container
				cloudBlob.downloadToFile(f.toString());
				// cloudBlob.delete();
				LOGGER.log(Level.INFO, "File downloaded successfylly & deleted from the container");
				break;
			}
		} catch (StorageException | URISyntaxException | InvalidKeyException exception) {

			LOGGER.log(Level.SEVERE, exception.getMessage());
			System.exit(-1);
		}
	}
}