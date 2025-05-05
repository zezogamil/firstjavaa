import java.net.*;
import java.util.Enumeration;
import java.util.List;

public class Interfaces {
    public static void main(String[] args) {
        try {
            System.out.println("\n=== TASK 1: ALL NETWORK INTERFACES ===");
            listAllInterfaces();

            if (args.length > 0) {
                System.out.println("\n=== TASK 2: DETAILS OF SELECTED INTERFACE (" + args[0] + ") ===");
                displayInterfaceDetails(args[0]);
            } else {
                System.out.println("\n[Skipping Task 2: No interface name provided as an argument]");
            }

            System.out.println("\n=== TASK 3: NON-VIRTUAL INTERFACES WITH MTU, IP ADDRESSES ===");
            listNonVirtualInterfaces();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // TASK 1: List all available interfaces and their MAC addresses
    private static void listAllInterfaces() throws SocketException {
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        while (interfaces.hasMoreElements()) {
            NetworkInterface ni = interfaces.nextElement();
            byte[] mac = ni.getHardwareAddress();
            System.out.println(ni.getDisplayName() + ": " + formatMacAddress(mac));
        }
    }

    // TASK 2: Display details of a specific network interface
    private static void displayInterfaceDetails(String interfaceName) {
        try {
            NetworkInterface ni = NetworkInterface.getByName(interfaceName);
            if (ni == null) {
                System.out.println("No such interface found.");
                return;
            }

            System.out.println("Interface Name: " + ni.getName());
            System.out.println("MAC Address: " + formatMacAddress(ni.getHardwareAddress()));

            Enumeration<InetAddress> inetAddresses = ni.getInetAddresses();
            while (inetAddresses.hasMoreElements()) {
                InetAddress addr = inetAddresses.nextElement();
                System.out.println("IP Address: " + addr.getHostAddress());
            }
        } catch (SocketException e) {
            System.out.println("Error retrieving interface details.");
        }
    }

    // TASK 3: List non-virtual network interfaces with details
    private static void listNonVirtualInterfaces() throws SocketException {
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        while (interfaces.hasMoreElements()) {
            NetworkInterface ni = interfaces.nextElement();

            // Skip virtual interfaces
            if (ni.isVirtual()) continue;

            System.out.print("Interface: " + ni.getName());

            // Label loopback interface
            if (ni.isLoopback()) {
                System.out.print(" (loopback)");
            }
            System.out.println("\nMTU: " + ni.getMTU());

            List<InterfaceAddress> addresses = ni.getInterfaceAddresses();
            for (InterfaceAddress addr : addresses) {
                System.out.println("  IP Address: " + addr.getAddress());
                System.out.println("  Subnet Mask: " + getSubnetMask(addr.getNetworkPrefixLength()));
                System.out.println("  Broadcast Address: " + addr.getBroadcast());
            }
            System.out.println("------------------------------------------------------");
        }
    }

    // Format MAC addresses in hexadecimal
    private static String formatMacAddress(byte[] mac) {
        if (mac == null) return "N/A";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mac.length; i++) {
            sb.append(String.format("%02X", mac[i]));
            if (i < mac.length - 1) {
                sb.append("-");
            }
        }
        return sb.toString();
    }

    // Convert prefix length to subnet mask
    private static String getSubnetMask(int prefixLength) {
        int mask = 0xffffffff << (32 - prefixLength);
        return ((mask >> 24) & 0xff) + "." + ((mask >> 16) & 0xff) + "." +
                ((mask >> 8) & 0xff) + "." + (mask & 0xff);
    }
}
