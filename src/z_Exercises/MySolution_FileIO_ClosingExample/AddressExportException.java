package z_Exercises.MySolution_FileIO_ClosingExample;

public class AddressExportException extends Exception {
    public AddressExportException(String message) {
        super(message);
    }
}

class AddressExportFileAlreadyExistsException extends AddressExportException {
    public AddressExportFileAlreadyExistsException(String message) {
        super(message);
    }
}

class AddressLoadException extends Exception {
    public AddressLoadException(String message) {
        super(message);
    }
}

class AddressLoadWrongFormatException extends AddressLoadException {
    public AddressLoadWrongFormatException(String message) {
        super(message);
    }
}

class AddressLoadFileNotFoundException extends AddressLoadException {
    public AddressLoadFileNotFoundException(String message) {
        super(message);
    }
}