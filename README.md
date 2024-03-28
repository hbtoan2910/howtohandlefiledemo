# HowToHandleFileInJava

## A small java app to demonstrate how handle files (create file, folder (directory), copy, & rename)


### Add files into this ./src/storage/inputFolder and run the application

  1/ Copy files from this location to other location (note: using input/outputstream takes long time, in reality, we should use Files.copy())
  
  2/ Rename files from this location to other location, and we better make a copy of these files to new folder before renaming.

     Method: file.renameTo() will give the origin files new names and move them (with their new names) to other location, which means, in current folder, origin files are no longer there.


#### Note:

Về cơ bản:

  1/ để đọc/ghi file binary (file ảnh, âm thanh, phim ...) nên dùng FileInputStream/FileOutputStream (Byte Stream). 
  
  Ngoài ra, ByteArrayInputStream/ByteArrayOutputStream và DataInputStream/DataOutputStream cũng thuộc (Byte Stream)
  
  2/ để đọc/ghi file text (txt) nên dùng FileReader/FileWriter (Character Stream)
