package s_Exercises.MySolution_FileIO_ClosingExample;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class AddressManager {
    private List<Address> addressList = new ArrayList<>();

    public void add(Address a) {
        addressList.add(a);
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    /*
    public void exportToCsv(String path, String separator) throws AddressExportException {
        File file = new File(path);
        if (file.exists()) {
            throw new AddressExportFileAlreadyExistsException("File already exists: " + path);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Address address : addressList) {
                writer.write(address.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new AddressExportException("Error exporting addresses: " + e.getMessage());
        }
    }
    */

    public void exportToCsv(String path, String separator) throws AddressExportException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            for (Address address : addressList) {
                writer.write(address.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new AddressExportException("Error exporting addresses: " + e.getMessage());
        }
    }

    public void loadFromCsv(String path, String separator) throws AddressLoadException {
        File file = new File(path);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(separator);
                if (values.length != 4) {
                    throw new AddressLoadWrongFormatException("Wrong format in CSV file: " + path);
                }

                String firstname = values[0];
                String lastname = values[1];
                String mobileNumber = values[2];
                String email = values[3];

                Address address = new Address(firstname, lastname, mobileNumber, email);
                addressList.add(address);

                // Print the loaded addresses
                List<Address> addressList = getAddressList();
                for (Address add1 : addressList) {
                    System.out.println(add1.getFirstname() + separator +
                            add1.getLastname() + separator +
                            add1.getMobileNumber() + separator +
                            add1.getEmail());
                }
            }
        } catch (IOException e) {
            throw new AddressLoadException("Error loading addresses: " + e.getMessage());
        }
    }
}