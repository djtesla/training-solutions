package stringmethods.filename;

public class FileNameManipulator {


    public char findLastCharacter(String str) {
        if (isEmpty(str)) {
        throw new IllegalArgumentException("Empty string!");
        }
        String trimmedStr = str.trim();
        return trimmedStr.charAt(trimmedStr.length() - 1);
    }



    public boolean isEmpty (String str) {
        return str == null || str.isBlank();
    }



    public String findFileExtension(String fileName) {
        if (isEmpty(fileName) || exceptionHandlerForFileName(fileName)) {
            throw new IllegalArgumentException("Invalid file name!");
        }
        int i = fileName.indexOf('.');
        return fileName.substring(i);
    }



    public boolean identifyFilesByExtension(String ext, String fileName) {
        if     (isEmpty(fileName) || exceptionHandlerForFileName(fileName) ||
                isEmpty(ext))
        {
            throw new IllegalArgumentException("Invalid argument!");
        }
        int i = fileName.indexOf('.');
        String fileExt = fileName.substring(i + 1);
        return fileExt.equals(ext);
    }



    public boolean compareFilesByName(String searchedFileName, String actualFileName) {
        if (isEmpty(searchedFileName) || exceptionHandlerForFileName(searchedFileName) ||
                isEmpty(actualFileName) || exceptionHandlerForFileName(actualFileName)) {
            throw new IllegalArgumentException("Invalid argument!");
        }
        return searchedFileName.toLowerCase().equals(actualFileName.toLowerCase());
    }



    public boolean exceptionHandlerForFileName (String fileName) {
        return     (!isEmpty(fileName)
                && !fileName.contains(".")
                ||  fileName.indexOf(".") == 0
                ||  fileName.indexOf(".") == fileName.length()-1);
    }



    public String changeExtensionToLowerCase (String fileName) {
        if (exceptionHandlerForFileName(fileName)) {
            throw new IllegalArgumentException("Invalid argument!");
        }
        if (isEmpty(fileName)) {
            throw new IllegalArgumentException("Empty string!");
        }
        int i = fileName.indexOf('.');
        String fileExt = fileName.substring(i + 1);
        return fileName.replace(fileExt, fileExt.toLowerCase());
    }




    public String replaceStringPart (String fileName, String present, String target) {
        if (isEmpty(fileName)) {
            throw new IllegalArgumentException("Empty string!");
        }
        return fileName.replace(present, target);
    }


}

