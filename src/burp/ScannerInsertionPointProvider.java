package burp;

import java.util.ArrayList;
import java.util.List;

public class ScannerInsertionPointProvider implements IScannerInsertionPointProvider {

    IBurpExtenderCallbacks callbacks;
    BurpExtender burpExtender;

    public ScannerInsertionPointProvider(IBurpExtenderCallbacks callbacks, BurpExtender burpExtender) {
        this.callbacks = callbacks;
        this.burpExtender = burpExtender;
    }

    @Override
    public List<IScannerInsertionPoint> getInsertionPoints(IHttpRequestResponse baseRequestResponse) {

        List<IScannerInsertionPoint> iScannerInsertionPoints = new ArrayList<>();
        // TODO Auto-generated method stub
        IScannerInsertionPoint scannerInsertionPoint = new IScannerInsertionPoint() {

            @Override
            public String getInsertionPointName() {
                // TODO Auto-generated method stub
            return "Custom-Insertion-Point1.0";
            }

            @Override
            public String getBaseValue() {
                // TODO Auto-generated method stub
                return "Base-value";
            }

            @Override
            public byte[] buildRequest(byte[] payload) {
                String req = "GET / HTTP/1.1\r\nHost: www.google.com\r\n\r\n";
                byte[] req_byte = req.getBytes();
                return req_byte;
                // TODO Auto-generated method stub
                // throw new UnsupportedOperationException("Unimplemented method 'buildRequest'");
            }

            @Override
            public int[] getPayloadOffsets(byte[] payload) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public byte getInsertionPointType() {
                // TODO Auto-generated method stub
                return 0x7f;
            }
            
        };

        iScannerInsertionPoints.add(scannerInsertionPoint);
        return iScannerInsertionPoints;
    }
    
}
