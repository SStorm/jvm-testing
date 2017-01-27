/**
 * Copyright 2017 IMONT Technologies
 * Created by romanas on 27/01/2017.
 */
package io.imont.sdk.skelmir;

import gnu.io.CommPortIdentifier;
import gnu.io.RXTXPort;

import static gnu.io.SerialPort.*;

public class SerialMain {

    private static final int RECEIVE_TIMEOUT = 100;

    private static final int DEFAULT_PORT = 2000;

    public static void main(String[] args) throws Exception {
        CommPortIdentifier ident = CommPortIdentifier.getPortIdentifier("/dev/ttyUSB0");

        RXTXPort serial = ident.open("NRSerialPort", DEFAULT_PORT);
        serial.enableReceiveTimeout(RECEIVE_TIMEOUT);
        serial.setSerialPortParams(5000, DATABITS_8, STOPBITS_1, PARITY_NONE);
        serial.disableReceiveTimeout();
        serial.notifyOnDataAvailable(true);
        serial.notifyOnCTS(true);
    }
}
