# FileUtils
ContentTypeUtil
CopyFileUtil
DateUtils
DownloadFileUtil
FileUtil

-------------------------------------
##read file test with file 5.5GB 
-------------------------------------

Time taken by Java Util Scanner = 345805873271

345805873271ns = 5.76 minutes

Time taken by Stream Common IO Apache = 199105532573

199105532573ns = 3.32 minutes


-------------------------------------
##reference:
http://www.baeldung.com/java-read-lines-large-file
-------------------------------------


-------------------------------------
##copy file test result with file 5.5GB
-------------------------------------

Time taken by FileStreams Copy = 192416485932
Time taken by FileChannels Copy = 241697883273
Time taken by Java7 Files Copy = 261281536511
Time taken by Apache Commons IO Copy = 237092876382


-------------------------------------
##copy file test result with file < 1GB
-------------------------------------
Time taken by FileStreams Copy = 14990006088
Time taken by FileChannels Copy = 10473824481
Time taken by Java7 Files Copy = 14000058295
Time taken by Apache Commons IO Copy = 17644227576
