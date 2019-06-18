package test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import AmbroseRen.util.Tools;
import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;

public class ScanPort {
	public static void main(String[] args) {
		listPortChoices();
	}
    public static void listPortChoices() {
    	CommPortIdentifier COM5 =null;
        CommPortIdentifier portId;
        Enumeration en = CommPortIdentifier.getPortIdentifiers();
        // iterate through the ports.
        while (en.hasMoreElements()) {
            portId = (CommPortIdentifier) en.nextElement();
            if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
                System.out.println(portId.getName());
            }
        }
        try {
			COM5 = CommPortIdentifier.getPortIdentifier("COM5");
			try {
				SerialPort serialCOM5 = (SerialPort) COM5.open("COM5Listener", 1000);
				System.out.println("serialCOM5=="+serialCOM5);
	            String order ="0xFF,0x54,0x0D";
	            byte[] order1 = Tools.hexStringToByteArray(order);
				try {
					InputStream inputStream = serialCOM5.getInputStream();
					while(true){						
						inputStream.read(order1);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (PortInUseException e) {
				e.printStackTrace();
			}
		} catch (NoSuchPortException e) {
			e.printStackTrace();
		}
    }
}
