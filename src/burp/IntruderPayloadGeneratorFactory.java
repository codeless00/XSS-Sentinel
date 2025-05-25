package burp;

public class IntruderPayloadGeneratorFactory implements IIntruderPayloadGeneratorFactory {

    public IntruderPayloadGeneratorFactory(IBurpExtenderCallbacks callbacks, BurpExtender burpExtender) {
        //TODO Auto-generated constructor stub
    }

    @Override
    public String getGeneratorName() {
        // TODO Auto-generated method stub
        return "custom-intruder";
    }

    @Override
    public IIntruderPayloadGenerator createNewInstance(IIntruderAttack attack) {
        // TODO Auto-generated method stub
        IIntruderPayloadGenerator iIntruderPayloadGenerator = new IIntruderPayloadGenerator() {

            @Override
            public boolean hasMorePayloads() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'hasMorePayloads'");
            }

            @Override
            public byte[] getNextPayload(byte[] baseValue) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'getNextPayload'");
            }

            @Override
            public void reset() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'reset'");
            }
            
        };
        return iIntruderPayloadGenerator;
    }
    
}
