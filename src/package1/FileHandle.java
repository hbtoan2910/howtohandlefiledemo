package package1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class FileHandle {

	
	public static void main(String[] args) {
		
		/**** 1. Copy a text file into new text file using fileInputStream & fileOutputStream ****/	
        /*
		try (FileInputStream input = new FileInputStream("./src/input.txt");
             FileOutputStream output = new FileOutputStream("./src/output.txt")) {

            int c;
            // Đọc lần lượt các byte (8bit) trong luồng và lưu vào biến c
            // Khi đọc ra giá trị -1 nghĩa là kết thúc luồng.
            while ((c = input.read()) != -1) {
            	System.out.println("value of c: " + c + " <> " + (char)c);
                output.write(c);
            }

            System.out.println("Done writing data to output file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
		
		/*
		try (FileInputStream input = new FileInputStream("./src/input.txt");
	             FileOutputStream output = new FileOutputStream("./src/output.txt")) {

	            int c;
	            byte[] bytes = new byte[10]; //This creates a new array with a length of 10 bytes. Each element in the array can hold a byte of data.
	            
	         // Tại 1 thời điểm đọc 10 bytes
	            while ((c = input.read(bytes)) != -1) {
	            	System.out.println("value of c: " + c);
	            	System.out.println(new String(bytes,0,c));
	                output.write(bytes,0,c);
	            }

	            System.out.println("Done writing data to output file.");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		*/
		
        /**** 2. Copy a video file (mp4) into new video file using fileInputStream & fileOutputStream ****/
        /*
        try (FileInputStream input = new FileInputStream("./src/abs_workout.mp4");
                FileOutputStream output = new FileOutputStream("./src/abs_workout_copy.mp4")) {

               int c;
               // Đọc lần lượt các byte (8bit) trong luồng và lưu vào biến c
               // Khi đọc ra giá trị -1 nghĩa là kết thúc luồng.
               while ((c = input.read()) != -1) {
               	System.out.println("value of c: " + c + " <> " + (char)c);
                   output.write(c);
               }

               System.out.println("Done writing data to output file.");
           } catch (IOException e) {
               e.printStackTrace();
           }
        */
        
		File myFolder = new File("./src/storage/inputFolder");		
		File copyToFolder = new File("./src/storage/copyToFolder");
		File renameToFolder = new File("./src/storage/renameToFolder");
		File archiveFolder = new File("./src/storage/archiveFolder");
		
		/**** 3. Copy files From-To section - quite slow speed if using input/output stream, in real should use Files.copy() ****/	
		/*
		try {
			if (myFolder.exists() && myFolder.isDirectory()) {
				if (!copyToFolder.exists()) {
					if (!copyToFolder.mkdir()) {
						throw new IOException("Failed to create directory: " + copyToFolder.getPath());
					}
				}
				
				File[] files = myFolder.listFiles();
				
				if (files != null && files.length > 0) {
					for (int i = 0; i < files.length; i++) {
						File file = files[i];						
						if (file.isFile()) {
							try (	FileInputStream in = new FileInputStream(file);
									FileOutputStream out = new FileOutputStream(new File(copyToFolder, "Chenchen_" + (i+1) + ".jpg"))	) {
								
								int c;
								while ((c = in.read()) != -1) {
									out.write(c);
								}
								if (in != null) {
									in.close();
								}
								if (out != null) {
									out.close();
								}
								System.out.println("File: " + "Chenchen_" + (i+1) + ".jpg" + " was copied properly into /renamed folder.");
								
							} catch (IOException e) {
								System.out.println("Error occured while copying file: " + file.getName());
								e.printStackTrace();
							}
						}
					
					}
					System.out.println("ALL DONE ^^");
				}
			} else {
				System.out.println("Not a valid folder");
			}
		} catch(Exception e) {
			System.out.println("Error occurred while creating directory or listing files.");
			e.printStackTrace();
		}
		*/
		

		
		/**** 4. Rename files From-To section ****/
		/*
		try {
			if (myFolder.exists() && myFolder.isDirectory()) {
				if (!renameToFolder.exists()) {
					if (!renameToFolder.mkdir()) {
						throw new IOException("Failed to create directory: " + renameToFolder.getPath());
					}
				}
				
				File[] files = myFolder.listFiles();
				
				if (files != null && files.length > 0) {
					for (int i = 0; i < files.length; i++) {
						File file = files[i];						
						if (file.isFile()) {
								File newFile = new File(renameToFolder, "Chenchen_" + (i+1) + ".jpg");
								if (!newFile.exists()) {
									//As default, if transaction is successful, old files will be renamed and also moved to new folder
									//So we do this step to create a copy of origin files to a new folder before execute renameTo()
									if (!archiveFolder.exists()) {
										if (!archiveFolder.mkdir()) {
											throw new IOException("Failed to create directory: " + archiveFolder.getPath());
										}
									}
			
									File archiveFile = new File("./src/storage/archiveFolder/" + file.getName());
									Files.copy(file.toPath(), archiveFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

									
									if (file.renameTo(new File(renameToFolder, "Chenchen_" + (i+1) + ".jpg"))) {										
										System.out.println("File: " + file.getName() + " was renamed properly into /renameToFolder with new name: " + newFile.getName());
									} else {
										System.out.println("Renaming failed.");
									}
								} else {
									System.out.println("File: Chenchen_" + (i+1) + ".jpg already existed inside /renameToFolder. Action aborted.");
								}
								
						} else {
							System.out.println("No file to process");
						}					
					}
				}
			} else {
				System.out.println("Not a valid folder");
			}
		} catch(Exception e) {
			System.out.println("Error occurred while creating directory or listing files.");
			e.printStackTrace();
		}
		*/
    }
}
