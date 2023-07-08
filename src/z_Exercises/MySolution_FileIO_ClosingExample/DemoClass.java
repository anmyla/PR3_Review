package z_Exercises.MySolution_FileIO_ClosingExample;

import java.util.List;

public class DemoClass {
    public static void main(String[] args) {
        AddressManager addressManager = new AddressManager();

        // Add addresses to the addressManager
        Address address1 = new Address("Ping", "Pong", "123456789", "ping.pong@example.com");
        Address address2 = new Address("King", "Kong", "987654321", "king.kong@example.com");
        Address address3 = new Address("Ding", "Dong", "147258369", "ding.dong@example.com");
        addressManager.add(address1);
        addressManager.add(address2);

        try {
            // Export addresses to CSV
            addressManager.exportToCsv("addresses.csv", ";");
            System.out.println("Addresses exported to CSV successfully.");

            // Load addresses from CSV
            addressManager.loadFromCsv("addresses.csv", ";");
            System.out.println("Addresses loaded from CSV successfully.");

            // Print the loaded addresses
            List<Address> loadedAddresses = addressManager.getAddressList();
            for (Address address : loadedAddresses) {
                System.out.println(address.getFirstname() + " " +
                        address.getLastname() + ", " +
                        address.getMobileNumber() + ", " +
                        address.getEmail());
            }
        } catch (AddressExportException e) {
            System.out.println("Error exporting to addresses: " + e.getMessage());
        } catch (AddressLoadFileNotFoundException e) {
            System.out.println("Error loading addresses: " + e.getMessage());
        } catch (AddressLoadWrongFormatException e) {
            System.out.println("Error loading addresses: " + e.getMessage());
        } catch (AddressLoadException e) {
            System.out.println("Error loading addresses: " + e.getMessage());
        }
    }
}
